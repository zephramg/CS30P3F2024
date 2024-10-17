package mastery; 

import java.util.Scanner;

public class MySavings {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PiggyBank bank = new PiggyBank(); // Create a new PiggyBank object

        boolean exit = false;
        while (!exit) {
            // Display the menu
            System.out.println("\n--- My Savings Menu ---");
            System.out.println("1. Add Pennies");
            System.out.println("2. Add Nickels");
            System.out.println("3. Add Dimes");
            System.out.println("4. Add Quarters");
            System.out.println("5. Remove Pennies");
            System.out.println("6. Remove Nickels");
            System.out.println("7. Remove Dimes");
            System.out.println("8. Remove Quarters");
            System.out.println("9. View Total Savings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of pennies: ");
                    bank.addPennies(input.nextInt());
                    break;
                case 2:
                    System.out.print("Enter the number of nickels: ");
                    bank.addNickels(input.nextInt());
                    break;
                case 3:
                    System.out.print("Enter the number of dimes: ");
                    bank.addDimes(input.nextInt());
                    break;
                case 4:
                    System.out.print("Enter the number of quarters: ");
                    bank.addQuarters(input.nextInt());
                    break;
                case 5:
                    System.out.print("Enter the number of pennies to remove: ");
                    bank.removePennies(input.nextInt());
                    break;
                case 6:
                    System.out.print("Enter the number of nickels to remove: ");
                    bank.removeNickels(input.nextInt());
                    break;
                case 7:
                    System.out.print("Enter the number of dimes to remove: ");
                    bank.removeDimes(input.nextInt());
                    break;
                case 8:
                    System.out.print("Enter the number of quarters to remove: ");
                    bank.removeQuarters(input.nextInt());
                    break;
                case 9:
                    System.out.println("Total Savings: $" + bank.getTotal());
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
        input.close();
    }
}
