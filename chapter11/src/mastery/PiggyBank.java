/* PiggyBank method for MySavingsFile.java */

package mastery;

import java.io.Serializable;

public class PiggyBank implements Serializable {
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;

    // Constructor
    public PiggyBank() {
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
    }

    // Add coins
    public void addPennies(int count) {
        pennies += count;
    }

    public void addNickels(int count) {
        nickels += count;
    }

    public void addDimes(int count) {
        dimes += count;
    }

    public void addQuarters(int count) {
        quarters += count;
    }

    // Remove coins
    public void removePennies(int count) {
        pennies -= Math.min(count, pennies); // Ensure not removing more than we have
    }

    public void removeNickels(int count) {
        nickels -= Math.min(count, nickels); // Ensure not removing more than we have
    }

    public void removeDimes(int count) {
        dimes -= Math.min(count, dimes); // Ensure not removing more than we have
    }

    public void removeQuarters(int count) {
        quarters -= Math.min(count, quarters); // Ensure not removing more than we have
    }

    // Calculate total amount in dollars
    public double getTotal() {
        return pennies * 0.01 + nickels * 0.05 + dimes * 0.10 + quarters * 0.25;
    }
}