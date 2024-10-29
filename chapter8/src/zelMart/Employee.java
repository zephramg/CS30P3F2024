package zelMart;
 
public abstract class Employee 
{ // NOTE: abstract class must have at least one abstract method

	private String firstName, lastName;
	
	// Constructor method
	public Employee(String fN, String lN) 
	{
		firstName = fN;
		lastName = lN;
	}
	
	public String toString() 
	{
		return(firstName + " " + lastName);
	}
	
	abstract double pay(double period);
	
} 
