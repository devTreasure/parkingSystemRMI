package cs414.a5.bhavinp.entities;

import cs414.a5.bhavinp.controller.PaymentManagement;

public interface paymentStratagy {
	
	public double pay(Ticket ticket, CreditCard card, PaymentManagement paymanager);

}
