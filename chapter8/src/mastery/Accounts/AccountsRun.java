/*

Program: AccountsRun.java           Last Date of this Revision: October 31, 2024

Purpose: Main class to test account functionality for Personal and Business accounts.
The program initializes Personal and Business accounts, simulates withdrawals 
with penalties for going below minimum balances, and displays account details.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.Accounts;

public class AccountsRun {
    public static void main(String[] args) {
        // Test Personal Account with minimum balance penalty
        PersonalAcct personalAccount = new PersonalAcct(150.0, "John", "Doe", "123 Main St", "Springfield", "IL", "62704");
        System.out.println("=== Personal Account Details ===");
        System.out.println(personalAccount);
        
        // Test withdraw function
        System.out.println("\nWithdrawing $60 from Personal Account...");
        personalAccount.withdrawal(60); // Should apply penalty if below minimum balance
        System.out.println(personalAccount);

        // Test Business Account with minimum balance penalty
        BusinessAcct businessAccount = new BusinessAcct(600.0, "Jane", "Smith", "456 Elm St", "Shelbyville", "CA", "62565");
        System.out.println("\n=== Business Account Details ===");
        System.out.println(businessAccount);
        
        // Test withdraw function
        System.out.println("\nWithdrawing $200 from Business Account...");
        businessAccount.withdrawal(200); // Should apply penalty if below minimum balance
        System.out.println(businessAccount);
    }
}

/* Screen Dump

=== Personal Account Details ===
Account ID: JDoe
John Doe
123 Main St, Springfield, IL 62704
Current balance is $150.00


Withdrawing $60 from Personal Account...
Balance below minimum. Penalty of $2.0 applied.
Account ID: JDoe
John Doe
123 Main St, Springfield, IL 62704
Current balance is $88.00


=== Business Account Details ===
Account ID: JSmith
Jane Smith
456 Elm St, Shelbyville, CA 62565
Current balance is $600.00


Withdrawing $200 from Business Account...
Balance below minimum. Penalty of $10.0 applied.
Account ID: JSmith
Jane Smith
456 Elm St, Shelbyville, CA 62565
Current balance is $390.00

*/