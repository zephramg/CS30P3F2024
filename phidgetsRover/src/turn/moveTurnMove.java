/* Challenge: Try moving forwards, turning 180°, and moving back to your starting position. */

package turn;

// Add Phidgets Library
import com.phidget22.*;

public class moveTurnMove {
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

        // Move forward
        leftMotors.setTargetVelocity(-1);
        rightMotors.setTargetVelocity(-1);
        // Wait for 2 seconds (adjust if necessary for distance)
        Thread.sleep(2000);

        // Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        // Wait briefly
        Thread.sleep(500);

        // Turn 180° (reduce the time to achieve a half rotation)
        leftMotors.setTargetVelocity(1);
        rightMotors.setTargetVelocity(-1);
        // Adjust timing to approximately 180° (start with 800 ms and refine)
        Thread.sleep(785); // Start here, adjust in small increments (700-900 ms)

        // Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
        // Wait briefly
        Thread.sleep(1000);

        // Move backward (same duration as forward to return to start)
        leftMotors.setTargetVelocity(-1);
        rightMotors.setTargetVelocity(-1);
        // Wait for 2 seconds
        Thread.sleep(2150);

        // Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);

        // Close motors
        leftMotors.close();
        rightMotors.close();
    }
}
