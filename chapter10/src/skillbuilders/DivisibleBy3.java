package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DivisibleBy3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisibleBy3 window = new DivisibleBy3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DivisibleBy3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 156);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Prompt user.
		JLabel lblNewLabel = new JLabel("Enter an integer:");
		lblNewLabel.setBounds(67, 37, 169, 14);
		frame.getContentPane().add(lblNewLabel);
		
		// Collect user input.
		textField = new JTextField();
		textField.setBounds(169, 34, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		// Declare output label.
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(179, 66, 234, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String inputNum = textField.getText(); // Get user input.
                try {
                    // Try to convert input to an integer.
                    int number = Integer.parseInt(inputNum);
                    
                    // Check if number is divisible by 3.
                    if (number % 3 == 0) {
                        lblNewLabel_1.setText(number + " is divisible by 3");
                    } else {
                        lblNewLabel_1.setText(number + " is not divisible by 3");
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid input (not an integer).
                    lblNewLabel_1.setText("Please enter a valid integer");
                }
            }
        });
		btnNewButton.setBounds(67, 62, 101, 23);
		frame.getContentPane().add(btnNewButton);

	}
}
