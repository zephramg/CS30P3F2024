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
