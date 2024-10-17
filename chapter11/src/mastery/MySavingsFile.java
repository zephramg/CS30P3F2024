package mastery;

import java.io.*;
import java.util.Scanner;

public class MySavingsFile {

    private static String FILE_NAME = "C:/Users/38020001/git/CS30P3F2024/chapter11/src/mastery/PiggyBank.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PiggyBank bank = loadPiggyBank(); // Load PiggyBank from file or create a new one

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
            System.out.println("0. Exit and Save");
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
                    System.out.printf("Total Savings: $%.2f\n", bank.getTotal());
                    break;
                case 0:
                    exit = true;
                    savePiggyBank(bank); // Save the PiggyBank to a file
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
        input.close();
    }
    
    // Method to save the PiggyBank object to a file using output stream
    private static void savePiggyBank(PiggyBank bank) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bank);
            System.out.println("PiggyBank saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving PiggyBank: " + e.getMessage());
        }
    }

    // Method to load the PiggyBank object from a file using input stream
    private static PiggyBank loadPiggyBank() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (PiggyBank) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved PiggyBank found. Starting a new one.");
            return new PiggyBank(); // If the file doesn't exist, return a new PiggyBank
        }
    }
}