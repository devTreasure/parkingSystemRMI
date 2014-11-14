package ParkingSystem.Reports;

import java.util.List;

import ParkingSystem.Entities.Ticket;

public class MonthlyReport implements Report {

	@Override
	public List<Ticket> getReport(List<Ticket> allTickets) {

		return allTickets;
	}

}
