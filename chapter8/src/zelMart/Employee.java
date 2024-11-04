package zelMart;
 
public abstract class Employee 
{
	private String firstName, lastName;
	
	//Constructor method for Employee 
	public Employee(String fN, String lN)
	{
		firstName = fN;
		lastName = lN;
	}
	
	public String toString()
	{
		return(firstName + " "+ lastName);
	}
	
	abstract double pay(double period);
	
	
}