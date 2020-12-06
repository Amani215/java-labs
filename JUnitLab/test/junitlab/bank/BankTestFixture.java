package junitlab.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junitlab.bank.impl.GreatSavingsBank;

public class BankTestFixture {
	String account1;
	String account2;
	GreatSavingsBank bank;
	
	@Before
	public void setUp() throws AccountNotExistsException {
		bank=new GreatSavingsBank();
		account1=bank.openAccount();
		account2=bank.openAccount();
		bank.deposit(account1, 1500);
		bank.deposit(account2, 12000);
	}

	@Test
	public void testTransfer() throws AccountNotExistsException, NotEnoughFundsException {
		bank.transfer(account2, account1, 3456);
		Assert.assertEquals(4956, bank.getBalance(account1));
		Assert.assertEquals(8544, bank.getBalance(account2));
	}
	
	@Test(expected=NotEnoughFundsException.class)
	public void testTransferWithoutEnoughFunds() throws Exception{
		bank.transfer(account1, account2, 3456);
	}
}
