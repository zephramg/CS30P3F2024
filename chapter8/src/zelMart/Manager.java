package zelMart;

public class Manager extends Employee {

	private double yearlySalary; 
	
	// Consttructor method
	public Manager(String fN, String lN, double s) {
		super(fN, lN); // NOTE: super class is under extends, Employee in this case.
		yearlySalary = s;
	}
	
	public double getyearlySalary() {
		return(yearlySalary);
	}
	
	// Return the manager pay for a specified person
	public double pay(double weeks) {
		double payEarned;
		
		payEarned = yearlySalary / 52 * weeks;
		
		return payEarned;
	}
	
	// Return the employee name, title, and salary.
	public String toString() {
		return(super.toString() 
				+ ", Manager" 
				+ "Salary: " 
				+ yearlySalary );
	}
}
