package skillbuilders;

import java.io.Serializable;

public class StuName implements Serializable {
    private static final long serialVersionUID = 1L;  // Serial version ID for version control

    private String firstName;
    private String lastName;

    // Constructor
    public StuName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters for firstName and lastName
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Override toString() to display the full name
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
