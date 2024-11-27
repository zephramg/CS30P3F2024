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

        // Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        // Open
        leftMotors.open(5000);
        rightMotors.open(5000);

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
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        // Move forward
                        leftMotors.setTargetVelocity(-1);
                        rightMotors.setTargetVelocity(-1);
                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
                        // Move backward
                        leftMotors.setTargetVelocity(1);
                        rightMotors.setTargetVelocity(1);
                    }
                } catch (PhidgetException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                        // Stop motors
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

        // Add a shutdown hook to ensure the motors close properly on exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                leftMotors.close();
                rightMotors.close();
            } catch (PhidgetException e) {
                e.printStackTrace();
            }
        }));
    }
}
