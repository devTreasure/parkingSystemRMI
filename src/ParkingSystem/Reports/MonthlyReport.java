package ParkingSystem.Reports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.Ticket;

public class MonthlyReport implements Report {

	@Override
	public List<HourlyData> getReport(List<Ticket> allTickets, Date stDate) {
		//CalculateMonthyStatistics(allTickets, stDate);
		 List<HourlyData>   monthlyData=null;
        return monthlyData;
	}

}
