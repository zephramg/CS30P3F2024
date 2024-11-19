/*
 * This program estimates the value of π using the Buffon’s Needle problem,
 * a probability-based method involving geometric probability.
 *
 * The Buffon’s Needle problem simulates dropping a needle onto a plane with parallel lines
 * and calculates the probability of the needle crossing a line. This probability is then
 * used to approximate π.
 *
 * Key components:
 * 1. `approximatePi` Method:
 *    - Simulates the experiment with a specified number of needle throws (`numThrows`),
 *      distance between parallel lines (`lineSpacing`), and needle length (`needleLength`).
 *    - Uses random angles and distances to determine whether the needle crosses a line.
 *    - Estimates π based on the ratio of line crossings to total throws.
 * 
 * 2. Main Method:
 *    - Runs the simulation with example parameters.
 *    - Outputs the estimated value of π and its accuracy compared to the true value of π,
 *      rounded to two decimal places.
 *
 * This program demonstrates the use of Monte Carlo simulation techniques
 * and explores the relationship between geometry and probability.
 * 
 * Author : Zephram Gilson
 * Date: November 2024
 * 
 */


package other;

import java.util.Random;


public class BuffonsNeedle {

    public static double approximatePi(int numThrows, double lineSpacing, double needleLength) {
        int crosses = 0;
        Random random = new Random();

        for (int i = 0; i < numThrows; i++) {
            // Random angle between 0 and π/2 (in radians)
            double angle = random.nextDouble() * Math.PI / 2;

            // Random distance from the needle's center to the closest line
            double distanceToLine = random.nextDouble() * (lineSpacing / 2);

            // Check if the needle crosses a line
            if (distanceToLine <= (needleLength / 2) * Math.sin(angle)) {
                crosses++;
            }
        }

        // Estimate π using the formula
        if (crosses == 0) {
            return Double.POSITIVE_INFINITY; // Avoid division by zero
        }
        return (2 * needleLength * numThrows) / (crosses * lineSpacing);
    }

    public static void main(String[] args) {
        // Example parameters
        int numThrows = 1000000;  // Number of needle throws
        double lineSpacing = 2.0; // Distance between lines
        double needleLength = 1.5; // Length of the needle

        // Estimate π
        double piEstimate = approximatePi(numThrows, lineSpacing, needleLength);
        System.out.println("Estimated value of π: " + piEstimate);
        
        double accuracy = 0;

        // Calculate accuracy
        if (piEstimate > Math.PI) {
        	accuracy = (Math.PI / piEstimate) * 100;
        } else if (piEstimate < Math.PI) {
	         accuracy = (piEstimate / Math.PI) * 100;
	     } else if (piEstimate == Math.PI) {
	         accuracy = 100;
	     }
	
	     // Round accuracy to the nearest hundredth
	     accuracy = Math.round(accuracy * 100.0) / 100.0;
	
	     System.out.println("Calculated accuracy: " + accuracy + "%");

    }
}
