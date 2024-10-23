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

