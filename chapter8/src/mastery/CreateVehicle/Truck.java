/*

Program: Truck.java          Last Date of this Revision: October 29, 2024

Purpose: Subclass of Vehicle representing a truck, with additional property for towing capacity. 
Implements the abstract method displayVehicleType() and provides a toString() method to display truck-specific details.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.CreateVehicle;

public class Truck extends Vehicle {
    private double towingCapacity;  // Additional member for truck

    // Constructor
    public Truck(double fuelEconomyCity, double fuelEconomyHwy, int seatingCapacity, double cargoVolume, double towingCapacity) {
        super(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume);
        this.towingCapacity = towingCapacity;
    }

    // Implement abstract method
    @Override
    public void displayVehicleType() {
        System.out.println("This is a Truck.");
    }

    // Additional method specific to Truck
    public double getTowingCapacity() {
        return towingCapacity;
    }

    // toString method to display truck-specific details
    @Override
    public String toString() {
        return super.toString() + ", Towing Capacity: " + towingCapacity + " lbs";
    }
}
