package mastery;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Account getAccount() {
        return account;
    }
}
