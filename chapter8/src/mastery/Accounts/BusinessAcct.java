package mastery.Accounts;

public class BusinessAcct extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double PENALTY = 10.0;

    public BusinessAcct(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
        super(bal, fName, lName, street, city, province, postalCode);
    }

    @Override
    public void withdrawal(double amt) {
        super.withdrawal(amt);
        if (getBalance() < MIN_BALANCE) {
            super.withdrawal(PENALTY);
            System.out.println("Balance below minimum. Penalty of $" + PENALTY + " applied.");
        }
    }
}