package cs414.a5.bhavinp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class CreditCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CCNumner;
	private String expiryDate;
	private int cvvNumber;
	private double amount;
	private Date creditcardpaymentTime;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private UUID ticketID;

	public CreditCard() {

	}

	public String getCCNumner() {
		return CCNumner;
	}

	public void setCCNumner(String cCNumner) {
		CCNumner = cCNumner;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public UUID getTicketID() {
		return ticketID;
	}

	public void setTicketID(UUID ticketID) {
		this.ticketID = ticketID;
	}

	public Date getCreditcardpaymentTime() {
		return creditcardpaymentTime;
	}

	public void setCreditcardpaymentTime(Date creditcardpaymentTime) {
		this.creditcardpaymentTime = creditcardpaymentTime;
	}
}
