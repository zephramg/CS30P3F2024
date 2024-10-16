/*

Program: FindAndReplace.java          Last Date of this Revision: October 16, 2024

Purpose: An application that finds a user-input word from a user-input file path and replaces it with another word of the user's choice.

Author: Zephram Gilson
School: CHHSC:/Users/38020001/git/CS30P3F2024/chapter11/src/mastery/source.txt
Course: Computer Science 30
 

*/


package mastery;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt for the file name
        System.out.print("Enter the file name (with path): ");
        String fileName = input.nextLine();
        
        // Prompt for the word/phrase to search for
        System.out.print("Enter the word/phrase to search for: ");
        String searchWord = input.nextLine();
        
        // Prompt for the word/phrase to replace with
        System.out.print("Enter the replacement word/phrase: ");
        String replacementWord = input.nextLine();

        // Read the file content, perform replacement, and write back to the file
        try {
            // Read the file content
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }
            
            // Using StringBuilder to store file content for efficient replacement
            StringBuilder fileContent = new StringBuilder();
            Scanner fileScanner = new Scanner(file);
            
            // Read the file line by line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                fileContent.append(line).append(System.lineSeparator()); // Preserve line breaks
            }
            fileScanner.close();
            
            // Perform the replacement
            String updatedContent = fileContent.toString().replace(searchWord, replacementWord);
            
            // Write the updated content back to the file
            FileWriter writer = new FileWriter(file);
            writer.write(updatedContent);
            writer.close();
            
            System.out.println("Replacement completed successfully.");
            
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
        }
        
        input.close();
    }
}

/* Screen Dump

Enter the file name (with path): C:/Users/38020001/git/CS30P3F2024/chapter11/src/mastery/source.txt
Enter the word/phrase to search for: mute
Enter the replacement word/phrase: likeminded
Replacement completed successfully.

 
 */