package ParkingSystem.Reports;

import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.Ticket;

public class WeeklyReport implements Report {

	@Override
	public List<HourlyData> getReport(List<Ticket> allTickets,Date dt) {
		 List<HourlyData>  weeklyData=null;
		 
		return weeklyData;
	}

}
