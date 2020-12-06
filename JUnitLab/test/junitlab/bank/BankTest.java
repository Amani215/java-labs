package junitlab.bank;

import org.junit.Assert;
import org.junit.Test;

import junitlab.bank.impl.GreatSavingsBank;

public class BankTest {
	String account1;
	String account2;
	GreatSavingsBank bank=new GreatSavingsBank();
	
	@Test
	public void testOpenAccount() throws AccountNotExistsException {
		String account = bank.openAccount();
		Assert.assertEquals(0, bank.getBalance(account));
	}

	@Test
	public void testUniqueAccount() {
		account1 = bank.openAccount();
		account2 = bank.openAccount();
		Assert.assertFalse(account1.equals(account2));
		
	}
	
	@Test(expected=AccountNotExistsException.class)
	public void testInvalidAccount() throws Exception{
		bank.getBalance(null);
	}
	
	@Test
	public void testDeposit() throws AccountNotExistsException {
		account1=bank.openAccount();
		bank.deposit(account1, 2000);
		Assert.assertEquals(2000, bank.getBalance(account1));
	}
}

