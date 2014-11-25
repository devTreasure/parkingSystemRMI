package cs414.a5.bhavinp.entities;

import cs414.a5.bhavinp.controller.PaymentManagement;

public class PaymentContext {

	private paymentStratagy strategy;
	
	private PaymentType paymentType;
	
	

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public void setPaymentStrategy(paymentStratagy strategy) {
		this.strategy = strategy;
	}

	public double Pay(Ticket t, CreditCard c, PaymentManagement p) {
		if(PaymentType.Cash.equals(paymentType))
		{
			strategy=new CashPayStrategy();
		}
		else if(PaymentType.Credit.equals(paymentType))
		{
			strategy=new CreditCardStrategy();
		}
		if(strategy!=null)
		{
			return strategy.pay(t, c, p);
			
		}
		

		throw new RuntimeException("Payment type not set");
	}
}
