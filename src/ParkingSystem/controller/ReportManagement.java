package ParkingSystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Reports.HourlyData;
import ParkingSystem.Reports.HourlyReport;
import ParkingSystem.Reports.ReportCreator;

public class ReportManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TicketManagement ticketManagement;

	public ReportManagement(TicketManagement ticketManagement)
	{
		super();
		this.ticketManagement = ticketManagement;
	}

	public List<HourlyData> generateReport(ReportType reportType,	List<Ticket> allTickets,Date dt)
	{
		 List<Ticket> newallTickets=null;
		 allTickets = ticketManagement.getTicketcollection();
		
		List<HourlyData> data =null;
		
		
		
			data= ReportCreator.getReport(reportType).getReport(allTickets,dt);
			
	
	
		
	
		
		
		return data;
	}
	
	
	
}
