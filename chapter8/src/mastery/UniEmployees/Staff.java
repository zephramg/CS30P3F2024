/*

Program: Staff.java          Last Date of this Revision: October 29, 2024

Purpose: Subclass of UEmployee, representing university staff with 
an additional job title attribute. Class is instantiated in 
the client application (University.java).

Class includes a constructor to initialize staff attributes and 
an overridden toString() method to display the job title along with 
other employee details.


Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/


package mastery.UniEmployees;

public class Staff extends UEmployee {
    private String jobTitle;

    // Constructor
    public Staff(String name, double salary, String jobTitle) {
        super(name, salary); // Calls the constructor of UEmployee
        this.jobTitle = jobTitle;
    }

    // Getter for job title
    public String getJobTitle() {
        return jobTitle;
    }

    // Override toString to include job title info
    @Override
    public String toString() {
        return super.toString() + ", Job Title: " + jobTitle;
    }
}
