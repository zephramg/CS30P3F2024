/* Challenge: Change your Target Velocity to 0.5 for both motors. */

package move;
 
import com.phidget22.DCMotor;
import com.phidget22.Net;

public class halfVelocity {
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

        // Move forward at full speed
        leftMotors.setTargetVelocity(.5);
        rightMotors.setTargetVelocity(.5);

        // Wait for 1 second
        Thread.sleep(1000);

        // Stop motors
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
    }
}
   