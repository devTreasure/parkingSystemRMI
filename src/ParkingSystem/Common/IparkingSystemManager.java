package ParkingSystem.Common;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.UUID;








import ParkingSystem.Entities.CreditCard;
import ParkingSystem.Entities.ParkingStatus;
import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Status;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Reports.HourlyData;
import ParkingSystem.controller.FraudPreventionManagement;
import ParkingSystem.controller.GateManagement;
import ParkingSystem.controller.OccupancyManagement;
import ParkingSystem.controller.PaymentManagement;
import ParkingSystem.controller.ReportManagement;
import ParkingSystem.controller.TicketManagement;

public interface IparkingSystemManager extends java.rmi.Remote {


//	public GateManagement getGatemanagement() throws RemoteException;
//
//	public TicketManagement getTicketmager() throws RemoteException;
//
//	public PaymentManagement getPaymanager() throws RemoteException;
//
//	public FraudPreventionManagement getFraudManager() throws RemoteException;
//
//	public OccupancyManagement getOccupancy() throws RemoteException;
//
//	public ReportManagement getReportManagement() throws RemoteException;
//
//	public Ticket getTicket() throws RemoteException;

	public void setTicket(Ticket ticket) throws RemoteException;

	public Status processExitFor(UUID ticketID) throws RemoteException;

	public Ticket printTicketOperation() throws RemoteException;

	public void PerformFareProcessment() throws RemoteException;

	public void calculateFare(Ticket ticket) throws RemoteException;

	public double processPayment(Ticket ticket, CreditCard card) throws RemoteException;

	public Status openEntryGateFor(String currentTicketId, int gateNumber) throws RemoteException;
	
	public Status performExitGateOperationFor(String ticketID) throws RemoteException;

	public void initialize(int parkingCapacity, int hourlyRate) throws RemoteException;

	public Status closeTheEntryGate(int gateID) throws RemoteException;

	public Status calculateFare(String ticketID) throws RemoteException;
	
	public Ticket getThetheTicketStatusAfterExitOperation(String TicektID) throws RemoteException;
	
	public int getTheParkingOccupancy() throws RemoteException;
	
	public Boolean isCurrentparkingFull() throws RemoteException;
	
	public ParkingStatus getTheCurrentparkingStatus() throws RemoteException;
	
	public Ticket getTheTicketfromID(String strID) throws RemoteException;
	
	public Ticket getTheTicketFromNamePlate(String nampePlateID) throws RemoteException;
	
	public List<HourlyData> getTheDataCollectionforReport(ReportType rptType,Date date) throws RemoteException;
	
	public CreditCard  getCreditCard() throws RemoteException;
	
	public PaymentManagement  getThePaymanager() throws RemoteException;
	
	

}
