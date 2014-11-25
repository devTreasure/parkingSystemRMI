package cs414.a5.bhavinp.controller;

import java.io.Serializable;

public class CreditPaymentGateWay implements Serializable {

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
