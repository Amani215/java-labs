package junitlab.bank;

/**
 * This exception is thrown if an account does not exist. 
 */
public class AccountNotExistsException extends BankException {
	
	/**
	 * Creates the exception.
	 * @param accountNumber The non-existent account number.
	 */
	public AccountNotExistsException(String accountNumber) {
		super(accountNumber, "Account does not exist: " + accountNumber);
	}
}
