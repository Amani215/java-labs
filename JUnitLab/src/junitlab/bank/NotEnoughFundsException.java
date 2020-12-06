package junitlab.bank;

/**
 * This exception is thrown if there is not enough funds on
 * an account.
 */
public class NotEnoughFundsException extends BankException {

	/**
	 * Creates the exception.
	 * @param accountNumber The account number which has not enough funds.
	 */
	public NotEnoughFundsException(String accountNumber) {
		super(accountNumber, "Not enough funds on account " + accountNumber);
	}
}
