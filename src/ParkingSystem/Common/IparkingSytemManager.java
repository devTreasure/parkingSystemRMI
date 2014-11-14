package ParkingSystem.Common;

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

public interface IparkingSytemManager extends java.rmi.Remote {

	public GateManagement getGatemanagement();

	public TicketManagement getTicketmager();

	public PaymentManagement getPaymanager();

	public FraudPreventionManagement getFraudManager();

	public OccupancyManagement getOccupancy();

	public ReportManagement getReportManagement();

	public Ticket getTicket();

	public void setTicket(Ticket ticket);

	public Status processExitFor(UUID ticketID);

	public void printTicketOperation();

	public void PerformFareProcessment();

	public void calculateFare(Ticket ticket);

	public double processPayment(Ticket ticket, CreditCard card);

}
