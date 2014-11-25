package cs414.a5.bhavinp.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class HourlyData implements Serializable {
	String timeperiod;
	Date entrydt;
	UUID ticketid;
	Date exitdt;
	int hourlyEntry = 0;
	int hourlyExit = 0;

	public int getHourlyExit() {
		return hourlyExit;
	}

	public void setHourlyExit(int hourlyExit) {
		this.hourlyExit = hourlyExit;
	}

	public String getTimeperiod() {
		return timeperiod;
	}

	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

	public Date getEntrydt() {
		return entrydt;
	}

	public void setEntrydt(Date entrydt) {
		this.entrydt = entrydt;
	}

	public UUID getTicketid() {
		return ticketid;
	}

	public void setTicketid(UUID ticketid) {
		this.ticketid = ticketid;
	}

	public Date getExitdt() {
		return exitdt;
	}

	public void setExitdt(Date exitdt) {
		this.exitdt = exitdt;
	}

	public int getHourlyEntry() {
		return hourlyEntry;
	}

	public void setHourlyEntry(int hourlyEntry) {
		this.hourlyEntry = hourlyEntry;
	}

}
