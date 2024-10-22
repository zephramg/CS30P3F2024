package skillbuilders;

/* Modified Puck (P2) Class */

/**
 * Puck class that inherits from Disk and implements Comparable.
 */
public class Puck extends Disk implements Comparable<Puck> {
    private double weight;
    private boolean standard;
    private boolean youth;

    /**
     * Constructor
     * pre: none
     * post: A Puck object has been created with the specified weight.
     */
    public Puck(double weight) {
        // Official hockey pucks are 1 inch thick and have a 3-inch diameter
        super(1.5, 1.0); 
        this.weight = weight;
        if (weight >= 5.0 && weight <= 5.5) {
            standard = true;
            youth = false;
        } else if (weight >= 4.0 && weight <= 4.5) {
            youth = true;
            standard = false;
        } else {
            standard = false;
            youth = false;
        }
    }

    /**
     * Returns the weight of the puck.
     * pre: none
     * post: The weight of the puck has been returned.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the division of the puck (standard or youth).
     * pre: none
     * post: A string representing the division has been returned.
     */
    public String getDivision() {
        if (standard) {
            return "Standard";
        } else if (youth) {
            return "Youth";
        } else {
            return "Unknown";
        }
    }

    /**
     * Determines if the object is equal to another Puck object.
     * pre: p is a Puck object.
     * post: true has been returned if objects have the same weight, radii, and thickness.
     */
    @Override
    public boolean equals(Object p) {
        Puck testObj = (Puck)p;

        return (super.equals(testObj) && this.weight == testObj.getWeight());
    }

    /**
     * Compares two Puck objects based on their weight.
     * pre: none
     * post: Comparison based on weight has been returned.
     */
    @Override
    public int compareTo(Puck otherPuck) {
        if (this.weight == otherPuck.getWeight()) {
            return 0;
        } else if (this.weight < otherPuck.getWeight()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Returns a String that represents the Puck object.
     * pre: none
     * post: A string representing the Puck object has been returned.
     */
    @Override
    public String toString() {
        return "Puck [Weight: " + weight + ", Division: " + getDivision() + "]";
    }
}
