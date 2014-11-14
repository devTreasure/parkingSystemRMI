package ParkingSystem.controller;

import java.util.Date;
import java.util.List;

import ParkingSystem.Entities.ReportType;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.Reports.ReportCreator;

public class ReportManagement {

	private TicketManagement ticketManagement;

	public ReportManagement(TicketManagement ticketManagement) {
		super();
		this.ticketManagement = ticketManagement;
	}

	public List<Ticket> generateReport(ReportType reportType)
	{
		List<Ticket> newallTickets=null;
		List<Ticket> allTickets = ticketManagement.getTicketcollection();
		
		if(reportType==ReportType.Weekly)
		{
			for (Ticket ticket : allTickets) {
				
			
				
				
			}
		}
		
	
		
		List<Ticket> data = ReportCreator.getReport(reportType).getReport(allTickets);
		return data;
	}
	
	
	
}
