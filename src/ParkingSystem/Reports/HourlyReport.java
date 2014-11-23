package ParkingSystem.Reports;

import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.Ticket;

public class HourlyReport implements Report {

	@Override
	public List<HourlyData> getReport(List<Ticket> allTickets,Date dt) {
		
		List<HourlyData>  hourlyData=null;
		
		return hourlyData;
	}

}
