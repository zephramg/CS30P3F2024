package mastery;

import java.io.*;
import java.util.Scanner;

// TODO fix words needing to be on the same line

public class WordCount {
    public static void main(String[] args) {
        // File path to the source.txt file
        String filePath = "C:/Users/38020001/git/CS30P3F2024/chapter11/src/mastery/source.txt";
        
        int wordCount = 0;
        int totalWordLength = 0;
        
        try {
            // Create a Scanner to read the file
            Scanner fileScanner = new Scanner(new File(filePath));
            
            // Use a regular expression to match words
            while (fileScanner.hasNext()) {
                // Read the next word (sequence of letters)
                String word = fileScanner.findInLine("[a-zA-Z]+");
                if (word != null) {
                    wordCount++;
                    totalWordLength += word.length();
                } else {
                    // Skip non-letter characters
                    fileScanner.next();
                }
            }
            
            // Close the scanner
            fileScanner.close();
            
            // Display the results
            System.out.println("Number of words: " + wordCount);
            if (wordCount > 0) {
                double averageWordLength = (double) totalWordLength / wordCount;
                System.out.printf("Average word length: %.2f%n", averageWordLength);
            } else {
                System.out.println("No words found.");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}
