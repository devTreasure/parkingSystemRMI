package ParkingSystem.Entities;

import ParkingSystem.controller.PaymentManagement;

public interface paymentStratagy {
	
	public double pay(Ticket ticket, CreditCard card,PaymentManagement paymanager);

}
