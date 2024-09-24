package mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBankGUI {

	private JFrame frame;
	private JTextField accNum;
	private JTextField amt;
	private JTextField fname;
	private JTextField lname;
	private JTextField bal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBankGUI window = new LocalBankGUI();
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
	public LocalBankGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		accNum = new JTextField();
		accNum.setForeground(Color.LIGHT_GRAY);
		accNum.setText("Enter account number");
		accNum.setBounds(10, 71, 428, 20);
		frame.getContentPane().add(accNum);
		accNum.setColumns(10);
		
		amt = new JTextField();
		amt.setText("Enter amount");
		amt.setForeground(Color.LIGHT_GRAY);
		amt.setColumns(10);
		amt.setBounds(10, 102, 428, 20);
		frame.getContentPane().add(amt);
		
		fname = new JTextField();
		fname.setText("Enter first name");
		fname.setForeground(Color.LIGHT_GRAY);
		fname.setColumns(10);
		fname.setBounds(10, 133, 428, 20);
		frame.getContentPane().add(fname);
		
		lname = new JTextField();
		lname.setText("Enter last name");
		lname.setForeground(Color.LIGHT_GRAY);
		lname.setColumns(10);
		lname.setBounds(10, 164, 428, 20);
		frame.getContentPane().add(lname);
		
		bal = new JTextField();
		bal.setText("Enter balance");
		bal.setForeground(Color.LIGHT_GRAY);
		bal.setColumns(10);
		bal.setBounds(10, 195, 428, 20);
		frame.getContentPane().add(bal);
		
		JLabel disp = new JLabel("New label");
		disp.setBounds(10, 226, 428, 82);
		frame.getContentPane().add(disp);
		
		JButton process = new JButton("Process Transaction");
		process.setFont(new Font("Tahoma", Font.PLAIN, 16));
		process.setBounds(10, 319, 428, 71);
		frame.getContentPane().add(process);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // adjusts color of text boxes based on what action the user selects
			{
				
				/* Variable List (for reference)
				 * 
				 * 
				 * 
				 */
				if(comboBox.getSelectedItem().equals("Add Account")) {
					
				}
				else if(comboBox.getSelectedItem().equals("Remove Account")) {
					
				}
				else if(comboBox.getSelectedItem().equals("Deposit")) {
					accNum.setForeground(Color.red);
					amt.setForeground(Color.red);
				}
				else if(comboBox.getSelectedItem().equals("Add Account")) {
					
				}
				else if(comboBox.getSelectedItem().equals("Add Account")) {
					
				}

				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select an action:", "________", "Add Account", "Remove Account", "Deposit", "Withdrawal", "Check Balance"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 11, 428, 49);
		frame.getContentPane().add(comboBox);
		
	}
}
