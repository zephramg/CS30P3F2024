package mastery.UniEmployees;

public class University {
    public static void main(String[] args) {
       
    	// Create a faculty object
    	Faculty faculty = new Faculty("Dr. Gilson", 85000, "Computer Science");
    	System.out.println(faculty);
    	
    	// Create and print a staff object
    	Staff staff = new Staff("John Doe", 45000, "Administrative Assistant");
    	System.out.print(staff);
    
    }
}