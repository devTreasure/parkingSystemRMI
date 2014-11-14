package ParkingSystem.Test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import ParkingSystem.Entities.Ticket;
import ParkingSystem.controller.PaymentManagement;
import ParkingSystem.controller.TicketManagement;

public class PaymentManagementTest {

	PaymentManagement paymanager = new PaymentManagement();

	@Test
	public void CalculateFareBasedOnTheParkingHourandParkingDuaration() {

		TicketManagement t = new TicketManagement();
		Ticket newticket = t.createTicket();

		java.util.Date d1 = null;
		java.util.Date d2 = null;

		// Setting time of 30 minutes and hourly rate of 15/S per hour
		String dateStart = "01/14/2012  09:00:00";
		String dateStop = " 01/14/2012  09:30:00";

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		try {
			d1 = format.parse(dateStart);
			newticket.setEntryTime(d1);

			d2 = format.parse(dateStop);
			newticket.setExitTime(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		paymanager.setHourlyRate(15);

		newticket.setExitTime(d2);

		double amountfare = paymanager.calculateParkingDuration(newticket);

		assertEquals(7.5, amountfare, 0.1);

	}
	
	

}
