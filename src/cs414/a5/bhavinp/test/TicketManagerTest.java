package cs414.a5.bhavinp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs414.a5.bhavinp.controller.TicketManagement;
import cs414.a5.bhavinp.entities.Ticket;
import cs414.a5.bhavinp.entities.TicketStatus;

public class TicketManagerTest {

	@Test
	public void creteTicketMethodcreatesNewTicketObject() {

		TicketManagement t = new TicketManagement();
		Ticket newticket = t.createTicket();
		Ticket ts = new Ticket();

		assertEquals(newticket, ts);

	}

	@Test
	public void newlycreatedticketMustHavesuniqueParkingID() {
		TicketManagement t = new TicketManagement();
		Ticket newticket = t.createTicket();
		Ticket ts = new Ticket();

		assertNotEquals(newticket.generateTicketID(), ts.generateTicketID());
	}

	@Test
	public void newlyCreatedTicketMustbeAddedInTicketCollectionSystem() {

		TicketManagement t = new TicketManagement();
		Ticket newticket = t.createTicket();
		Ticket ts = new Ticket();

		Boolean isTicektinCollection = t.getTicketcollection().contains(
				newticket);
		assertEquals(true, isTicektinCollection);

	}

	@Test
	public void deactivatedTicketCannotbeReactivated() {
		TicketManagement t = new TicketManagement();
		Ticket newticket = t.createTicket();
		Ticket ts = new Ticket();

		newticket.activatetheTicektStatus();

		newticket.deactivatetheTicektStatus();

		// again re-trying to activate the ticket hence it's status
		newticket.activatetheTicektStatus();

		assertEquals(newticket.getTicektStatus(), TicketStatus.Void);
	}

}
