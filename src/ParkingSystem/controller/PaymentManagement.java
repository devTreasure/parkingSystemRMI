package ParkingSystem.controller;

import java.util.ArrayList;
import java.util.List;

import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Ticket;

public class PaymentManagement {

	private CreditCard creditCard;

	private int hourlyRate;
	private List<CreditCard> creditcollection = new ArrayList<CreditCard>();
	public TransactionManagement transactionManager = new TransactionManagement();

	public PaymentManagement() {
		creditCard = new CreditCard();
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public void processForParkingFeePayment(Ticket ticket, CreditCard card)

	{
		creditcollection.add(card);
	
		if (ticket.getTicketAmount() > 0) {
			card.setAmount(ticket.getTicketAmount());
			Boolean isSuccessfull = transactionManager.ProcessTheTransaction(card);
		}
		ticket.setTicketAmount(0);// amount paid and due is set 0

		ticket.setIsPaid(true);

	}

	public double calculateParkingDuration(Ticket ticket) {
		// TODO Auto-generated method stub

		long parkingDuration = (ticket.getExitTime().getTime() - ticket
				.getEntryTime().getTime());

		double caluclatedTimeinSec;
		double caluclatedTimeinMinutes;
		double caluclatedTimeinHr;

		caluclatedTimeinSec = parkingDuration / 1000;

		caluclatedTimeinMinutes = caluclatedTimeinSec / 60;

		caluclatedTimeinHr = caluclatedTimeinMinutes / 60;

		// Stamping parking duration to the ticket
		ticket.setParkingDuration(caluclatedTimeinHr);

		return ((this.hourlyRate) * ticket.getParkingDuration());

	}

}
