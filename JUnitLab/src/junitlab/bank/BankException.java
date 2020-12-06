package junitlab.bank;

/**
 * The base class of all banking exceptions.
 */
public abstract class BankException extends Exception {

	/**
	 * The account number where the error occurred.
	 */
	private String accountNumber;

	/**
	 * Creates the exception.
	 * @param accountNumber The account number where the error occurred. 
	 */
	public BankException(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Creates an exception with the given error message.
	 * @param accountNumber The account number where the error occurred. 
	 * @param message The error message.
	 */
	public BankException(String accountNumber, String message) {
		super(message);
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Returns the account number where the error occurred.
	 * @return The account number where the error occurred.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
}
