package cs414.a5.bhavinp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cs414.a5.bhavinp.entities.Gate;
import cs414.a5.bhavinp.entities.Ticket;

public class TicketManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ticket ticket;

	private Gate gate;

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
