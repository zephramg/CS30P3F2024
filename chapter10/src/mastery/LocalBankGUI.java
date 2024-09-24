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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


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

		// Account number text field.
		accNum = new JTextField();
		accNum.setForeground(Color.LIGHT_GRAY);
		accNum.setText("Enter account number");
		accNum.setBounds(10, 71, 428, 20);
		accNum.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Only clear accNum if it contains the placeholder (logic applied to all text fields)
		        if (accNum.getText().equals("Enter account number")) {
		            accNum.setText(null);
		            accNum.setForeground(Color.BLACK);
		        }
		        // Reset other fields to their placeholders only if they contain the placeholders (logic applied to all text fields)
		        if (amt.getText().equals("Enter amount")) {
		            amt.setText("Enter amount");
		            amt.setForeground(Color.LIGHT_GRAY);
		        }
		        if (fname.getText().equals("Enter first name")) {
		            fname.setText("Enter first name");
		            fname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (lname.getText().equals("Enter last name")) {
		            lname.setText("Enter last name");
		            lname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (bal.getText().equals("Enter balance")) {
		            bal.setText("Enter balance");
		            bal.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		accNum.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        // Reset to placeholder if field is empty when focus is lost (logic applied to all text fields)
		        if (accNum.getText().isEmpty()) {
		            accNum.setText("Enter account number");
		            accNum.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		frame.getContentPane().add(accNum);

		// Amount text field.
		amt = new JTextField();
		amt.setForeground(Color.LIGHT_GRAY);
		amt.setText("Enter amount");
		amt.setBounds(10, 102, 428, 20);
		amt.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (amt.getText().equals("Enter amount")) {
		            amt.setText(null);
		            amt.setForeground(Color.BLACK);
		        }
		        if (accNum.getText().equals("Enter account number")) {
		            accNum.setText("Enter account number");
		            accNum.setForeground(Color.LIGHT_GRAY);
		        }
		        if (fname.getText().equals("Enter first name")) {
		            fname.setText("Enter first name");
		            fname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (lname.getText().equals("Enter last name")) {
		            lname.setText("Enter last name");
		            lname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (bal.getText().equals("Enter balance")) {
		            bal.setText("Enter balance");
		            bal.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		amt.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (amt.getText().isEmpty()) {
		            amt.setText("Enter amount");
		            amt.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		frame.getContentPane().add(amt);

		// First name text field.
		fname = new JTextField();
		fname.setForeground(Color.LIGHT_GRAY);
		fname.setText("Enter first name");
		fname.setBounds(10, 133, 428, 20);
		fname.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (fname.getText().equals("Enter first name")) {
		            fname.setText(null);
		            fname.setForeground(Color.BLACK);
		        }
		        if (accNum.getText().equals("Enter account number")) {
		            accNum.setText("Enter account number");
		            accNum.setForeground(Color.LIGHT_GRAY);
		        }
		        if (amt.getText().equals("Enter amount")) {
		            amt.setText("Enter amount");
		            amt.setForeground(Color.LIGHT_GRAY);
		        }
		        if (lname.getText().equals("Enter last name")) {
		            lname.setText("Enter last name");
		            lname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (bal.getText().equals("Enter balance")) {
		            bal.setText("Enter balance");
		            bal.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		fname.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (fname.getText().isEmpty()) {
		            fname.setText("Enter first name");
		            fname.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		frame.getContentPane().add(fname);

		// Last name text field.
		lname = new JTextField();
		lname.setForeground(Color.LIGHT_GRAY);
		lname.setText("Enter last name");
		lname.setBounds(10, 164, 428, 20);
		lname.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (lname.getText().equals("Enter last name")) {
		            lname.setText(null);
		            lname.setForeground(Color.BLACK);
		        }
		        if (accNum.getText().equals("Enter account number")) {
		            accNum.setText("Enter account number");
		            accNum.setForeground(Color.LIGHT_GRAY);
		        }
		        if (amt.getText().equals("Enter amount")) {
		            amt.setText("Enter amount");
		            amt.setForeground(Color.LIGHT_GRAY);
		        }
		        if (fname.getText().equals("Enter first name")) {
		            fname.setText("Enter first name");
		            fname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (bal.getText().equals("Enter balance")) {
		            bal.setText("Enter balance");
		            bal.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		lname.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (lname.getText().isEmpty()) {
		            lname.setText("Enter last name");
		            lname.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		frame.getContentPane().add(lname);
		
		// Balance text field.
		bal = new JTextField();
		bal.setForeground(Color.LIGHT_GRAY);
		bal.setText("Enter balance");
		bal.setBounds(10, 195, 428, 20);
		bal.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (bal.getText().equals("Enter balance")) {
		            bal.setText(null);
		            bal.setForeground(Color.BLACK);
		        }
		        if (accNum.getText().equals("Enter account number")) {
		            accNum.setText("Enter account number");
		            accNum.setForeground(Color.LIGHT_GRAY);
		        }
		        if (amt.getText().equals("Enter amount")) {
		            amt.setText("Enter amount");
		            amt.setForeground(Color.LIGHT_GRAY);
		        }
		        if (fname.getText().equals("Enter first name")) {
		            fname.setText("Enter first name");
		            fname.setForeground(Color.LIGHT_GRAY);
		        }
		        if (lname.getText().equals("Enter last name")) {
		            lname.setText("Enter last name");
		            lname.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
		bal.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (bal.getText().isEmpty()) {
		            bal.setText("Enter balance");
		            bal.setForeground(Color.LIGHT_GRAY);
		        }
		    }
		});
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
			public void actionPerformed(ActionEvent e) // Adjusts color of text boxes based on what action the user selects.
			{
				
				/* Variable List (for reference)
				 * 
				 * 		accNum, amt, fname, lname, bal
				 * 
				 */
				if(comboBox.getSelectedItem().equals("Add Account")) {
					fname.setForeground(Color.red);
					lname.setForeground(Color.red);
				}
				else if(comboBox.getSelectedItem().equals("Remove Account")) {
					accNum.setForeground(Color.red);
				}
				else if(comboBox.getSelectedItem().equals("Deposit")) {
					accNum.setForeground(Color.red);
					amt.setForeground(Color.red);
				}
				else if(comboBox.getSelectedItem().equals("Withdrawal")) {
					
				}
				else if(comboBox.getSelectedItem().equals("Check Balance")) {
					
				}
				else {
					accNum.setForeground(Color.LIGHT_GRAY);
					amt.setForeground(Color.LIGHT_GRAY);
					fname.setForeground(Color.LIGHT_GRAY);
					lname.setForeground(Color.LIGHT_GRAY);
					bal.setForeground(Color.LIGHT_GRAY);
				}

				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select an action:", " ", "Add Account", "Remove Account", "Deposit", "Withdrawal", "Check Balance"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 11, 428, 49);
		frame.getContentPane().add(comboBox);
		
	}
}
