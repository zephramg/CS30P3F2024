/*

Program: Vehicle.java          Last Date of this Revision: October 29, 2024

Purpose: Abstract superclass representing a general vehicle. Includes common properties such as 
fuel economy (city and highway), seating capacity, and cargo volume, and provides an abstract 
method displayVehicleType() to be implemented by subclasses.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.CreateVehicle;

public abstract class Vehicle {
    private double fuelEconomyCity; // Fuel economy in city (mpg)
    private double fuelEconomyHwy;  // Fuel economy on highway (mpg)
    private int seatingCapacity;    // Number of seats
    private double cargoVolume;     // Cargo volume (cubic feet)

    // Constructor
    public Vehicle(double fuelEconomyCity, double fuelEconomyHwy, int seatingCapacity, double cargoVolume) {
        this.fuelEconomyCity = fuelEconomyCity;
        this.fuelEconomyHwy = fuelEconomyHwy;
        this.seatingCapacity = seatingCapacity;
        this.cargoVolume = cargoVolume;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayVehicleType();

    // Getter methods
    public double getFuelEconomyCity() {
        return fuelEconomyCity;
    }

    public double getFuelEconomyHwy() {
        return fuelEconomyHwy;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    } 

    public double getCargoVolume() {
        return cargoVolume;
    }
 
    // toString method to display common details
    @Override
    public String toString() {
        return "Fuel Economy (City): " + fuelEconomyCity + " mpg, " +
               "Fuel Economy (Highway): " + fuelEconomyHwy + " mpg, " +
               "Seating Capacity: " + seatingCapacity + ", " +
               "Cargo Volume: " + cargoVolume + " cubic feet";
    }
}
