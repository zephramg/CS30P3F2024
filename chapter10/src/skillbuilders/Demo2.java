package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Demo2 {

	private JFrame frame;
	private JTextField FNt;
	private JTextField LNt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo2 window = new Demo2();
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
	public Demo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		task
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 566, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		FNt = new JTextField();
		FNt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				FNt.setText(""); // Clears text.
			}
		});
		FNt.setForeground(new Color(192, 192, 192));
		FNt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FNt.setText(" First Name");
		FNt.setBounds(10, 11, 171, 36);
		panel.add(FNt);
		FNt.setColumns(10);
		
		LNt = new JTextField();
		LNt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			
				LNt.setText("");
			}
		});
		LNt.setForeground(new Color(192, 192, 192));
		LNt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNt.setText(" Last Name");
		LNt.setColumns(10);
		LNt.setBounds(200, 11, 171, 36);
		panel.add(LNt);
		
		
		JComboBox grades = new JComboBox();
		grades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		grades.setModel(new DefaultComboBoxModel(new String[] {"Select Grade", "10", "11", "12"}));
		grades.setBounds(10, 57, 171, 36);
		panel.add(grades);
		
		JComboBox schools = new JComboBox();
		schools.setFont(new Font("Tahoma", Font.PLAIN, 14));
		schools.setModel(new DefaultComboBoxModel(new String[] {"Select School", "Crescent Heights", "Lester B. Pearson", "Western"}));
		schools.setBounds(200, 58, 173, 36);
		panel.add(schools);
		
		JTextArea disp = new JTextArea();
		disp.setBounds(10, 104, 361, 74);
		panel.add(disp);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  
			{
				String grade = " ";
				String school = " ";
				String fN = FNt.getText();
				String lN = LNt.getText();
				
				
				// Grades
				if(grades.getSelectedItem().equals("10")) {
					grade = "10";
				}
				
				if(grades.getSelectedItem().equals("11")) {
					grade = "11";
				}
				
				if(grades.getSelectedItem().equals("12")) {
					grade = "12";
				}
				
				// Schools
				if(schools.getSelectedItem().equals("Crescent Heights")) {
					school = "Crescent";
				}
				
				if(schools.getSelectedItem().equals("Lester B. Pearson")) {
					school = "Pearson";
				}
				
				if(schools.getSelectedItem().equals("Western")) {
					school = "Western";
				}
				
				
				
				
				// Display information
				disp.setText(
					fN + " " +
					lN + " is in grade " +
					grade + " and goes to " +
					school
					
			    
						);
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submit.setBounds(381, 11, 175, 167);
		panel.add(submit);


		
		JLabel img = new JLabel("");
		img.setBounds(10, 189, 526, 110);
		panel.add(img);
	}
}
