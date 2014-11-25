package cs414.a5.bhavinp.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import cs414.a5.bhavinp.controller.NamePlateGenerator;

public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Gate gate;
	private Date entryTime;
	private Date exitTime;
	private TicketStatus ticektStatus;
	private UUID ticketID;
	private double ticketAmount;
	private Boolean isPaid;
	private double parkingDuration;
	private String namePlate;

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

	public String generatenamepPate() {

		String namePlate = NamePlateGenerator.generateLicensePlate();
		return namePlate;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entryTime == null) ? 0 : entryTime.hashCode());
		result = prime * result
				+ ((exitTime == null) ? 0 : exitTime.hashCode());
		result = prime * result + ((gate == null) ? 0 : gate.hashCode());
		result = prime * result + ((isPaid == null) ? 0 : isPaid.hashCode());
		result = prime * result
				+ ((namePlate == null) ? 0 : namePlate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(parkingDuration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((ticektStatus == null) ? 0 : ticektStatus.hashCode());
		temp = Double.doubleToLongBits(ticketAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((ticketID == null) ? 0 : ticketID.hashCode());
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
		if (entryTime == null) {
			if (other.entryTime != null)
				return false;
		} else if (!entryTime.equals(other.entryTime))
			return false;
		if (exitTime == null) {
			if (other.exitTime != null)
				return false;
		} else if (!exitTime.equals(other.exitTime))
			return false;
		if (gate == null) {
			if (other.gate != null)
				return false;
		} else if (!gate.equals(other.gate))
			return false;
		if (isPaid == null) {
			if (other.isPaid != null)
				return false;
		} else if (!isPaid.equals(other.isPaid))
			return false;
		if (namePlate == null) {
			if (other.namePlate != null)
				return false;
		} else if (!namePlate.equals(other.namePlate))
			return false;
		if (Double.doubleToLongBits(parkingDuration) != Double
				.doubleToLongBits(other.parkingDuration))
			return false;
		if (ticektStatus != other.ticektStatus)
			return false;
		if (Double.doubleToLongBits(ticketAmount) != Double
				.doubleToLongBits(other.ticketAmount))
			return false;
		if (ticketID == null) {
			if (other.ticketID != null)
				return false;
		} else if (!ticketID.equals(other.ticketID))
			return false;
		return true;
	}

	public Ticket() {
		Calendar c = Calendar.getInstance();

		java.util.Date currenttime = c.getTime();

		this.entryTime = currenttime;
		this.ticketID = this.generateTicketID();
		this.namePlate = this.generatenamepPate();
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

	public String getNamePlate() {
		return namePlate;
	}

	public void setNamePlate(String namePlate) {
		this.namePlate = namePlate;
	}

}
