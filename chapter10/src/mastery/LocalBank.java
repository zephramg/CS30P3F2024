package mastery;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

class Account {
    private String accountID;
    private String firstName;
    private String lastName;
    private double balance;

    public Account(String accountID, String firstName, String lastName, double balance) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getAccountInfo() {
        return "<html><b>Account ID:</b> " + accountID + "<br>"
                + "<b>Name:</b> " + firstName + " " + lastName + "<br>"
                + "<b>Current Balance:</b> $" + String.format("%.2f", balance) + "</html>";
    }
}

public class LocalBank {

    private JFrame frame;
    private JPanel menuPanel, inputPanel, displayPanel;
    private JButton addAccountBtn, depositBtn, withdrawBtn, checkBalanceBtn, removeAccountBtn, quitBtn;
    private JTextArea displayArea;
    private Map<String, Account> accounts = new HashMap<>();

    // Input fields
    private JTextField firstNameField, lastNameField, accountIDField, amountField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LocalBank window = new LocalBank();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LocalBank() {
        initialize();
    }

    private void initialize() {
        // Setup main frame
        frame = new JFrame("Local Bank");
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Setup menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addAccountBtn = new JButton("Add an Account");
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdrawal");
        checkBalanceBtn = new JButton("Check Balance");
        removeAccountBtn = new JButton("Remove an Account");
        quitBtn = new JButton("Quit");

        menuPanel.add(addAccountBtn);
        menuPanel.add(depositBtn);
        menuPanel.add(withdrawBtn);
        menuPanel.add(checkBalanceBtn);
        menuPanel.add(removeAccountBtn);
        menuPanel.add(quitBtn);

        frame.add(menuPanel, BorderLayout.WEST);

        // Setup input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new CardLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panels for each operation
        inputPanel.add(createAddAccountPanel(), "AddAccount");
        inputPanel.add(createDepositPanel(), "Deposit");
        inputPanel.add(createWithdrawPanel(), "Withdraw");
        inputPanel.add(createCheckBalancePanel(), "CheckBalance");
        inputPanel.add(createRemoveAccountPanel(), "RemoveAccount");

        frame.add(inputPanel, BorderLayout.CENTER);

        // Setup display panel
        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Display"));

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(displayPanel, BorderLayout.SOUTH);

        // Action Listeners for menu buttons
        addAccountBtn.addActionListener(e -> showPanel("AddAccount"));
        depositBtn.addActionListener(e -> showPanel("Deposit"));
        withdrawBtn.addActionListener(e -> showPanel("Withdraw"));
        checkBalanceBtn.addActionListener(e -> showPanel("CheckBalance"));
        removeAccountBtn.addActionListener(e -> showPanel("RemoveAccount"));
        quitBtn.addActionListener(e -> System.exit(0));
    }

    // Method to switch input panels
    private void showPanel(String name) {
        CardLayout cl = (CardLayout) (inputPanel.getLayout());
        cl.show(inputPanel, name);
    }

    // Panel for adding an account
    private JPanel createAddAccountPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(50, 30, 100, 25);
        panel.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(160, 30, 200, 25);
        panel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(50, 70, 100, 25);
        panel.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(160, 70, 200, 25);
        panel.add(lastNameField);

        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(50, 110, 100, 25);
        panel.add(balanceLabel);

        JTextField balanceField = new JTextField();
        balanceField.setBounds(160, 110, 200, 25);
        panel.add(balanceField);

        JButton submitBtn = new JButton("Create Account");
        submitBtn.setBounds(160, 160, 150, 30);
        panel.add(submitBtn);

