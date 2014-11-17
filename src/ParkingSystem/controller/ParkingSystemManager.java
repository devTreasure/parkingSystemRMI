package ParkingSystem.controller;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.UUID;

import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;

import ParkingSystem.Common.IparkingSystemManager;

public class ParkingSystemManager   extends java.rmi.server.UnicastRemoteObject

implements IparkingSystemManager, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public GateManagement getGatemanagement()  throws RemoteException {
		return gatemanagement;
	}

	public TicketManagement getTicketmager  ()   throws RemoteException
	{
		return ticketmager;
	}

	public PaymentManagement getPaymanager()  throws RemoteException {
		return paymanager;
	}
	
	

	public FraudPreventionManagement getFraudManager()  throws RemoteException{
		return fraudManager;
	}

	public OccupancyManagement getOccupancy()  throws RemoteException{
		return occupancy;
	}
	
	

	public ReportManagement getReportManagement()  throws RemoteException {
		return reportManagement;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Status processExitFor(UUID ticketID)   throws RemoteException{

		Status status = null;
		Ticket ticket = null;
		for (Ticket t : ticketmager.getTicketcollection()) {
			if (t.getTicektID().compareTo(ticketID) == 0) {
				ticket = t;
			}
			// TODO add your handling code here:
		}


		if (fraudManager.checkNoExitWithoutPay(ticket)){

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

	public void printTicketOperation()  throws RemoteException {

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



	public void calculateFare(Ticket ticket)  throws RemoteException {
		
		Calendar c = Calendar.getInstance();

		java.util.Date currenttime = c.getTime();

	
		ticket.setExitTime(currenttime);

		Double rate = paymanager.calculateParkingDuration(ticket);

		ticket.setTicketAmount(rate);

	}

	public double processPayment(Ticket ticket, CreditCard card)  throws RemoteException {


		// associating ticket id to credit card id
		this.paymanager.getCreditCard().setTicketID(ticket.getTicektID());

		if (fraudManager.isValidTicket(ticket))
			this.paymanager.processForParkingFeePayment(ticket, card);

		double ticektAmount = ticket.getTicketAmount();

		return ticektAmount;
	}

	@Override
	public void PerformFareProcessment() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	



}
