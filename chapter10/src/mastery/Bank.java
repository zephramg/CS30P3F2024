package mastery;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers;

    public Bank() {
        customers = new HashMap<>();
    }

    public boolean addAccount(String accountNumber, String firstName, String lastName, double initialBalance) {
        if (customers.containsKey(accountNumber)) {
            return false; // Account already exists
        }
        Account newAccount = new Account(accountNumber, initialBalance);
        Customer newCustomer = new Customer(firstName, lastName, newAccount);
        customers.put(accountNumber, newCustomer);
        return true;
    }

    public Customer getCustomer(String accountNumber) {
        return customers.get(accountNumber);
    }

    public boolean removeAccount(String accountNumber) {
        return customers.remove(accountNumber) != null;
    }

    public boolean depositToAccount(String accountNumber, double amount) {
        Customer customer = customers.get(accountNumber);
        if (customer != null) {
            customer.getAccount().deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdrawFromAccount(String accountNumber, double amount) {
        Customer customer = customers.get(accountNumber);
        if (customer != null) {
            return customer.getAccount().withdraw(amount);
        }
        return false;
    }

    public double checkBalance(String accountNumber) {
        Customer customer = customers.get(accountNumber);
        if (customer != null) {
            return customer.getAccount().getBalance();
        }
        return -1; // Account not found
    }
}