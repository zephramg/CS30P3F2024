package keyControl;

// Add Phidgets Library
import com.phidget22.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class keyControl {

    public static void main(String[] args) throws Exception {

        // Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        // Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();
        DistanceSensor distanceSensor = new DistanceSensor();

        // Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        // Open motors and distance sensor
        leftMotors.open(5000);
        rightMotors.open(5000);
        distanceSensor.open(5000);

        // Define a safe distance threshold (in mm)
        final int SAFE_DISTANCE = 100; // 100 mm = 10 cm

        // Variable to track forward movement permission
        boolean[] canMoveForward = {true}; // Use an array for mutability in lambda expressions

        // Start a thread to monitor the distance sensor
        new Thread(() -> {
            try {
                while (true) {
                    int distance = distanceSensor.getDistance();
                    canMoveForward[0] = distance >= SAFE_DISTANCE; // Allow forward movement only if safe
                    if (!canMoveForward[0]) {
                        System.out.println("Obstacle detected! Forward movement blocked.");
                    }
                    Thread.sleep(50); // Check distance every 50 ms
                }
            } catch (PhidgetException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Create a JFrame to capture key events
        JFrame frame = new JFrame("Rover Control");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Add KeyListener to capture key presses
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            if (canMoveForward[0]) { // Only move forward if safe
                                leftMotors.setTargetVelocity(-1);
                                rightMotors.setTargetVelocity(-1);
                            } else {
                                System.out.println("Cannot move forward! Obstacle detected.");
                            }
                            break;
                        case KeyEvent.VK_S:
                            // Move backward
                            leftMotors.setTargetVelocity(1);
                            rightMotors.setTargetVelocity(1);
                            break;
                        case KeyEvent.VK_A:
                            // Turn left (left motor slower, right motor faster)
                            leftMotors.setTargetVelocity(0.5);
                            rightMotors.setTargetVelocity(-0.5);
                            break;
                        case KeyEvent.VK_D:
                            // Turn right (left motor faster, right motor slower)
                            leftMotors.setTargetVelocity(-0.5);
                            rightMotors.setTargetVelocity(0.5);
                            break;
                    }
                } catch (PhidgetException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    // Stop movement when any control key is released
                    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S || 
                        e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
                        leftMotors.setTargetVelocity(0);
                        rightMotors.setTargetVelocity(0);
                    }
                } catch (PhidgetException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used
            }
        });

        // Add a shutdown hook to ensure the motors and sensor close properly on exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                leftMotors.close();
                rightMotors.close();
                distanceSensor.close();
            } catch (PhidgetException e) {
                e.printStackTrace();
            }
        }));
    }
}
