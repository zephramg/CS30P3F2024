package skillbuilders;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFileP2 {

    public static void main(String[] args) {
        // Declaration
        File textFile;
        Scanner input = new Scanner(System.in);
        String response;

        // Create a file with a relative path
        textFile = new File("src/skillbuilders/zzz.txt");

        if (textFile.exists()) {
            System.out.println("zzz.txt exists.");
        } else {
            System.out.println("File does not exist.");
            try {
                // Try to create the file
                if (textFile.createNewFile()) {
                    System.out.println("zzz.txt has been created.");
                } else {
                    System.out.println("File could not be created.");
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
            }

            // Ask user if they want to keep or delete the file
            System.out.println("Would you like to (K)eep or (D)elete the file? ");
            response = input.next();
            
            if (response.equalsIgnoreCase("D")) {
                if (textFile.delete()) {
                    System.out.println("File deleted.");
                } else {
                    System.out.println("File could not be deleted.");
                }
            } else {
                System.out.println("File is kept.");
            }
        }

        // Close the Scanner to prevent resource leaks
        input.close();
    }
}
