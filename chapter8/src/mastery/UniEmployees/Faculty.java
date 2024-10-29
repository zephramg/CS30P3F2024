/*

Program: Faculty.java          Last Date of this Revision: October 29, 2024

Purpose: Subclass of UEmployee, representing faculty members with 
an additional department attribute. Class is instantiated in 
the client application (University.java).

Class includes a constructor to initialize faculty-specific attributes 
and an overridden toString() method to display the department alongside 
general employee details.


Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/


package mastery.UniEmployees;

public class Faculty extends UEmployee {
    private String department;

    // Constructor
    public Faculty(String name, double salary, String department) {
        super(name, salary); // Calls the constructor of UEmployee
        this.department = department;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Override toString to include department info
    @Override
    public String toString() {
        return super.toString() + ", Department: " + department;
    }
}

