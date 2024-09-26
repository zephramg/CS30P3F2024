
package mastery;

import java.util.ArrayList;

public class Bank 
{
	private ArrayList accounts;
		
	
	// Main constructor
	public Bank() 
	{
		accounts = new ArrayList();
	}
	

	/** 
	 * Adds a new account to the bank accounts.
	 * pre: none
	 * post: An account has been added to the bank's accounts.
	 * The account ID has been returned.
	 */
	public String addAccount(String fName, String lName, double balance) 
	{
		
		// Creates account object
		Account newAcct = new Account(balance, fName, lName);	
		
		// Add account to bank accounts
		accounts.add(newAcct);									
		
		return(newAcct.getID());
	}

	
	/** 
	 * Deletes an existing account.
	 * pre: none
	 * post: An existing account has been deleted.
	 * Returns a message.
	 */
	public String deleteAccount(String acctID) {
		int acctIndex;
		Account acctToMatch;
		
	 	acctToMatch = new Account(acctID);
	 	acctIndex = accounts.indexOf(acctToMatch);		// Retrieve location of account
	 	if (acctIndex > -1) {
	 		accounts.remove(acctIndex);					// Remove account
	 		return("Account removed.");
	 	} else {
	 		return("Account does not exist.");
	 	}
	}
	
	
	/** 
	 * Performs a transaction on an existing account. A transCode of 1 is for deposits 
	 * and a transCode of 2 is for withdrawals.
	 * pre: transCode is 1 or 2.
	 * post: A transaction has occurred for an existing account.
	 * Returns updated account info.
	 */
	public String transaction(int transCode, String acctID, double amt) {
		int acctIndex;
		Account acctToMatch, acct;
		
	 	acctToMatch = new Account(acctID);
	 	acctIndex = accounts.indexOf(acctToMatch);		// Retrieve location of account
	 	if (acctIndex > -1) {
	 		acct = (Account)accounts.get(acctIndex);	// Retrieve object to modify
	 		if (transCode == 1) {
	 			acct.deposit(amt);
	 			accounts.set(acctIndex, acct);			// R eplace object with updated object
	 			return(acct.toString());
	 		} else if (transCode == 2) {
	 			acct.withdrawal(amt);
	 			accounts.set(acctIndex, acct);			// Replace object with updated object
	 			return(acct.toString());
	 		}
	 	}
	 	return("Account does not exist.");
	}


	/** 
	 * Displays the account information, including the current balance, 
	 * for an existing account.
	 * pre: none
	 * post: Account information, including balance, has been displayed.
	 * Returns account info or a message if account does not exist.
	 */
	public String checkBalance(String acctID) {
		int acctIndex;
		Account acctToMatch, acct;
		
	 	acctToMatch = new Account(acctID);
	 	acctIndex = accounts.indexOf(acctToMatch);		// Retrieve location of account
	 	if (acctIndex > -1) {
	 		acct = (Account)accounts.get(acctIndex);	// Retrieve object to display
	 		return(acct.toString());
	 	} else {
	 		return("Account does not exist.");
	 	}
	}
}
