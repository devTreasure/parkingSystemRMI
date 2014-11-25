package cs414.a5.bhavinp.test;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import cs414.a5.bhavinp.controller.FraudPreventionManagement;
import cs414.a5.bhavinp.controller.ParkingSystemManager;
import cs414.a5.bhavinp.entities.EntryGate;
import cs414.a5.bhavinp.entities.Gate;
import cs414.a5.bhavinp.entities.Ticket;

public class FraudPreventionManagementTest {
	/*

	@Test
	public void checkEntryWithVaildTicket() throws RemoteException {
		ParkingSystemManager pm = null;
		try {
			pm = new ParkingSystemManager();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket t = pm.getTicketmager().createTicket();
		t.activatetheTicektStatus();

		Gate g = new EntryGate(1);

		FraudPreventionManagement fm = new FraudPreventionManagement();

		Boolean isvalid = fm.checkNoEntryWithoutTicket(t, g);

		assertEquals(true, isvalid);
	}
	
	@Test
	public void checkEntryWithoutVaildTicket() throws RemoteException {
		ParkingSystemManager pm = null;
		try {
			pm = new ParkingSystemManager();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket t = pm.getTicketmager().createTicket();
		

		Gate g = new EntryGate(1);

		FraudPreventionManagement fm = new FraudPreventionManagement();
        //Ticket is not activated
		Boolean isvalid = fm.checkNoEntryWithoutTicket(t, g);

		assertEquals(false, isvalid);
	}

	
	@Test
	public void isValidTicketReturnsFalseWhenTicketIsNotActive() throws RemoteException
	{
		ParkingSystemManager pm = new ParkingSystemManager();
		Ticket t = pm.getTicketmager().createTicket();
		
		//Ticket is created but not activated.

		FraudPreventionManagement fm = new FraudPreventionManagement();
     
        assertEquals(false,  fm.isValidTicket(t));
		
	}
	
	
	@Test
	public void isValidTicketReturnsTrueWhenTicketIsActive() throws RemoteException
	{
		ParkingSystemManager pm = new ParkingSystemManager();
		Ticket t = pm.getTicketmager().createTicket();
		
		t.activatetheTicektStatus();
		//Ticket is created but not activated.

		FraudPreventionManagement fm = new FraudPreventionManagement();
     
        assertEquals(true,  fm.isValidTicket(t));
		
	}
	*/
}
