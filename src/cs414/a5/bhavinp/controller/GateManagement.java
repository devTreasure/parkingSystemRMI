package cs414.a5.bhavinp.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cs414.a5.bhavinp.entities.EntryGate;
import cs414.a5.bhavinp.entities.ExitGate;
import cs414.a5.bhavinp.entities.Gate;
import cs414.a5.bhavinp.entities.GateStatus;

public class GateManagement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer, Gate> entryGatecollection = new HashMap<Integer, Gate>();

	public Map<Integer, Gate> getEntryGatecollection() {
		return entryGatecollection;
	}

	public void setEntryGatecollection(Map<Integer, Gate> entryGatecollection) {
		this.entryGatecollection = entryGatecollection;
	}

	private Map<Integer, Gate> exitGatecollection = new HashMap<Integer, Gate>();

	// No gate assigned initially
	public Gate gate = new Gate(0);

	// Never assign same gateid between entry and exit gate
	// i.e if entry gate has id 1 then exit gate must be named with id 11 or
	// anything other than 1.

	public Gate OpenEntryGate(int gateid) {

		Gate entryGate = entryGatecollection.get(gateid);
		if (entryGate == null) {
			entryGate = new EntryGate(gateid);
			entryGatecollection.put(gateid, entryGate);
		}

		entryGate.gateStatus = GateStatus.Open;
		return entryGate;
	}

	public Gate closeEntryGate(int gateid) {

		Gate entryGate = entryGatecollection.get(gateid);
		if (entryGate == null) {
			entryGate = new EntryGate(gateid);
			entryGatecollection.put(gateid, entryGate);
		}

		entryGate.gateStatus = GateStatus.Close;
		return entryGate;

	}

	public Gate openExitGate(int gateid) {
		Gate exitGate = exitGatecollection.get(gateid);
		if (exitGate == null) {
			exitGate = new ExitGate(gateid);
			exitGatecollection.put(gateid, exitGate);
		}
		exitGate.gateStatus = GateStatus.Open;
		return exitGate;
	}

	public Gate closeExitGate(int gateid) {

		Gate exitGate = exitGatecollection.get(gateid);
		if (exitGate == null) {
			exitGate = new ExitGate(gateid);
			exitGatecollection.put(gateid, exitGate);
		}
		exitGate.gateStatus = GateStatus.Close;
		return exitGate;
	}

	public Gate getEntryGate(int gateID) {
		return entryGatecollection.get(gateID);
	}

	public Gate getExitGate(int gateID) {
		return exitGatecollection.get(gateID);
	}

	public Map<Integer, Gate> getGateMovementcollection() {
		return entryGatecollection;
	}

}
