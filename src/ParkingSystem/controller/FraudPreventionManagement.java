package ParkingSystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.GateStatus;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Entities.TicketStatus;

public class FraudPreventionManagement  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Ticket> ticketcollection = new ArrayList<Ticket>();

	private List<Gate> gatecollection = new ArrayList<Gate>();

	public Map<Ticket, Gate> ticketgatecollection = new HashMap<Ticket, Gate>();
	

	public FraudPreventionManagement() {

	}



	public Boolean checkNoExitWithoutPay(Ticket ticket) {
				
		if(isValidTicket(ticket)  &&  ticket.getIsPaid())
			return true;
		else
			return true;
	}

	public Boolean checkNoEntryWithoutTicket(Ticket ticket,Gate g) {
		
		Boolean isvalidEntry;
		
		if(isValidTicket(ticket))
		{
		  g.gateStatus=GateStatus.Open;
		  isvalidEntry=true;
		}
		else
		{
			  g.gateStatus=GateStatus.Close;
			  isvalidEntry=false;
		}
		
			
		return isvalidEntry;
	}


	public Boolean isValidTicket(Ticket ticket) {
		
		if((ticket != null && ticket.getTicektStatus() == TicketStatus.Active))
			return true;
		else
		   return false;
	}

	public List<Ticket> getTicketcollection() {
		return ticketcollection;
	}

	public void setTicketcollection(List<Ticket> ticketcollection) {
		this.ticketcollection = ticketcollection;
	}

	public void checkentryExitOperation() {
		for (Map.Entry<Ticket, Gate> entry : ticketgatecollection.entrySet()) {
			Ticket key = entry.getKey();
			Gate value = entry.getValue();

		}

	}

}
