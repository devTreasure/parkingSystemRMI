package ParkingSystem.Entities;

import ParkingSystem.Entities.Ticket;
import ParkingSystem.Reports.ReportCollection;
import ParkingSystem.controller.PaymentManagement;
import ParkingSystem.controller.TransactionManagement;

public class CreditCardStrategy implements paymentStratagy {

	// TransactionManagement transactionmgmt=new TransactionManagement();
	// PaymentManagement paymanager=new PaymentManagement();

	@Override
	public double pay(Ticket ticket, CreditCard card, PaymentManagement paymanager) {
		// TODO Auto-generated method stub

		ReportCollection r = new ReportCollection();

		r.setCCNumner(card.getCCNumner());
		r.setTicketID(card.getTicketID());
		r.setAmount(card.getAmount());

		r.setCreditcardpaymentTime(card.getCreditcardpaymentTime());

		// creditReportcollection.add(r);

		paymanager.setCreditcollection(card);

		// paymanager.setCreditCard(card);

		paymanager.setCreditReportcollection(r);

		Status isSuccessfull = null;

		if (ticket.getTicketAmount() > 0) {
			card.setAmount(ticket.getTicketAmount());

			isSuccessfull = paymanager.transactionManager.ProcessTheTransaction(card);
		}

		ticket.setTicketAmount(0); // amount paid and due is set 0

		ticket.setIsPaid(true);

		// return isSuccessfull;

		return 0;
	}

}
