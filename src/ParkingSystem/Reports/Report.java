package ParkingSystem.Reports;

import java.util.List;

import ParkingSystem.Entities.Ticket;

public interface Report {
	
	public List<Ticket> getReport(List<Ticket> allTickets);

}
