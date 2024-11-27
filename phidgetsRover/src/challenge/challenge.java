/* Challenge: Make the rover travel approx 1m, turn 90 degrees, 
drive forward another 1m, turn 90, etc., such that it drives in 
one full square and ends in the same position as it started, 
with an adjustment to straighten at the end. */

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
        int driveTime = 964; // Approximate time for 1 meter at full speed
        int turnTime = 324; // Approximate time for a 90° turn
        int finalTurnAdjustment = 72; // Additional time to straighten out at the end

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

            // Turn 90 degrees (adjust last turn slightly)
            if (i == 3) {
                // Last turn includes slight adjustment
                leftMotors.setTargetVelocity(1);
                rightMotors.setTargetVelocity(-1);
                Thread.sleep(turnTime + finalTurnAdjustment);
            } else {
                // Standard 90° turn
                leftMotors.setTargetVelocity(1);
                rightMotors.setTargetVelocity(-1);
                Thread.sleep(turnTime);
            }

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
