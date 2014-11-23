package ParkingSystem.Entities;

import java.util.Calendar;
import java.util.Date;

import ParkingSystem.controller.PaymentManagement;

public class CashPayStrategy implements paymentStratagy {
	
	PaymentManagement payManager= new PaymentManagement();

	@Override
	public double pay(Ticket ticket, CreditCard card,PaymentManagement paymanager) {
		// TODO Auto-generated method stub
		//creditcollection.add(card);
		Status isSuccessful=null;
		
		Calendar  cal= Calendar.getInstance();
		
		Date paymentdate=cal.getTime();
		
	    Cash objCash=new Cash();
	    
	    objCash.setPaymentDate(paymentdate);
	    
	   // if(ticket.amount>0)
	   //   objCash.setAmount(amount);
	    
		if (ticket.getTicketAmount() > 0)
		{
			objCash.setTicketID(ticket.getTicektID());
			objCash.setAmount(ticket.getTicketAmount());
			
			
			
			payManager.setCashPaymentcollection(objCash);			
			//Boolean isSuccessfull=true;
			//isSuccessful = new Status(true, "Payment has been successful");
			
			//Boolean isSuccessfull = transactionManager.ProcessTheTransaction(card);
		}
		
		ticket.setTicketAmount(0);// amount paid and due is set 0

		ticket.setIsPaid(true);
		
		//return isSuccessful;
	
		return 0;
	}

}
