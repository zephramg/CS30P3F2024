package avoidObstacles; 

// Add Phidgets Library
import com.phidget22.*;

public class modifySpeed { 
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

        while (true) {

            // Read and print the distance from the sonar
            System.out.println("Distance: " + sonar.getDistance() + " mm");
            
            if (sonar.getDistance() < 300) { // New detection distance: 300 mm
                // Object detected! Stop motors
                leftMotors.setTargetVelocity(0);
                rightMotors.setTargetVelocity(0);
            } else {
                // Move forward faster (50% max speed)
                leftMotors.setTargetVelocity(-0.5); // Adjusted speed
                rightMotors.setTargetVelocity(-0.5); // Adjusted speed
            }

            // Wait for 250 milliseconds (keeps it responsive)
            Thread.sleep(250);
        }
    }
}
  