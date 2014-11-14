package ParkingSystem.Test;

import static org.junit.Assert.*;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.GateStatus;
import ParkingSystem.controller.GateManagement;

import org.junit.Test;

public class GateManagementTest {
	GateManagement g = new GateManagement();

	

	@Test
	public void whenGateOpeniscalledOutGateStausShoulebeOpen() {
		
		Gate gs = g.OpenEntryGate(1);

		assertEquals(gs.gateStatus, GateStatus.Open);

	}

	@Test
	public void whenGateClosediscalledOutGateStausShoulebeClosed() {


		Gate gs = g.closeEntryGate(1);

		assertEquals(gs.gateStatus, GateStatus.Close);

	}
	
	@Test
	public void openEntryGate() {
		GateManagement g = new GateManagement();

		int gateID=1;
		Gate gs = g.OpenEntryGate(gateID);
      
		assertEquals(gs.gateStatus, GateStatus.Open);

	}
	
	
	
	@Test
	public void closeeEntryGate() {
		
		int gateID=1;
		Gate gs = g.getGateMovementcollection().get(gateID);
		Gate ge=g.closeEntryGate(1);
		
		if(gs!=null)
		{
		    assertEquals(gs.gateStatus, GateStatus.Open);
		 
		}
		
		 assertEquals(ge.gateStatus, GateStatus.Close);

	}
	
	@Test
	public void openExitGate() {
		
		int gateID=11;
		Gate gs = g.openExitGate(gateID);
      
		assertEquals(gs.gateStatus, GateStatus.Open);

	}
	
	@Test
	public void closeExitGate() {
	
		int gateID=11;
		Gate gs = g.closeExitGate(gateID);
		if(gs!=null)
		{
		    assertEquals(gs.gateStatus, GateStatus.Open);
		 
		}
      
		assertEquals(gs.gateStatus, GateStatus.Open);

	}


}
