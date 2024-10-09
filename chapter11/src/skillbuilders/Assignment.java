package skillbuilders;

import java.io.*;
import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName;

        // Ask the user for a file name or path
        System.out.println("Enter the file name or the full path to the instructions file (leave blank for default): ");
        fileName = input.nextLine();

        // If the user doesn't provide a path, use the default path
        if (fileName.trim().isEmpty()) {
            // Set the default path from where file is searched
            fileName = "C:/Users/38020001/git/CS30P3F2024/chapter11/src/skillbuilders/assignment_instructions.txt";
        }

        File instructionsFile = new File(fileName);

        // Print the absolute path for debugging
        System.out.println("Looking for file at: " + instructionsFile.getAbsolutePath());

        // Check if the file exists
        if (!instructionsFile.exists()) {
            System.out.println("The file \"" + fileName + "\" does not exist. Please make sure the file path is correct.");
            return;  // Exit if file doesn't exist
        }

        // Try reading the file and displaying its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(instructionsFile))) {
            String line;
            System.out.println("\n--- Assignment Instructions ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print each line from the file
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        input.close();  // Close the Scanner to avoid resource leaks
    }
}
