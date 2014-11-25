package cs414.a5.bhavinp.reports;

import cs414.a5.bhavinp.entities.ReportType;

public class ReportCreator {

	public static Report getReport(ReportType reportType) {
		if (reportType == ReportType.Hourly)
			return new HourlyReport();
		else if (reportType == reportType.Daily)
			return new DailyReport();
		else if (reportType == ReportType.Weekly)
			return new WeeklyReport();
		else if (reportType == ReportType.Monthly)
			return new MonthlyReport();
		else
			return new MonthlyReport();
	}

}
