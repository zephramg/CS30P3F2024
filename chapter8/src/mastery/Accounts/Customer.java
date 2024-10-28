package mastery.Accounts;

public class Customer {
    private String firstName, lastName;
    private String street, city, province, postalCode;

    public Customer(String fName, String lName, String street, String city, String province, String postalCode) {
        firstName = fName;
        lastName = lName;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public void changeCity(String city) {
        this.city = city;
    }

    public void changeStreet(String street) {
        this.street = street;
    }

    public void changeProvince(String province) {
        this.province = province;
    }

    public void changePostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" + street + ", " + city + ", " + province + " " + postalCode + "\n";
    }
}
