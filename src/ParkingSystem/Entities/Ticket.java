package ParkingSystem.Entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ticektStatus == null) ? 0 : ticektStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (ticektStatus != other.ticektStatus)
			return false;
		return true;
	}

	private Gate gate;
	private Date entryTime;
	private Date exitTime;
	private TicketStatus ticektStatus;
	private UUID ticketID;
	private double ticketAmount;
	private Boolean isPaid;
    private double parkingDuration;

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public UUID generateTicketID() {
		UUID id = UUID.randomUUID();
		this.ticketID = id;
		return id;
	}

	public UUID getTicektID() {
		return ticketID;
	}

	public UUID getTicketID() {
		return ticketID;
	}

	public void setTicketID(UUID ticketID) {
		this.ticketID = ticketID;
	}

	public Gate getGate() {
		return gate;
	}

	public void setGate(Gate gate) {
		this.gate = gate;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}

	public TicketStatus getTicektStatus() {
		return ticektStatus;
	}

	public void setTicektStatus(TicketStatus ticektStatus) {
		this.ticektStatus = ticektStatus;
	}

	public Ticket() {
		Calendar c = Calendar.getInstance();

		java.util.Date currenttime = c.getTime();

		this.entryTime = currenttime;
		this.ticketID = this.generateTicketID();
		;
	}

	public void activatetheTicektStatus() {
		// deacitvated -(void) ticket can not be acitvated again
		if (!(this.ticektStatus == TicketStatus.Void))
			this.ticektStatus = TicketStatus.Active;
	}

	public void deactivatetheTicektStatus() {
		this.ticektStatus = TicketStatus.Void;
	}

	public double getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	public double getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(double parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

}
