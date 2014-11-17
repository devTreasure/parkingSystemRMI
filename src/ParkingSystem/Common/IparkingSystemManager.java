package ParkingSystem.Common;

import java.rmi.RemoteException;
import java.util.UUID;


import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.controller.FraudPreventionManagement;
import ParkingSystem.controller.GateManagement;
import ParkingSystem.controller.OccupancyManagement;
import ParkingSystem.controller.PaymentManagement;
import ParkingSystem.controller.ReportManagement;
import ParkingSystem.controller.TicketManagement;

public interface IparkingSystemManager    extends java.rmi.Remote {


	public GateManagement getGatemanagement() throws RemoteException;

	public TicketManagement getTicketmager() throws RemoteException;

	public PaymentManagement getPaymanager() throws RemoteException;

	public FraudPreventionManagement getFraudManager() throws RemoteException;

	public OccupancyManagement getOccupancy() throws RemoteException;

	public ReportManagement getReportManagement() throws RemoteException;

	public Ticket getTicket() throws RemoteException;

	public void setTicket(Ticket ticket) throws RemoteException;

	public Status processExitFor(UUID ticketID) throws RemoteException;

	public void printTicketOperation() throws RemoteException;

	public void PerformFareProcessment() throws RemoteException;

	public void calculateFare(Ticket ticket) throws RemoteException;

	public double processPayment(Ticket ticket, CreditCard card) throws RemoteException;

}
