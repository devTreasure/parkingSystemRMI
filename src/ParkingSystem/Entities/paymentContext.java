package ParkingSystem.Entities;

import ParkingSystem.controller.PaymentManagement;

public class paymentContext {
	
	private paymentStratagy   strategy;
	
	
	public void  setPaymentStrategy(paymentStratagy strategy )
	{
		this.strategy=strategy;
	}

	
	public double Pay(Ticket t,CreditCard c,PaymentManagement p)
	{
		 strategy.pay(t, c, p);
		
	     return 0;
	}
}
