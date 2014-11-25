package cs414.a5.bhavinp.common;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cs414.a5.bhavinp.controller.FraudPreventionManagement;
import cs414.a5.bhavinp.controller.GateManagement;
import cs414.a5.bhavinp.controller.OccupancyManagement;
import cs414.a5.bhavinp.controller.PaymentManagement;
import cs414.a5.bhavinp.controller.ReportManagement;
import cs414.a5.bhavinp.controller.TicketManagement;
import cs414.a5.bhavinp.entities.Cash;
import cs414.a5.bhavinp.entities.CreditCard;
import cs414.a5.bhavinp.entities.ParkingStatus;
import cs414.a5.bhavinp.entities.PaymentType;
import cs414.a5.bhavinp.entities.ReportType;
import cs414.a5.bhavinp.entities.Status;
import cs414.a5.bhavinp.entities.Ticket;
import cs414.a5.bhavinp.reports.HourlyData;
import cs414.a5.bhavinp.reports.ReportCollection;

public interface IparkingSystemManager extends java.rmi.Remote {

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

	public List<HourlyData> getTheDataCollectionforReport(ReportType rptType, Date date) throws RemoteException;

	public Ticket makePayment(CreditCard card, String ticketId, PaymentType type) throws RemoteException;

	public List<ReportCollection> getCreditReportcollection() throws RemoteException;

	public List<Cash> getCashReportcollection() throws RemoteException;

	public Ticket makePayment(Double fare, String ticketId, PaymentType type) throws RemoteException;

}
