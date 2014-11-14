package ParkingSystem.Reports;

import java.util.List;

import ParkingSystem.Entities.Ticket;

public class WeeklyReport implements Report {

	@Override
	public List<Ticket> getReport(List<Ticket> allTickets) {

		return allTickets;
	}

}
