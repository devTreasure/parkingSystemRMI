package ParkingSystem.Entities;

import java.util.Date;
import java.util.UUID;

public class Cash {

	
	private UUID TicketID;
	private double Amount;
	private Date paymentDate;
	
	public Cash()
	{
		
	}
	
		
	public UUID getTicketID() {
		return TicketID;
	}
	public void setTicketID(UUID ticketID) {
		TicketID = ticketID;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
