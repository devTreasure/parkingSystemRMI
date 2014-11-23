package ParkingSystem.Reports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.Ticket;

public class DailyReport implements Report {

	@Override
	public List<HourlyData> getReport(List<Ticket> allTickets, Date dt) {

		List<HourlyData> dailyCollection = calculateDailyStatistics(allTickets,	dt);
		return dailyCollection;
	}

	private List<HourlyData> calculateDailyStatistics(List<Ticket> allTickets,Date stDate) 
	{
		List<HourlyData> reportHourly = new ArrayList<HourlyData>();
		List<HourlyData> exitdata = new ArrayList<HourlyData>();

		SimpleDateFormat hrly = new SimpleDateFormat("MM/dd/yy");

		String strdt = hrly.format(stDate);

		int k = 0;
		int y = 0;

		while (y <= 11.59) {
			HourlyData datacount = null;
			HourlyData data = null;
			HourlyData Exitdata = null;

			int count = 0;
			int hour = 0;
			int exitcount = 0;

			data = new HourlyData();

			k = y;

			data.setTimeperiod(String.format("Hours %d -  %d", k, ++k));

			reportHourly.add(data);

			for (Ticket t : allTickets) {

				if (hrly.format(t.getEntryTime()).equals(strdt)) {

					if ((t.getEntryTime() != null && t.getEntryTime()
							.getHours() == y)) {

						if (t.getEntryTime().getMinutes() <= 59) {
							data = new HourlyData();

							count++;
							hour = y;

							data.setEntrydt(t.getEntryTime());
							data.setTicketid(t.getTicektID());

							reportHourly.add(data);

						}

					}

					if ((t.getExitTime() != null && t.getExitTime().getHours() == y)) {

						if (t.getExitTime().getMinutes() <= 59) {
							Exitdata = new HourlyData();

							exitcount++;

							hour = y;

							Exitdata.setExitdt(t.getExitTime());
							Exitdata.setTicketid(t.getTicektID());

							reportHourly.add(Exitdata);

						}

					}

				}

			}

			datacount = new HourlyData();
			HourlyData dataExitcount = new HourlyData();

			datacount.setHourlyEntry(count);
			dataExitcount.setHourlyExit(exitcount);

			if (count > 0)
				reportHourly.add(datacount);
			if (exitcount > 0)
				reportHourly.add(dataExitcount);

			y++;
		}

		return reportHourly;

	}

}
