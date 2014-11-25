package cs414.a5.bhavinp.reports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.rmi.CORBA.Util;

import cs414.a5.bhavinp.entities.Ticket;

public class WeeklyReport implements Report {

	@Override
	public List<HourlyData> getReport(List<Ticket> allTickets, Date dt) {
		List<HourlyData> weeklyData = null;
		weeklyData = calculateWeeklyStatistics(allTickets, dt);
		return weeklyData;
	}

	private List<HourlyData> calculateWeeklyStatistics(List<Ticket> allTickets,	Date stDate) 
	{
		List<HourlyData> reportHourly = new ArrayList<HourlyData>();
		List<HourlyData> exitdata = new ArrayList<HourlyData>();

		SimpleDateFormat hrly = new SimpleDateFormat("MM/dd/yy");

		String strdt = hrly.format(stDate);

		Calendar cal = Calendar.getInstance();

		cal.setTime(stDate);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - cal.getFirstDayOfWeek();
		cal.add(Calendar.DAY_OF_MONTH, -dayOfWeek);

		Date weekStart = cal.getTime();
		// we do not need the same day a week after, that's why use 6, not 7
		cal.add(Calendar.DAY_OF_MONTH, 6);
		Date weekEnd = cal.getTime();

		Date loopDt = weekStart;

		int k = 0;
		int y = 0;

		while (loopDt.before(weekEnd))
		
		{
			String Strloopdt= hrly.format(loopDt);
		   
			while (y <= 11.59)

			{
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

					if (hrly.format(t.getEntryTime()).equals(Strloopdt)) {

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

						if ((t.getExitTime() != null && t.getExitTime()
								.getHours() == y)) {

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

			Calendar newcal = Calendar.getInstance();
			newcal.setTime(loopDt);
			newcal.add(Calendar.DAY_OF_MONTH, 1);
			loopDt = newcal.getTime();

		}

		return reportHourly;

	}

}
