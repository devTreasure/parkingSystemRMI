package cs414.a5.bhavinp.entities;

import java.util.Calendar;
import java.util.Date;

import cs414.a5.bhavinp.controller.PaymentManagement;

public class CashPayStrategy implements paymentStratagy {

	//PaymentManagement payManager = new PaymentManagement();

	@Override
	public double pay(Ticket ticket, CreditCard card,PaymentManagement paymanager) {
		// TODO Auto-generated method stub
		// creditcollection.add(card);
		Status isSuccessful = null;

		Calendar cal = Calendar.getInstance();

		Date paymentdate = cal.getTime();

		Cash objCash = new Cash();

		objCash.setPaymentDate(paymentdate);


		if (ticket.getTicketAmount() > 0) {
			objCash.setTicketID(ticket.getTicektID());
			objCash.setAmount(ticket.getTicketAmount());

			paymanager.setCashPaymentcollection(objCash);

		}

		ticket.setTicketAmount(0);// amount paid and due is set 0

		ticket.setIsPaid(true);

		// return isSuccessful;

		return 0;
	}

}
