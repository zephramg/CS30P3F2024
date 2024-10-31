/*

Program: BusinessAcct.java           Last Date of this Revision: October 31, 2024

Purpose: Subclass of Account for business bank accounts with specific minimum balance 
and penalty requirements. Overrides the withdrawal method to apply a penalty when 
balance falls below the minimum.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.Accounts;

// BusinessAcct class extends the Account class and represents a business bank account.
public class BusinessAcct extends Account {
    
    // Constants for minimum balance requirement and penalty fee.
    private static final double MIN_BALANCE = 500.0;
    private static final double PENALTY = 10.0;

    // Constructor initializes the business account with balance, customer name, and address details.
    public BusinessAcct(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
        super(bal, fName, lName, street, city, province, postalCode);
    }

    // Overridden withdrawal method applies a penalty if balance falls below the minimum requirement.
    @Override
    public void withdrawal(double amt) {
        super.withdrawal(amt);  // Calls the parent class's withdrawal method to deduct the amount.
        
        // Check if balance is below the minimum threshold.
        if (getBalance() < MIN_BALANCE) {
            super.withdrawal(PENALTY);  // Deducts penalty from the balance.
            System.out.println("Balance below minimum. Penalty of $" + PENALTY + " applied.");
        }
    }
}
