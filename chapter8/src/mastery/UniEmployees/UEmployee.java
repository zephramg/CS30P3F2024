/*

Program: UEmployee.java          Last Date of this Revision: October 29, 2024

Purpose: Base class for university employees, representing a general 
university employee with attributes such as name and salary. 

Class is inherited in the client application University.java.


Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.UniEmployees;

public class UEmployee {
    private String name;
    private double salary;

    // Constructor
    public UEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // toString method for easy display of employee information
    @Override
    public String toString() {
        return "Employee Name: " + name + ", Salary: $" + salary;
    }
}
