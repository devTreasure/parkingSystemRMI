package ParkingSystem.Test;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import ParkingSystem.Entities.EntryGate;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.Ticket;
import ParkingSystem.controller.FraudPreventionManagement;
import ParkingSystem.controller.ParkingSystemManager;

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
