package mastery.Accounts;

public class PersonalAcct extends Account {
    private static final double MIN_BALANCE = 100.0;
    private static final double PENALTY = 2.0;

    public PersonalAcct(double bal, String fName, String lName, String street, String city, String province, String postalCode) {
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


