package ParkingSystem.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ParkingSystem.Entities.ParkingStatus;
import ParkingSystem.controller.OccupancyManagement;

public class OccupancyManagementTest {

	@Test
	public void IfparkingIsFullDisplayParkingStatusFull() {
		OccupancyManagement objoccupancymanager = new OccupancyManagement();
		// set the parking capacity
		objoccupancymanager.setParkingCapacity(5);

		objoccupancymanager.setCurrentParking(5);

		assertEquals(ParkingStatus.Full,
				objoccupancymanager.currentparkingStatus());

	}
	
	

	@Test
	public void IfparkingIsNotFullDisplayParkingStatusOpen() {
		OccupancyManagement objoccupancymanager = new OccupancyManagement();
		// set the parking capacity
		objoccupancymanager.setParkingCapacity(5);

		objoccupancymanager.setCurrentParking(4);

		assertEquals(ParkingStatus.Open,
				objoccupancymanager.currentparkingStatus());

	}

	@Test
	public void DisplayCurrentparkingCorrectly() {

		OccupancyManagement objoccupancymanager = new OccupancyManagement();
		// set the parking capacity

		objoccupancymanager.setCurrentParking(4);

		assertEquals(4, objoccupancymanager.currentParkingOccupancy);

	}
	
	@Test
	public void OccupnacyMangerShouldincrementTheParkingCountCorrectly()
	{
		OccupancyManagement o=new OccupancyManagement();
		o.setCurrentParking(5);
		o.incrementOcccupancy();
		assertEquals(6,o.currentParkingOccupancy);

	}
	
	@Test
	public void OccupnacyMangerShouldDecrementTheParkingCountCorrectly()
	{
		OccupancyManagement o=new OccupancyManagement();
		o.setCurrentParking(5);
		o.decrementOcccupancy();
		assertEquals(4,o.currentParkingOccupancy);

	}
	
	@Test
	public void ParkingIsFullWhenOccupancyIsEqualToCurrentParkingCapacity()
	{
		OccupancyManagement o=new OccupancyManagement();
		o.setCurrentParking(5);
		o.setParkingCapacity(5);
		assertEquals(true,o.isParkingfull());	
		
		
		
	}
	

	@Test
	public void ParkingIsNotFullWhenOccupancyIsLesThanToCurrentParkingCapacity()
	{
		OccupancyManagement o=new OccupancyManagement();
		o.setCurrentParking(4);
		o.setParkingCapacity(5);
		assertEquals(false,o.isParkingfull());	
		
		
		
	}
	
	
	
	

}