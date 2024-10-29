/*

Program: University.java          Last Date of this Revision: October 29, 2024

Purpose: Client application to demonstrate the functionality of 
the UEmployee, Staff, and Faculty classes. It creates instances 
of Faculty and Staff, displaying their details including name, 
salary, job title, and department.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/
 
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


/* Screen Dump

Employee Name: Dr. Gilson, Salary: $85000.0, Department: Computer Science
Employee Name: John Doe, Salary: $45000.0, Job Title: Administrative Assistant
 
 */