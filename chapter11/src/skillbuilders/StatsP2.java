package skillbuilders;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class StatsP2 {

    public static void main(String[] args) {
        File dataFile;
        FileWriter out;
        BufferedWriter writeFile;
        FileReader in;
        BufferedReader readFile;
        String StuName, score;
        double scoreValue;
        double lowScore = 100;
        double highScore = 0;
        double avgScore;
        double totalScores = 0;
        int numScores = 0;

        NumberFormat percent = NumberFormat.getPercentInstance();
        Scanner input = new Scanner(System.in);

        try {
            // Prompt for file name and number of student scores
            System.out.println("Enter the name of the file to create (e.g., test1.txt): ");
            String fileName = input.nextLine();
            dataFile = new File(fileName);

            System.out.println("Enter the number of student grades to input: ");
            int numGrades = input.nextInt();
            input.nextLine();  // Consume the newline

            // Open the file for writing
            out = new FileWriter(dataFile);
            writeFile = new BufferedWriter(out);

            // Input student names and scores
            for (int i = 0; i < numGrades; i++) {
                System.out.println("Enter student name: ");
                StuName = input.nextLine();
                System.out.println("Enter " + StuName + "'s score: ");
                score = input.nextLine();

                // Write student name and score to file
                writeFile.write(StuName);
                writeFile.newLine();
                writeFile.write(score);
                writeFile.newLine();
            }

            // Close the writing stream
            writeFile.close();

            // Open the file for reading
            in = new FileReader(dataFile);
            readFile = new BufferedReader(in);

            // Read student names and scores, and calculate stats
            while ((StuName = readFile.readLine()) != null) {
                score = readFile.readLine();
                System.out.println(StuName + " " + score);
                numScores++;
                scoreValue = Double.parseDouble(score);
                totalScores += scoreValue;

                if (scoreValue < lowScore) {
                    lowScore = scoreValue;
                }
                if (scoreValue > highScore) {
                    highScore = scoreValue;
                }
            }

            // Calculate average score
            avgScore = totalScores / numScores;

            // Display statistics
            System.out.println("Low Score = " + percent.format(lowScore / 100));
            System.out.println("High Score = " + percent.format(highScore / 100));
            System.out.println("Average = " + percent.format(avgScore / 100));

            // Close the reading stream
            readFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Problem reading/writing file.");
            System.err.println("IOException: " + e.getMessage());
        } finally {
            input.close();  // Close the scanner
        }
    }
}
