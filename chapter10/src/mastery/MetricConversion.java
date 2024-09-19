package mastery;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MetricConversion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Set up the main frame
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Label to prompt user
		JLabel prompt = new JLabel("Select conversion type:");
		prompt.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(prompt);
		
		// ComboBox to select conversion type
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"inches to centimeters", 
			"feet to meters", 
			"gallons to liters", 
			"pounds to kilograms"
		}));
		comboBox.setBounds(10, 31, 250, 22);
		frame.getContentPane().add(comboBox);
		
		// Label to display conversion result
		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(10, 64, 250, 22);
		frame.getContentPane().add(resultLabel);
		
		// Add action listener to the comboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the selected item from the comboBox
				String selectedItem = (String) comboBox.getSelectedItem();
				
				// Display the corresponding conversion based on the selection
				switch (selectedItem) {
					case "inches to centimeters":
						resultLabel.setText("1 inch = 2.54 centimeters");
						break;
					case "feet to meters":
						resultLabel.setText("1 foot = 0.3048 meters");
						break;
					case "gallons to liters":
						resultLabel.setText("1 gallon = 4.5461 liters");
						break;
					case "pounds to kilograms":
						resultLabel.setText("1 pound = 0.4536 kilograms");
						break;
				}
			}
		});
	}
}
