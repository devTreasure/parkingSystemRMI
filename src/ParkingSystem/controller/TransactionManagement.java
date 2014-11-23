package ParkingSystem.controller;

import java.io.Serializable;
import java.util.Calendar;

import javax.swing.JOptionPane;

import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Status;

public class TransactionManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO: add all ticket transaction in collection for report ,yearly,monthly
	// weekly calculation

	CreditPaymentGateWay paymentgateway = new CreditPaymentGateWay();

	public Status ProcessTheTransaction(CreditCard card) {

		Boolean transactionProcessed = false;

		Status status = isvalidCreditCard(card);

		if (status.isSuccessMessage() && card.getAmount() > 0) {
			// processing amount
			if (paymentgateway.makePayment(card.getAmount())) {
				card.setAmount(0);
				transactionProcessed = true;

			}
		}

		return status;
	}

	public TransactionManagement() {

	}

	public Boolean validateTheYear(CreditCard card) {
		Calendar cal = Calendar.getInstance();
		Boolean validentry = false;

		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH) + 1;

		Status status;

		String entermonth[] = new String[2];

		try {
			String string = card.getExpiryDate();
			String[] parts = string.split("/");

			if (parts.length > 0) {

				int month = Integer.parseInt(parts[0]);
				int year = Integer.parseInt(parts[1]);

				if (year < currentYear) {
					validentry = false;
				}
				if (year >= currentYear) {

					if (month < currentMonth) {
						validentry = false;
					}
					if (month >= currentMonth) {
						validentry = true;
					}
				}

			}

		} catch (Exception e) {

		}

		return validentry;
	}

	private Status isvalidCreditCard(CreditCard card) {

		// Boolean isverified = false;
		Status status = null;

		if (card.getCCNumner().length() == 16 && (this.validateTheYear(card))) {

			status = new Status(true, "card is valid");

		} else {
			status = new Status(false, "Please Enter Valid Credit Card number");

		}

		return status;
	}
}
