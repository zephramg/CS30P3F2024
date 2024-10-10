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

        // If the user doesn't provide a file name, use the default "roster.txt"
        if (fileName.trim().isEmpty()) {
            fileName = "roster.txt";  // Default file name
        }

        // Combine the directory and file name
        File rosterFile = new File(defaultDirectory + fileName);

        // Print the absolute path for debugging
        System.out.println("Saving to file at: " + rosterFile.getAbsolutePath());

        // Check if the file exists, if not, create a new file
        try {
            if (rosterFile.createNewFile()) {
                System.out.println("File \"" + fileName + "\" does not exist, creating a new file.");
            } else {
                System.out.println("File \"" + fileName + "\" already exists. It will be overwritten.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }

        int numStudents;

        // Ask the user for the number of students
        System.out.println("Enter the number of students in the class: ");
        numStudents = input.nextInt();
        input.nextLine();  // Clear the newline character

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rosterFile))) {
            // Loop through to collect student names
            for (int i = 1; i <= numStudents; i++) {
                System.out.println("Enter first name of student " + i + ": ");
                String firstName = input.nextLine();

                System.out.println("Enter last name of student " + i + ": ");
                String lastName = input.nextLine();

                // Create a StuName object
                StuName student = new StuName(firstName, lastName);

                // Write the student's full name to the file
                writer.write(student.toString());
                writer.newLine();
            }

            System.out.println("All students have been written to " + fileName + ".");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Display the roster from the file
        System.out.println("\n--- Class Roster ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(rosterFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Display each student's name
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        input.close();  // Close scanner to prevent resource leaks
    }
}
