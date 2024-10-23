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
