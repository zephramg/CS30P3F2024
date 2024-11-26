/* Challenge: Modify the Sonar Phidget's Data Interval so it updates 
every 100 milliseconds (10 times a second) instead of every 250 milliseconds (4 times a second). 
Modify your loop delay to reflect the new interval. */

package avoidObstacles;

// Add Phidgets Library
import com.phidget22.*;

public class modDataInterval {
    public static void main(String[] args) throws Exception {

        // Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        // Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();
        DistanceSensor sonar = new DistanceSensor();

        // Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        // Open
        leftMotors.open(5000);
        rightMotors.open(5000);
        sonar.open(5000);

        // Set Data Interval to 100 ms
        sonar.setDataInterval(100);

        while (true) {

            // Read and print the distance from the sonar
            System.out.println("Distance: " + sonar.getDistance() + " mm");

            if (sonar.getDistance() < 300) { // Object detected within 300 mm
                // Back up for 1 second
                leftMotors.setTargetVelocity(0.5); // Reverse
                rightMotors.setTargetVelocity(0.5); // Reverse
                Thread.sleep(1000);

                // Turn in place for 1 second
                leftMotors.setTargetVelocity(0.5); // Turn
                rightMotors.setTargetVelocity(-0.5); // Turn
                Thread.sleep(1000);
            } else {
                // Move forward (50% speed)
                leftMotors.setTargetVelocity(-0.5);
                rightMotors.setTargetVelocity(-0.5);
            }

            // Wait for 100 milliseconds (matches data interval)
            Thread.sleep(100);
        }
    }
}
 