package ParkingSystem.Server;

import ParkingSystem.Common.IparkingSystemManager;
import ParkingSystem.controller.ParkingSystemManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ParkingSystemServer {

	private String url;

	public ParkingSystemServer(String url) throws RemoteException {
		this.url = url;

		ParkingSystemManager parkingManger = new ParkingSystemManager();

		try {

			Naming.rebind(url, parkingManger);

		} catch (MalformedURLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String url = new String("rmi://" + args[0] + ":" + args[1]
				+ "/ParkingService");
		try {
			new ParkingSystemServer(url);

			System.out.println("Parking service cliet is running.....");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/*
 * import java.rmi.Naming; public class CalculatorServer { private String url;
 * public CalculatorServer(String url) { this.url = url; try { Calculator c =
 * new CalculatorImpl(); Naming.rebind(url, c); } catch (Exception e) {
 * System.out.println("Trouble: " + e.getMessage()); } }
 * 
 * // run the program using // java CalculatorServer <host> <port>
 * 
 * public static void main(String args[]) { String url = new String("rmi://" +
 * args[0] + ":" + args[1] + "/CalculatorService"); new CalculatorServer(url); }
 * }
 */