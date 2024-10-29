/**
 * Customer class.
 */

package mastery.Accounts;

public class Customer {
	private String firstName, lastName;

	// String variables to store customer's address details
	private String street, city, province, postalCode;	

	/**
	 * Constructor
	 * pre: none
	 * post: A Customer object has been created. 
	 * Customer data has been initialized with parameters.
	 */
	public Customer(String fName, String lName, String street, String city, String province, String postalCode) {
		firstName = fName;
		lastName = lName;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	/**
	 * Updates the customer's city.
	 * pre: none
	 * post: The customer's city has been updated.
	 */
	public void changeCity(String city) {
		this.city = city;
	}

	/**
	 * Updates the customer's street.
	 * pre: none
	 * post: The customer's street has been updated.
	 */
	public void changeStreet(String street) {
		this.street = street;
	}

	/**
	 * Updates the customer's province.
	 * pre: none
	 * post: The customer's province has been updated.
	 */
	public void changeProvince(String province) {
		this.province = province;
	}

	/**
	 * Updates the customer's postal code.
	 * pre: none
	 * post: The customer's postal code has been updated.
	 */
	public void changePostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/** 
	 * Returns a String that represents the Customer object.
	 * pre: none
	 * post: A string representing the Customer object has been returned.
	 */
	@Override
	public String toString() {
		// Updated to include full address details
		return firstName + " " + lastName + "\n" + street + ", " + city + ", " + province + " " + postalCode + "\n";
	}
}
