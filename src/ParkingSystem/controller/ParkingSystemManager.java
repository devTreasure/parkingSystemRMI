package ParkingSystem.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.UUID;

import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.GateStatus;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Entities.TicketStatus;
import ParkingSystem.Common.IparkingSystemManager;

public class ParkingSystemManager extends java.rmi.server.UnicastRemoteObject

implements IparkingSystemManager, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GateManagement gatemanagement = new GateManagement();
	private TicketManagement ticketmager = new TicketManagement();
	private PaymentManagement paymanager = new PaymentManagement();
	private OccupancyManagement occupancy = new OccupancyManagement();
	private FraudPreventionManagement fraudManager = new FraudPreventionManagement();
	private ReportManagement reportManagement = new ReportManagement(
			ticketmager);

	public Ticket ticket;

	public ParkingSystemManager() throws java.rmi.RemoteException {
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

	public Status processExitFor(UUID ticketID) throws RemoteException {

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
			// Exit is only through one exit
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

	public void printTicketOperation() throws RemoteException {

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

	public void calculateFare(Ticket ticket) throws RemoteException {

		Calendar c = Calendar.getInstance();

		java.util.Date currenttime = c.getTime();

		ticket.setExitTime(currenttime);

		Double rate = paymanager.calculateParkingDuration(ticket);

		ticket.setTicketAmount(rate);

	}

	// Strategy has been implemented so this method is refactored

	public double processPayment(Ticket ticket, CreditCard card)
			throws RemoteException {

		// associating ticket id to credit card id
		Status status = null;

		if (card != null) {
			this.paymanager.getCreditCard().setTicketID(ticket.getTicektID());

			if (fraudManager.isValidTicket(ticket))
				status = this.paymanager.processForParkingFeePayment(ticket,
						card);
		} else {
			if (fraudManager.isValidTicket(ticket))
				status = this.paymanager
						.processCashForParkingFeePayment(ticket);
		}

		double ticektAmount = ticket.getTicketAmount();

		return ticektAmount;
	}

	@Override
	public void PerformFareProcessment() throws RemoteException {
		// TODO Auto-generated method stub

	}

	public Ticket findTicket(String namePlate) {
		// TODO Auto-generated method stub

		// Ticket t=
		// ticketmager.getTicketcollection().contains(t.getNamePlate()==namePlate);
		Ticket foundTicket = null;

		for (Ticket t : ticketmager.getTicketcollection()) {
			if (t.getNamePlate().equals(namePlate)) {
				foundTicket = t;
			}
		}

		return foundTicket;
	}

	public Ticket findTicketFromID(String ticketID) {
		// TODO Auto-generated method stub

		// Ticket t=
		// ticketmager.getTicketcollection().contains(t.getNamePlate()==namePlate);
		Ticket foundTicket = null;

		UUID tid = UUID.fromString(ticketID);

		for (Ticket t : ticketmager.getTicketcollection()) {
			if (t.getTicektID().compareTo(tid) == 0) {
				foundTicket = t;
			}
		}

		return foundTicket;
	}

	//TODO Can be re-named to allowVehicleEntry
	@Override
	public Status openEntryGateFor(String currentTicketId, int gateNumber) {
		
		String gateStatus = "";
		Gate gate = null;
		Ticket currentTicket = findTicketFromID(currentTicketId);
		if(currentTicket == null && TicketStatus.Active.equals(currentTicket)) {
			
			gate = getGatemanagement().OpenEntryGate(gateNumber);

			// added for fraud
			// prevention check
			getFraudManager().ticketgatecollection.put(currentTicket, gate);

			//Simulate time to open and close.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//Do nothing
			}
			
			if (getGatemanagement().gate.gateStatus == GateStatus.Open) {
				gate = getGatemanagement().closeEntryGate(gateNumber);
			}
			gateStatus = gate.gateStatus.toString(); 

		} else {
			gateStatus = "Invalid Ticket";
		}
		
		return new Status(true, gateStatus);
		
	}

	@Override
	public void initialize(int parkingCapacity, int hourlyRate) {
		getOccupancy().setParkingCapacity(parkingCapacity);
		getPaymanager().setHourlyRate(hourlyRate);
	}

	@Override
	public void closeEntryGate(int gateID) {
		getGatemanagement().closeEntryGate(gateID);
	}

	@Override
	public Status calculateFare(String ticketID) throws RemoteException {

		Ticket ticket = findTicketFromID(ticketID);

		calculateFare(ticket);

		Status status = new Status(true, "" + ticket.getTicketAmount());
		return status;
	}

}
