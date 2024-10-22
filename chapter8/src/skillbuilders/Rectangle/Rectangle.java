package skillbuilders.Rectangle;

public class Rectangle implements Comparable<Rectangle>, ComparableArea {
    private double length;
    private double width;

    // Default constructor
    public Rectangle() {
        length = 1;
        width = 1;
    }

    // Parameterized constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Setters and getters
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Calculate area
    public double getArea() {
        return length * width;
    }

    // Calculate perimeter
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Static method to display the area formula
    public static void displayAreaFormula() {
        System.out.println("The formula for the area of a rectangle is: Area = length * width");
    }

    // Override equals() to check if two rectangles have the same length and width
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        return this.length == other.length && this.width == other.width;
    }

    // Override toString() for meaningful string representation
    @Override
    public String toString() {
        return "Rectangle [Length: " + length + ", Width: " + width + "]";
    }

    // Implement compareTo() method from Comparable interface to compare areas
    @Override
    public int compareTo(Rectangle other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();
        return Double.compare(thisArea, otherArea);
    }

    // Implement compareToArea() method from ComparableArea interface
    @Override
    public int compareToArea(Rectangle other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();
        if (thisArea < otherArea) {
            return -1;
        } else if (thisArea > otherArea) {
            return 1;
        } else {
            return 0;
        }
    }
}
