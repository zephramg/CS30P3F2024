package skillbuilders.Rectangle;

import java.util.Arrays;

public class rect {

    public static void main(String[] args) {
        // Test default constructor
        Rectangle rect1 = new Rectangle();
        System.out.println("Default Rectangle: " + rect1);
        System.out.println("Area: " + rect1.getArea());
        System.out.println("Perimeter: " + rect1.getPerimeter());

        // Test parameterized constructors
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        Rectangle rect3 = new Rectangle(5.0, 3.0);
        Rectangle rect4 = new Rectangle(5.0, 5.0);

        // Display rectangles
        System.out.println("\nRectangle 2: " + rect2);
        System.out.println("Rectangle 3: " + rect3);
        System.out.println("Rectangle 4: " + rect4);

        // Test equals method
        System.out.println("\nAre Rectangle 2 and Rectangle 3 equal? " + rect2.equals(rect3));

        // Test static method to display area formula
        Rectangle.displayAreaFormula();

        // Test Comparable interface by sorting an array of rectangles
        Rectangle[] rectangles = {rect2, rect3, rect4};
        Arrays.sort(rectangles);
        System.out.println("\nRectangles sorted by area:");
        for (Rectangle rect : rectangles) {
            System.out.println(rect + " with area: " + rect.getArea());
        }

        // Test compareToArea method from ComparableArea interface
        System.out.println("\nComparing Rectangle 2 and Rectangle 4 by area:");
        int areaComparison = rect2.compareToArea(rect4);
        if (areaComparison < 0) {
            System.out.println("Rectangle 2 has a smaller area than Rectangle 4.");
        } else if (areaComparison > 0) {
            System.out.println("Rectangle 2 has a larger area than Rectangle 4.");
        } else {
            System.out.println("Rectangle 2 and Rectangle 4 have the same area.");
        }
    }
}
