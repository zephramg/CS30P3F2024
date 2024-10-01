
/*

Program: LocalBankGUI.java          Last Date of this Revision: October 1, 2024

Purpose: A bank application using a GUI that allows the user to use features such as
	deposit, withdraw, check balance, create account, etc.

Author: Zephram Gilson 
School: CHHS
Course: Computer Science 30
 

*/

package mastery;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocalBankGUI {

	private JFrame frame;
	private JTextField acctNum;
	private JTextField amt;
	private JTextField fName;
	private JTextField lName;
	private JTextField begBalance;
	
	Bank easySave = new Bank(); // Bank object to handle transactions
	
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
		frame.setBounds(100, 100, 521, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Account number field
		acctNum = new JTextField();
		acctNum.setForeground(Color.GRAY);
		acctNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		acctNum.setText("Enter account number:");
		acctNum.setBounds(34, 106, 436, 19);
		frame.getContentPane().add(acctNum);
		acctNum.setColumns(10);
		
		acctNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acctNum.setText("");
				acctNum.setForeground(Color.BLACK);
			}
		});
		
		// Amount field
		amt = new JTextField();
		amt.setText("Enter amount:");
		amt.setForeground(Color.GRAY);
		amt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amt.setBounds(34, 136, 436, 19);
		frame.getContentPane().add(amt);
		
		amt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				amt.setText("");
				amt.setForeground(Color.BLACK);
			}
		});
		
		// First name field
		fName = new JTextField();
		fName.setText("Enter first name:");
		fName.setForeground(Color.GRAY);
		fName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fName.setBounds(34, 170, 436, 19);
		frame.getContentPane().add(fName);
		
		fName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fName.setText("");
				fName.setForeground(Color.BLACK);
			}
		});
		
		// Last name field
		lName = new JTextField();
		lName.setText("Enter last name:");
		lName.setForeground(Color.GRAY);
		lName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lName.setBounds(34, 200, 436, 19);
		frame.getContentPane().add(lName);
		
		lName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lName.setText("");
				lName.setForeground(Color.BLACK);
			}
		});
		
		// Beginning balance field
		begBalance = new JTextField();
		begBalance.setText("Enter beginning balance:");
		begBalance.setForeground(Color.GRAY);
		begBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		begBalance.setBounds(34, 230, 436, 19);
		frame.getContentPane().add(begBalance);
		
		begBalance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				begBalance.setText("");
				begBalance.setForeground(Color.BLACK);
			}
		});
		
		// Label to display account info
		JLabel acctinfo = new JLabel("Account info displayed here");
		acctinfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		acctinfo.setBounds(34, 260, 436, 52);
		frame.getContentPane().add(acctinfo);
		
		// ComboBox for bank activities
		JComboBox<String> bankActivities = new JComboBox<>();
		bankActivities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bankActivities.setModel(new DefaultComboBoxModel<>(new String[] {
			"Select an action:", "Deposit", "Withdrawal", "Check Balance", "Add Account", "Remove Account"
		}));
		bankActivities.setBounds(34, 24, 436, 46);
		frame.getContentPane().add(bankActivities);
		
		// Button for processing transaction
		JButton btnNewButton = new JButton("Process Transaction");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(34, 341, 436, 54);
		frame.getContentPane().add(btnNewButton);
		
		// Action listener for processing transactions
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message;
				
				switch (bankActivities.getSelectedItem().toString()) {
					case "Deposit":
						message = processDeposit();
						break;
					case "Withdrawal":
						message = processWithdrawal();
						break;
					case "Check Balance":
						message = checkBalance();
						break;
					case "Add Account":
						message = addAccount();
						break;
					case "Remove Account":
						message = removeAccount();
						break;
					default:
						message = "Please select a valid action.";
				}
				
				acctinfo.setText(message);
			}
			
			private String processDeposit() {
				try {
					double amount = Double.parseDouble(amt.getText());
					return easySave.transaction(1, acctNum.getText(), amount);
				} catch (NumberFormatException ex) {
					return "Invalid amount. Please enter a valid number.";
				}
			}
			
			private String processWithdrawal() {
				try {
					double amount = Double.parseDouble(amt.getText());
					return easySave.transaction(2, acctNum.getText(), amount);
				} catch (NumberFormatException ex) {
					return "Invalid amount. Please enter a valid number.";
				}
			}
			
			private String checkBalance() {
				return easySave.checkBalance(acctNum.getText());
			}
			
			private String addAccount() {
				try {
					double balance = Double.parseDouble(begBalance.getText());
					return "New Account ID: " + easySave.addAccount(fName.getText(), lName.getText(), balance);
				} catch (NumberFormatException ex) {
					return "Invalid balance. Please enter a valid number.";
				}
			}
			
			private String removeAccount() {
				return easySave.deleteAccount(acctNum.getText());
			}
		});
	}
}