        submitBtn.addActionListener(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String balanceText = balanceField.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || balanceText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double balance;
            try {
                balance = Double.parseDouble(balanceText);
                if (balance < 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid balance amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String accountID = generateAccountID(firstName, lastName);
            if (accounts.containsKey(accountID)) {
                JOptionPane.showMessageDialog(frame, "Account ID already exists. Please use a different name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Account newAccount = new Account(accountID, firstName, lastName, balance);
            accounts.put(accountID, newAccount);
            displayArea.setText("Account created successfully.\nAccount ID: " + accountID);
            
            // Clear input fields
            firstNameField.setText("");
            lastNameField.setText("");
            balanceField.setText("");
        });

        return panel;
    }

    // Panel for depositing money
    private JPanel createDepositPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel accountIDLabel = new JLabel("Account ID:");
        accountIDLabel.setBounds(50, 30, 100, 25);
        panel.add(accountIDLabel);

        accountIDField = new JTextField();
        accountIDField.setBounds(160, 30, 200, 25);
        panel.add(accountIDField);

        JLabel amountLabel = new JLabel("Deposit Amount:");
        amountLabel.setBounds(50, 70, 120, 25);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(180, 70, 180, 25);
        panel.add(amountField);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(160, 120, 150, 30);
        panel.add(depositBtn);

        depositBtn.addActionListener(e -> {
            String accountID = accountIDField.getText().trim();
            String amountText = amountField.getText().trim();

            if (accountID.isEmpty() || amountText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Account account = accounts.get(accountID);
            if (account == null) {
                JOptionPane.showMessageDialog(frame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountText);
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            account.deposit(amount);
            displayArea.setText("Deposited $" + String.format("%.2f", amount) + " to account ID: " + accountID);
            
            // Clear input fields
            accountIDField.setText("");
            amountField.setText("");
        });

        return panel;
    }

    // Panel for withdrawing money
    private JPanel createWithdrawPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel accountIDLabel = new JLabel("Account ID:");
        accountIDLabel.setBounds(50, 30, 100, 25);
        panel.add(accountIDLabel);

        accountIDField = new JTextField();
        accountIDField.setBounds(160, 30, 200, 25);
        panel.add(accountIDField);

        JLabel amountLabel = new JLabel("Withdrawal Amount:");
        amountLabel.setBounds(50, 70, 150, 25);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(200, 70, 160, 25);
        panel.add(amountField);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(160, 120, 150, 30);
        panel.add(withdrawBtn);

        withdrawBtn.addActionListener(e -> {
            String accountID = accountIDField.getText().trim();
            String amountText = amountField.getText().trim();

            if (accountID.isEmpty() || amountText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Account account = accounts.get(accountID);
            if (account == null) {
                JOptionPane.showMessageDialog(frame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountText);
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid withdrawal amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (account.withdraw(amount)) {
                displayArea.setText("Withdrew $" + String.format("%.2f", amount) + " from account ID: " + accountID);
            } else {
                displayArea.setText("Insufficient funds in account ID: " + accountID);
            }
            
            // Clear input fields
            accountIDField.setText("");
            amountField.setText("");
        });

        return panel;
    }

    // Panel for checking balance
    private JPanel createCheckBalancePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel accountIDLabel = new JLabel("Account ID:");
        accountIDLabel.setBounds(50, 30, 100, 25);
        panel.add(accountIDLabel);

        accountIDField = new JTextField();
        accountIDField.setBounds(160, 30, 200, 25);
        panel.add(accountIDField);

        JButton checkBtn = new JButton("Check Balance");
        checkBtn.setBounds(160, 70, 150, 30);
        panel.add(checkBtn);

        checkBtn.addActionListener(e -> {
            String accountID = accountIDField.getText().trim();
            if (accountID.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an account ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Account account = accounts.get(accountID);
            if (account == null) {
                JOptionPane.showMessageDialog(frame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            displayArea.setText(account.getAccountInfo());
            
            // Clear input field
            accountIDField.setText("");
        });

        return panel;
    }

    // Panel for removing an account
    private JPanel createRemoveAccountPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel accountIDLabel = new JLabel("Account ID:");
        accountIDLabel.setBounds(50, 30, 100, 25);
        panel.add(accountIDLabel);

        accountIDField = new JTextField();
        accountIDField.setBounds(160, 30, 200, 25);
        panel.add(accountIDField);

        JButton removeBtn = new JButton("Remove Account");
        removeBtn.setBounds(160, 70, 150, 30);
        panel.add(removeBtn);

        removeBtn.addActionListener(e -> {
            String accountID = accountIDField.getText().trim();
            if (accountID.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an account ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Account account = accounts.remove(accountID);
            if (account == null) {
                JOptionPane.showMessageDialog(frame, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            displayArea.setText("Account ID " + accountID + " removed successfully.");
            
            // Clear input field
            accountIDField.setText("");
        });

        return panel;
    }

    // Method to generate a unique account ID
    private String generateAccountID(String firstName, String lastName) {
        return firstName.substring(0, 1).toUpperCase() + lastName.toUpperCase() + (accounts.size() + 1);
    }
}
