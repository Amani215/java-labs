package junitlab.bank;

/**
 * This is a basic bank interface. It defines the most common
 * banking operations.  
 */
public interface Bank {

	/**
	 * Opens a new account. The initial balance is zero.
	 * @return The account number of the newly created account.
	 */
	public String openAccount();
	
	/**
	 * Closes an empty account.
	 * @param accountNumber The account number.
	 * @return Whether the operation was successful. If the balance is not zero, the account cannot be closed.
	 * @throws AccountNotExistsException If the account number does not exist.
	 */
	public boolean closeAccount(String accountNumber) throws AccountNotExistsException;
	
	/**
	 * Returns the current balance of an account.
	 * @param accountNumber The account number.
	 * @return The current balance.
	 * @throws AccountNotExistsException If the account number does not exist.
	 */
	public long getBalance(String accountNumber) throws AccountNotExistsException;
	
	/**
	 * Depositing the given amount to the account. For technical reasons only
	 * amounts divisible by 100 can be deposited. If the amount does not
	 * fulfill this requirement, the bank will round it using the conventional
	 * rounding rules.
	 * @param accountNumber The account number.
	 * @param amount The amount to be deposited. Must be a positive number.
	 * @throws AccountNotExistsException If the account number does not exist.
	 */
	public void deposit(String accountNumber, long amount) throws AccountNotExistsException;
	
	/**
	 * Withdrawing the given amount to the account. For technical reasons only
	 * amounts divisible by 100 can be withdrawn. If the amount does not
	 * fulfill this requirement, the bank will round it using the conventional
	 * rounding rules.
	 * @param accountNumber The account number.
	 * @param amount The amount to be withdrawn. Must be a positive number.
	 * @throws AccountNotExistsException If the account number does not exist.
	 * @throws NotEnoughFundsException If there is not enough funds for the withdraw on the account.
	 */
	public void withdraw(String accountNumber, long amount) throws AccountNotExistsException, NotEnoughFundsException;
	
	/**
	 * Transfers an amount from one account to the other. Money transfers
	 * do not fall under the rounding requirement, any amount of money
	 * can be transferred. 
	 * @param sourceAccount The source account.
	 * @param targetAccount The target account.
	 * @param amount The amount to be transferred. Must be a positive number.
	 * @throws AccountNotExistsException If the account number does not exist.
	 * @throws NotEnoughFundsException If there is not enough funds for the transfer on the source account.
	 */
	public void transfer(String sourceAccount, String targetAccount, long amount) throws AccountNotExistsException, NotEnoughFundsException;
}
