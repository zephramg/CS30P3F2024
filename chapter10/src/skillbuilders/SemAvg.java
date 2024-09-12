package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class SemAvg {

	private JFrame frame;
	private JTextField gr1;
	private JTextField gr2;
	private JTextField gr3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemAvg window = new SemAvg();
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
	public SemAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		/* Grade labels */
		JLabel lblNewLabel = new JLabel("Grade #1:");
		lblNewLabel.setBounds(31, 33, 63, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGrade = new JLabel("Grade #2:");
		lblGrade.setBounds(31, 71, 63, 56);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblNewLabel_1_1 = new JLabel("Grade #3:");
		lblNewLabel_1_1.setBounds(31, 109, 63, 56);
		frame.getContentPane().add(lblNewLabel_1_1);

		
		/* Grade text fields */
		gr1 = new JTextField();
		gr1.setBounds(89, 51, 86, 20);
		frame.getContentPane().add(gr1);
		gr1.setColumns(10);
		
		gr2 = new JTextField();
		gr2.setBounds(89, 89, 86, 20);
		frame.getContentPane().add(gr2);
		gr2.setColumns(10);
		
		gr3 = new JTextField();
		gr3.setBounds(89, 127, 86, 20);
		frame.getContentPane().add(gr3);
		gr3.setColumns(10);
		
		
		
		
		// Display
		JLabel disp = new JLabel("");
		disp.setBounds(291, 33, 170, 249);
		frame.getContentPane().add(disp);
		
		// Submit button.
		JButton btnNewButton = new JButton("Calculate Average");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				DecimalFormat dc = new DecimalFormat("0.00");
				
				// Makes strings act as numbers.
				double grTx1 = Double.parseDouble(gr1.getText());
				double grTx2 = Double.parseDouble(gr2.getText());
				double grTx3 = Double.parseDouble(gr3.getText());
				
				double average = (grTx1 + grTx2 + grTx3) / 3;
				
				// Convert average double back to string in order for computations.
				disp.setText(dc.format(average));
				
			}
		});
		btnNewButton.setBounds(89, 176, 126, 23);
		frame.getContentPane().add(btnNewButton);

	}
}
