package cs414.a5.bhavinp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs414.a5.bhavinp.controller.TransactionManagement;
import cs414.a5.bhavinp.entities.CreditCard;

public class TransactionManagementTest {

	@Test
	public void processTheTransactionWhenCreditCardIsValid() {

		TransactionManagement tm = new TransactionManagement();
		CreditCard card = new CreditCard();
		card.setCCNumner("1234123412341234");
		card.setExpiryDate("04/2015");
		card.setAmount(15);
		card.setCvvNumber(123);

		assertEquals(true, tm.ProcessTheTransaction(card));

	}

	@Test
	public void doNotProcessTheTransactionWhenCreditCardIsInValid() {

		TransactionManagement tm = new TransactionManagement();
		CreditCard card = new CreditCard();
		card.setCCNumner("1234123412341234");
		card.setExpiryDate("04/2012");
		card.setAmount(15);
		card.setCvvNumber(123);

		assertEquals(false, tm.ProcessTheTransaction(card));
	}

	@Test
	public void doNotProcessTheTransactionWhenCreditCardAmountIsNegative() {

		TransactionManagement tm = new TransactionManagement();

		CreditCard card = new CreditCard();
		card.setCCNumner("1234123412341234");
		card.setExpiryDate("04/2014");
		card.setAmount(-15);
		card.setCvvNumber(123);

		assertEquals(false, tm.ProcessTheTransaction(card));

	}

	@Test
	public void doNotProcessTheTransactionWhenCreditCardAmountIsZero() {

		TransactionManagement tm = new TransactionManagement();

		CreditCard card = new CreditCard();
		card.setCCNumner("1234123412341234");
		card.setExpiryDate("04/2014");
		card.setAmount(0);
		card.setCvvNumber(123);

		assertEquals(false, tm.ProcessTheTransaction(card));
	}

	@Test
	public void processTheTransactionWhenAmountIsNotZero() {

		TransactionManagement tm = new TransactionManagement();

		CreditCard card = new CreditCard();
		card.setCCNumner("1234123412341234");
		card.setExpiryDate("04/2015");
		card.setAmount(15);
		card.setCvvNumber(123);

		assertEquals(true, tm.ProcessTheTransaction(card));
	}

}
