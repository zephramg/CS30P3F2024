
package mastery;


public class Customer 
{
private String firstName, lastName;
		
	
	/**
	 * constructor
	 * pre: none
	 * post: A Customer object has been created. 
	 * Customer data has been initialized with parameters.
	 */
	public Customer(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	

	/** 
	 * Returns a String that represents the Customer object.
	 * pre: none
	 * post: A string representing the Customer object has 
	 * been returned.
	 */
	public String toString() {
		String custString;

		custString = " " + firstName + " " + lastName + " ";
	 	return(custString);
	}

	
	
}
