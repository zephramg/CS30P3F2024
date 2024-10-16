/*
Program: WordCount.java          Last Date of this Revision: October 15, 2024

Purpose: An application that reads words off of a source text file and displays the number of words and the average word length.

Author: Zephram Gilson 
School: CHHS
Course: Computer Science 30
*/

package mastery;

import java.io.*;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        // File path to the source.txt file
        String filePath = "C:/Users/38020001/git/CS30P3F2024/chapter11/src/mastery/source.txt";
        
        int wordCount = 0;
        int totalWordLength = 0;
        
        try {
            // Create a Scanner to read the file
            Scanner fileScanner = new Scanner(new File(filePath));
            
            // Process the file, word by word
            while (fileScanner.hasNext()) {
                // Read the next sequence of characters (including hyphenated words)
                String word = fileScanner.next();
                
                // Split by hyphen to treat hyphenated words as separate words
                String[] splitWords = word.split("-");

                // Iterate over the split words
                for (String splitWord : splitWords) {
                    // Remove any non-letter characters (punctuation, numbers, etc.)
                    splitWord = splitWord.replaceAll("[^a-zA-Z]", "");
                    
                    // If the split word is a valid word (not empty), count it
                    if (!splitWord.isEmpty()) {
                        wordCount++;
                        totalWordLength += splitWord.length();
                    }
                }
            }
            
            // Close the scanner
            fileScanner.close();
            
            // Display the results
            System.out.println("Number of words: " + wordCount);
            if (wordCount > 0) {
                double averageWordLength = (double) totalWordLength / wordCount;
                System.out.printf("Average word length: " + averageWordLength);
            } else {
                System.out.println("No words found.");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}


/* Screen Dump (Words in source.txt are: [chromatography open-mouthed mute])
  
  	Number of words: 4
	Average word length: 7.25
  
 */
 