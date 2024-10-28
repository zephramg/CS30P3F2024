package mastery.Accounts;

public class AccountsRun {
    public static void main(String[] args) {
        // Test Personal Account with minimum balance penalty
        PersonalAcct personalAccount = new PersonalAcct(150.0, "John", "Doe", "123 Main St", "Springfield", "IL", "62704");
        System.out.println(personalAccount);
        personalAccount.withdrawal(60); // Should apply penalty
        System.out.println(personalAccount);

        // Test Business Account with minimum balance penalty
        BusinessAcct businessAccount = new BusinessAcct(600.0, "Jane", "Smith", "456 Elm St", "Shelbyville", "CA", "62565");
        System.out.println(businessAccount);
        businessAccount.withdrawal(200); // Should apply penalty
        System.out.println(businessAccount);
    }
}
