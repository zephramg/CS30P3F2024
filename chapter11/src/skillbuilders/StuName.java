package skillbuilders;

import java.io.Serializable;

public class StuName implements Serializable {
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
    public String toString() {
        return firstName + " " + lastName;
    }
}
