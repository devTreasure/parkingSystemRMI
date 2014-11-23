package ParkingSystem.Entities;

import java.io.Serializable;

public class Gate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int GateId;
	public GateStatus gateStatus;

	public Gate(int gateId) {
		this.GateId = gateId;

	}

	public void openGate() {

	}

	public void closeGate() {

	}

}
