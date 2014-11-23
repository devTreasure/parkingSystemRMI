package ParkingSystem.Reports;

import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.Ticket;

public interface Report {

	public List<HourlyData> getReport(List<Ticket> allTickets, Date dt);

}
