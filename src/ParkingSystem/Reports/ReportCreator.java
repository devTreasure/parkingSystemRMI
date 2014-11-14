package ParkingSystem.Reports;

import ParkingSystem.Entities.ReportType;

public class ReportCreator {
	
	public static Report  getReport(ReportType reportType)
	{
	  if(reportType==ReportType.Hourly)
		  return  new HourlyReport();
	  else if(reportType==reportType.Daily)
		  return  new DailyReport();
	  else if(reportType==ReportType.Weekly)
		  return new WeeklyReport();
	  else if(reportType==ReportType.Monthly)
		  return new MonthlyReport();
	  else
		  return new  MonthlyReport();
	}

}
