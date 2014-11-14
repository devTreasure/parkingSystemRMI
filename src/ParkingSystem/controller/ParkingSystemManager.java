package ParkingSystem.controller;

import java.util.Calendar;
import java.util.UUID;

import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Client.UI.parkingGUI;
import ParkingSystem.Common.IparkingSytemManager;

public class ParkingSystemManager  extends java.rmi.server.UnicastRemoteObject
implements IparkingSytemManager    {

	private GateManagement gatemanagement = new GateManagement();
	private TicketManagement ticketmager = new TicketManagement();
	private PaymentManagement paymanager = new PaymentManagement();
	private OccupancyManagement occupancy = new OccupancyManagement();
	private FraudPreventionManagement fraudManager = new FraudPreventionManagement();
	private ReportManagement reportManagement = new ReportManagement(ticketmager);

	public Ticket ticket;

	public ParkingSystemManager() 
		  throws java.rmi.RemoteException {
              super();
	}

	public GateManagement getGatemanagement() {
		return gatemanagement;
	}

	public TicketManagement getTicketmager() {
		return ticketmager;
	}

	public PaymentManagement getPaymanager() {
		return paymanager;
	}
	
	

	public FraudPreventionManagement getFraudManager() {
		return fraudManager;
	}

	public OccupancyManagement getOccupancy() {
		return occupancy;
	}
	
	

	public ReportManagement getReportManagement() {
		return reportManagement;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Status processExitFor(UUID ticketID) {

		Status status = null;
		Ticket ticket = null;
		for (Ticket t : ticketmager.getTicketcollection()) {
			if (t.getTicektID().compareTo(ticketID) == 0) {
				ticket = t;
			}
			// TODO add your handling code here:
		}


		if (fraudManager.checkNoExitWithoutPay(ticket)) {

			ticket.deactivatetheTicektStatus();
          //Exit is only through one exit
			Gate g1 = gatemanagement.openExitGate(1);

			fraudManager.ticketgatecollection.put(ticket, g1);

			Gate g2 = gatemanagement.closeExitGate(1);

			occupancy.decrementOcccupancy();

			fraudManager.ticketgatecollection.put(ticket, g2);

			status = new Status(true, "Vehicle exited from gate.");

		} else {
			status = new Status(true, "Unknown vehicle. Inform security.");
		}
		return status;
	}

	public void printTicketOperation() {

		// TODO add your handling code here:

		final Ticket ticket = ticketmager.createTicket();

		ticket.activatetheTicektStatus();
		ticket.generateTicketID();

		if (fraudManager.isValidTicket(ticket)) {
			this.ticket = ticket;

			occupancy.incrementOcccupancy();

			Thread ts = new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						Thread.sleep(2000);

					} catch (InterruptedException e) {

					}

				}
			});

			ts.start();
		}

	}

	public void PerformFareProcessment() {

	}

	public void calculateFare(Ticket ticket) {
		
		Calendar c = Calendar.getInstance();

		java.util.Date currenttime = c.getTime();

	
		ticket.setExitTime(currenttime);

		Double rate = paymanager.calculateParkingDuration(ticket);

		ticket.setTicketAmount(rate);

	}

	public double processPayment(Ticket ticket, CreditCard card) {


		// associating ticket id to credit card id
		this.paymanager.getCreditCard().setTicketID(ticket.getTicektID());

		if (fraudManager.isValidTicket(ticket))
			this.paymanager.processForParkingFeePayment(ticket, card);

		double ticektAmount = ticket.getTicketAmount();

		return ticektAmount;
	}

	public ParkingSystemManager(parkingGUI parkingGUI)   
			throws java.rmi.RemoteException {
        super();
        }

}
