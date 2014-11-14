package ParkingSystem.controller;

public class CreditPaymentGateWay {

	// this class is to mimic credit card payment authorization
	public Boolean makePayment(Double amt) {

		Boolean isPaid = false;

		if (amt > 0) {

			isPaid = true;
		} else {
			isPaid = false;
		}

		return isPaid;

	}

}
