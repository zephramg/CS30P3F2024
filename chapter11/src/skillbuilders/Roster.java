package skillbuilders;

import java.io.*;
import java.util.Scanner;

public class Roster {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName;

        // Ask the user for a file name or path
        System.out.println("Enter the name of the file to store the student roster (leave blank for default 'roster.txt'): ");
        fileName = input.nextLine();

        // Default directory path
        String defaultDirectory = "C:/Users/38020001/git/CS30P3F2024/chapter11/src/skillbuilders/";

        // If the user doesn't provide a file name, use the default "roster.ser"
        if (fileName.trim().isEmpty()) {
            fileName = "roster.txt";  // Default file name for serialized objects
        }

        // Combine the directory and file name
        File rosterFile = new File(defaultDirectory + fileName);

        // Print the absolute path for debugging
        System.out.println("Saving to file at: " + rosterFile.getAbsolutePath());

        int numStudents = 0;

        // Ask the user for the number of students, with validation
        while (numStudents <= 0) {
            System.out.println("Enter the number of students in the class (positive number): ");
            if (input.hasNextInt()) {
                numStudents = input.nextInt();
                if (numStudents <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next();  // Clear invalid input
            }
        }
        input.nextLine();  // Clear the newline character

        // Writing serialized objects to the file
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(rosterFile))) {
            // Loop through to collect student names
            for (int i = 1; i <= numStudents; i++) {
                System.out.println("Enter first name of student " + i + ": ");
                String firstName = input.nextLine();

                System.out.println("Enter last name of student " + i + ": ");
                String lastName = input.nextLine();

                // Create a StuName object
                StuName student = new StuName(firstName, lastName);

                // Write the serialized StuName object to the file
                objectOut.writeObject(student);
            }

            System.out.println("All students have been written to " + fileName + ".");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Display the roster from the file
        System.out.println("\n--- Class Roster ---");
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(rosterFile))) {
            for (int i = 1; i <= numStudents; i++) {
                StuName student = (StuName) objectIn.readObject();  // Deserialize the object
                System.out.println(student);  // Display each student's name
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        input.close();  // Close scanner to prevent resource leaks
    }
}
