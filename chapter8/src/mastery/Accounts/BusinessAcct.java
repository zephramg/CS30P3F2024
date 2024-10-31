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

public class BusinessAcct extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double PENALTY = 10.0;

    public BusinessAcct(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
        super(bal, fName, lName, street, city, province, postalCode);
    }

    @Override
    public void withdrawal(double amt) {
        super.withdrawal(amt);
        if (getBalance() < MIN_BALANCE) {
            super.withdrawal(PENALTY);
            System.out.println("Balance below minimum. Penalty of $" + PENALTY + " applied.");
        }
    }
} 