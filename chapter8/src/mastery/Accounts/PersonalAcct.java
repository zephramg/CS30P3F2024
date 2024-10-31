/*

Program: PersonalAcct.java           Last Date of this Revision: October 31, 2024

Purpose: Subclass of Account for personal bank accounts with specific minimum balance 
and penalty requirements. Overrides the withdrawal method to apply a penalty when 
balance falls below the minimum.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/
 
package mastery.Accounts;

// PersonalAcct class extends Account and represents a personal bank account with specific minimum balance requirements.
public class PersonalAcct extends Account {
    
    // Constants for minimum balance threshold and penalty fee.
    private static final double MIN_BALANCE = 100.0;
    private static final double PENALTY = 2.0;

    // Constructor initializes the personal account with balance, customer name, and address information.
    public PersonalAcct(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
        super(bal, fName, lName, street, city, province, postalCode); // Calls the parent Account constructor
    }

    // Overridden withdrawal method checks the balance after each withdrawal and applies a penalty if it’s below the minimum.
    @Override
    public void withdrawal(double amt) {
        super.withdrawal(amt);  // Calls the Account class's withdrawal method to deduct the requested amount.
        
        // Checks if the balance falls below the minimum threshold after withdrawal.
        if (getBalance() < MIN_BALANCE) {
            super.withdrawal(PENALTY);  // Applies the penalty by further reducing the balance.
            System.out.println("Balance below minimum. Penalty of $" + PENALTY + " applied.");
        }
    }
}
