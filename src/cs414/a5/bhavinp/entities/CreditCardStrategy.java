package cs414.a5.bhavinp.entities;

import cs414.a5.bhavinp.controller.PaymentManagement;
import cs414.a5.bhavinp.controller.TransactionManagement;
import cs414.a5.bhavinp.entities.Ticket;
import cs414.a5.bhavinp.reports.ReportCollection;

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

		if (card.getAmount() > 0) {
			ticket.setTicketAmount(card.getAmount());
			isSuccessfull = paymanager.transactionManager.ProcessTheTransaction(card);
		}

		ticket.setTicketAmount(0); // amount paid and due is set 0

		ticket.setIsPaid(true);

		// return isSuccessfull;

		return 0;
	}

}
