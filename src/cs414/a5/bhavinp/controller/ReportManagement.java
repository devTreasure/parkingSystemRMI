package cs414.a5.bhavinp.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cs414.a5.bhavinp.entities.ReportType;
import cs414.a5.bhavinp.entities.Ticket;
import cs414.a5.bhavinp.reports.HourlyData;
import cs414.a5.bhavinp.reports.HourlyReport;
import cs414.a5.bhavinp.reports.ReportCreator;

public class ReportManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TicketManagement ticketManagement;

	public ReportManagement(TicketManagement ticketManagement) {
		super();
		this.ticketManagement = ticketManagement;
	}

	public List<HourlyData> generateReport(ReportType reportType, Date dt) {
		List<Ticket> newallTickets = null;
		List<Ticket> allTickets = ticketManagement.getTicketcollection();

		List<HourlyData> data = null;

		data = ReportCreator.getReport(reportType).getReport(allTickets, dt);

		return data;
	}

}
