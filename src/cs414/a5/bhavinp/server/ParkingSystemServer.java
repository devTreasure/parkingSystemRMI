package cs414.a5.bhavinp.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import cs414.a5.bhavinp.common.IparkingSystemManager;
import cs414.a5.bhavinp.controller.ParkingSystemManager;

public class ParkingSystemServer {

	private String url;

	public ParkingSystemServer(String url) throws RemoteException {
		this.url = url;

		ParkingSystemManager parkingManger = new ParkingSystemManager();

		try {

			Naming.rebind(url, parkingManger);

		} catch (MalformedURLException e)

		{

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String url = new String("rmi://" + args[0] + ":" + args[1] + "/ParkingService");
		try {
			new ParkingSystemServer(url);

			System.out.println("Parking service Server is running.....");
		} catch (RemoteException e) {

			e.printStackTrace();
		}
	}

}
