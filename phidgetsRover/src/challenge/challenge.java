/* Challenge: Make the rover travel approx 1m, turn 90 degrees, 
drive forward another 1m, turn 90, etc., such that it drives in 
one full square and ends in the same position as it started. */ 
 
package challenge;

// Add Phidgets Library
import com.phidget22.*;

public class challenge {
    public static void main(String[] args) throws Exception {

        // Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        // Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();

        // Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        // Open
        leftMotors.open(5000);
        rightMotors.open(5000);

        // Define the time to drive forward 1m (adjust based on rover speed)
        int driveTime = 962; // Approximate time for 1 meter at full speed
        int turnTime = 296; // Approximate time for a 90° turn

        // Repeat for four sides of the square
        for (int i = 0; i < 4; i++) {
            // Move forward for 1 meter
            leftMotors.setTargetVelocity(-1);
            rightMotors.setTargetVelocity(-1);
            Thread.sleep(driveTime);

            // Stop motors briefly
            leftMotors.setTargetVelocity(0);
            rightMotors.setTargetVelocity(0);
            Thread.sleep(500);

            // Turn 90 degrees
            leftMotors.setTargetVelocity(1);
            rightMotors.setTargetVelocity(-1);
            Thread.sleep(turnTime);

            // Stop motors briefly
            leftMotors.setTargetVelocity(0);
            rightMotors.setTargetVelocity(0);
            Thread.sleep(500);
        }

        // Stop and close motors after completing the square
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        leftMotors.close();
        rightMotors.close();
    }
}
