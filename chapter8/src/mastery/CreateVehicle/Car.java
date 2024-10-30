/*

Program: Car.java          Last Date of this Revision: October 29, 2024

Purpose: Subclass of Vehicle representing a car with a specific body style. Implements the 
abstract method displayVehicleType() and provides a detailed toString() for car-specific information.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.CreateVehicle;

public class Car extends Vehicle {
    private String bodyStyle;  // Additional member for a car

    // Constructor
    public Car(double fuelEconomyCity, double fuelEconomyHwy, int seatingCapacity, double cargoVolume, String bodyStyle) {
        super(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume);
        this.bodyStyle = bodyStyle;
    }

    // Implement abstract method
    @Override
    public void displayVehicleType() {
        System.out.println("This is a Car.");
    }

    // toString method to display car-specific details
    @Override
    public String toString() {
        return super.toString() + ", Body Style: " + bodyStyle;
    }
}
