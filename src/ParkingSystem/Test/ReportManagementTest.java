package ParkingSystem.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Reports.DailyReport;
import ParkingSystem.Reports.HourlyReport;
import ParkingSystem.Reports.MonthlyReport;
import ParkingSystem.Reports.Report;
import ParkingSystem.Reports.ReportCreator;
import ParkingSystem.Reports.WeeklyReport;
import ParkingSystem.controller.ReportManagement;
import ParkingSystem.controller.TicketManagement;

public class ReportManagementTest {

	@Test
	public void reportShouldreturnHourlyReportbasedOnHourlyChoiseSelection()

	{

		Report report = ReportCreator.getReport(ReportType.Hourly);

		assertTrue(report instanceof HourlyReport);
	}

	@Test
	public void reportShouldreturnWeeklyReportbasedOnWeeklyChoiseSelection()

	{

		Report report = ReportCreator.getReport(ReportType.Weekly);

		assertTrue(report instanceof WeeklyReport);
	}

	@Test
	public void reportShouldreturnDailyReportbasedOnDailyChoiseSelection()

	{

		Report report = ReportCreator.getReport(ReportType.Daily);

		assertTrue(report instanceof DailyReport);
	}

	@Test
	public void reportShouldreturnMonthlyReportbasedOnMonthlyChoiseSelection()

	{

		Report report = ReportCreator.getReport(ReportType.Monthly);

		assertTrue(report instanceof MonthlyReport);
	}

	@Test
	public void GeneratemethodShoudReturnTicketCollectionFOrReport() {

		TicketManagement ticketManagement = new TicketManagement();

		List<Ticket> tickets = new ArrayList<Ticket>();

		tickets.add(new Ticket());

		// new ticket added in collection
		ticketManagement.setTicketcollection(tickets);

		ReportManagement reportmanagement = new ReportManagement(ticketManagement);

		List<Ticket> list = reportmanagement.generateReport(ReportType.Hourly);

		assertEquals(list.size(), 1);

	}
	
	

}