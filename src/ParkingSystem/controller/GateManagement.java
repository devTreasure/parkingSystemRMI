package ParkingSystem.controller;

import java.util.HashMap;
import java.util.Map;

import ParkingSystem.Entities.EntryGate;
import ParkingSystem.Entities.ExitGate;
import ParkingSystem.Entities.Gate;
import ParkingSystem.Entities.GateStatus;

public class GateManagement {

	private Map<Integer, Gate> gateMovementcollection = new HashMap<Integer, Gate>();

	// No gate assigned initially
	public Gate gate = new Gate(0);

	// Never assign same gateid between entry and exit gate
	// i.e if entry gate has id 1 then exit gate must be named with id 11 or
	// anything other than 1.

	public Gate OpenEntryGate(int gateid) {

		Gate entryGate = gateMovementcollection.get(gateid);
		if (entryGate == null) {
			entryGate = new EntryGate(gateid);
			gateMovementcollection.put(gateid, entryGate);
		}

		entryGate.gateStatus = GateStatus.Open;
		return entryGate;
	}

	public Gate closeEntryGate(int gateid) {

		Gate entryGate = gateMovementcollection.get(gateid);
		if (entryGate == null) {
			entryGate = new EntryGate(gateid);
			gateMovementcollection.put(gateid, entryGate);
		}

		entryGate.gateStatus = GateStatus.Close;
		return entryGate;

	}

	public Gate openExitGate(int gateid) {
		Gate exitGate = gateMovementcollection.get(gateid);
		if (exitGate == null) {
			exitGate = new ExitGate(gateid);
			gateMovementcollection.put(gateid, exitGate);
		}
		exitGate.gateStatus = GateStatus.Open;
		return exitGate;
	}

	public Gate closeExitGate(int gateid) {

		Gate exitGate = gateMovementcollection.get(gateid);
		if (exitGate == null) {
			exitGate = new ExitGate(gateid);
			gateMovementcollection.put(gateid, exitGate);
		}

		exitGate.gateStatus = GateStatus.Close;
		return exitGate;
	}

	public Map<Integer, Gate> getGateMovementcollection() {
		return gateMovementcollection;
	}

	public void setGateMovementcollection(Map<Integer, Gate> gateMovementcollection) {
		this.gateMovementcollection = gateMovementcollection;
	}

}
