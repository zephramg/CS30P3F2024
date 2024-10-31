/*

Program: Account.java           Last Date of this Revision: October 31, 2024

Purpose: Base class for a bank account, handling balance, customer details, and account ID.
Includes methods for deposit, withdrawal, address change, and account comparison.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.Accounts;

import java.text.NumberFormat;

public class Account {
    private double balance;
    private Customer cust;
    private String acctID;
 
    /**
     * Constructor with initial balance and customer details including address
     * pre: none
     * post: An account has been created. Balance and customer data have been initialized.
     */
    public Account(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
        balance = bal;
        cust = new Customer(fName, lName, street, city, province, postalCode);
        acctID = fName.substring(0, 1) + lName;
    }

    /**
     * Constructor with only account ID
     * pre: none
     * post: An empty account has been created with the specified account ID.
     */
    public Account(String ID) {
        balance = 0;
        cust = new Customer("", "", "", "", "", "");
        acctID = ID;
    }

    /**
     * Returns the account ID.
     * pre: none
     * post: The account ID has been returned.
     */
    public String getID() {
        return acctID;
    }

    /**
     * Returns the current balance.
     * pre: none
     * post: The account balance has been returned.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Makes a deposit to the account.
     * pre: none
     * post: The balance has been increased by the amount of the deposit.
     */
    public void deposit(double amt) {
        balance += amt;
    }

    /**
     * Makes a withdrawal from the account if there is enough money.
     * pre: none
     * post: The balance has been decreased by the amount withdrawn.
     */
    public void withdrawal(double amt) {
        if (amt <= balance) {
            balance -= amt;
        } else {
            System.out.println("Not enough money in account.");
        }
    }

    /**
     * Changes the address for the customer.
     * pre: none
     * post: The customer's address has been updated.
     */
    public void changeAddress(String street, String city, String province, String postalCode) {
        cust.changeStreet(street);
        cust.changeCity(city);
        cust.changeProvince(province);
        cust.changePostalCode(postalCode);
    }

    /**
     * Returns true if the account IDs match.
     * pre: none
     * post: true has been returned when the objects are equal, false otherwise.
     */
    public boolean equals(Object acct) {
        if (acct instanceof Account) {
            Account testAcct = (Account) acct;
            return acctID.equals(testAcct.acctID);
        }
        return false;
    }

    /**
     * Returns a string representing the Account object.
     * pre: none
     * post: A string representing the Account object has been returned.
     */
    @Override
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String accountString = "Account ID: " + acctID + "\n";
        accountString += cust.toString();
        accountString += "Current balance is " + money.format(balance) + "\n";
        return accountString;
    }
}
