package cs414.a5.bhavinp.controller;

import java.io.Serializable;

import cs414.a5.bhavinp.entities.ParkingStatus;

public class OccupancyManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int parkingCapacity;
	public int currentParkingOccupancy;
	public ParkingStatus parkingstatus;

	public ParkingStatus getParkingstatus() {
		return parkingstatus;
	}

	public void setParkingstatus(ParkingStatus parkingstatus) {
		this.parkingstatus = parkingstatus;
	}

	public void setParkingCapacity(int parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}

	public void incrementOcccupancy() {

		if (!this.isParkingfull())
			this.currentParkingOccupancy += 1;
	}

	public void decrementOcccupancy() {
		if (this.currentParkingOccupancy > 1)
			this.currentParkingOccupancy -= 1;
		else
			this.currentParkingOccupancy = 0;
	}

	public int getParkingCapacity() {
		return parkingCapacity;
	}

	public int getCurrentParking() {
		return currentParkingOccupancy;
	}

	public void setCurrentParking(int currentParking) {
		this.currentParkingOccupancy = currentParking;
	}

	public Boolean isParkingfull() {

		if (this.currentParkingOccupancy < this.parkingCapacity)
			return false;
		else
			return true;
	}

	public ParkingStatus currentparkingStatus() {
		if (!(isParkingfull()))
			this.parkingstatus = ParkingStatus.Open;
		else
			this.parkingstatus = ParkingStatus.Full;

		return this.parkingstatus;

	}

}
