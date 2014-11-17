package ParkingSystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.Ticket;

public class TicketManagement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ticket ticket;

	private Gate gate;
	// TODO: review the code for  any tight coupling , use low coupling refactoring.

	private List<Ticket> ticketcollection = new ArrayList<Ticket>();
	
	
	public void printTicket() {

		// TODO Auto-generated method stub

	}
	
	public Ticket createTicket() {
		
		Ticket newTicket = new Ticket();
		// New ticket added to collection
		this.ticket = newTicket;
		ticketcollection.add(ticket);
		return ticket;
	}
	
	public List<Ticket> getTicketcollection() {
		return ticketcollection;
	}

	public void setTicketcollection(List<Ticket> ticketcollection) {
		this.ticketcollection = ticketcollection;
	}

	public void updateTicketStaus() {
		// TODO Auto-generated method stub
		this.ticket.activatetheTicektStatus();
	}

	public void deactivatetheTicektStatus() {

	}

	// TODO: please determine that TicketManagement will assign the gate or
	// during the ticket generation
	// gate will be assigned.

}
