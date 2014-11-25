package cs414.a5.bhavinp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cs414.a5.bhavinp.entities.Cash;
import cs414.a5.bhavinp.entities.CreditCard;
import cs414.a5.bhavinp.entities.Status;
import cs414.a5.bhavinp.entities.Ticket;
import cs414.a5.bhavinp.entities.paymentStratagy;
import cs414.a5.bhavinp.reports.ReportCollection;

public class PaymentManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CreditCard creditCard;

	private Cash cashpayment;

	private int hourlyRate;
	private List<CreditCard> creditcollection = new ArrayList<CreditCard>();

	private List<Cash> cashPaymentcollection = new ArrayList<Cash>();

	public List<Cash> getCashPaymentcollection() {
		return cashPaymentcollection;
	}

	public void setCashPaymentcollection(Cash cash) {
		this.cashPaymentcollection.add(cash);
	}

	private List<ReportCollection> creditReportcollection = new ArrayList<ReportCollection>();

	// private paymentStratagy strategy;

	public void setCreditcollection(CreditCard creditcollection) {
		this.creditcollection.add(creditcollection);
	}

	public List<ReportCollection> getCreditReportcollection() {
		return creditReportcollection;
	}

	public void setCreditReportcollection(ReportCollection rpt) {
		this.creditReportcollection.add(rpt);
	}

	public List<CreditCard> getCreditcollection() {
		return creditcollection;

	}

	public List<Cash> getPaymentcollection() {
		return cashPaymentcollection;
	}

	public TransactionManagement getTransactionManager() {
		return transactionManager;
	}

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

	public Status processForParkingFeePayment(Ticket ticket, CreditCard card)

	{
		ReportCollection c = new ReportCollection();

		c.setCCNumner(card.getCCNumner());
		c.setTicketID(card.getTicketID());
		c.setAmount(card.getAmount());
		c.setCreditcardpaymentTime(card.getCreditcardpaymentTime());

		creditReportcollection.add(c);

		creditcollection.add(card);

		Status isSuccessfull = null;

		if (ticket.getTicketAmount() > 0) {
			card.setAmount(ticket.getTicketAmount());
			isSuccessfull = transactionManager.ProcessTheTransaction(card);
		}
		ticket.setTicketAmount(0);// amount paid and due is set 0

		ticket.setIsPaid(true);

		return isSuccessfull;
	}

	public Status processCashForParkingFeePayment(Ticket ticket)

	{
		// creditcollection.add(card);
		Status isSuccessful = null;

		Calendar cal = Calendar.getInstance();

		Date paymentdate = cal.getTime();

		Cash objCash = new Cash();

		objCash.setPaymentDate(paymentdate);

		// if(ticket.amount>0)
		// objCash.setAmount(amount);

		if (ticket.getTicketAmount() > 0) {
			objCash.setTicketID(ticket.getTicektID());
			objCash.setAmount(ticket.getTicketAmount());

			cashPaymentcollection.add(objCash);

			// Boolean isSuccessfull=true;
			isSuccessful = new Status(true, "Payment has been successful");

			// Boolean isSuccessfull =
			// transactionManager.ProcessTheTransaction(card);
		}

		ticket.setTicketAmount(0);// amount paid and due is set 0

		ticket.setIsPaid(true);

		return isSuccessful;

	}

	public double calculateParkingDuration(Ticket ticket) {
		// TODO Auto-generated method stub

		long parkingDuration = (ticket.getExitTime().getTime() - ticket.getEntryTime().getTime());

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
