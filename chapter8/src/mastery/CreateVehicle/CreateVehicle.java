/*

Program: CreateVehicle.java          Last Date of this Revision: October 29, 2024

Purpose: Client application to demonstrate the functionality of Vehicle and its subclasses 
(Car, Truck, and Minivan). Instantiates objects of each subclass, displaying their properties 
and vehicle type, as well as specific features like towing capacity and rear entertainment system availability.

Author: Zephram Gilson
School: CHHS
Course: Computer Science 30

*/

package mastery.CreateVehicle;

public class CreateVehicle {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car(25.0, 35.0, 5, 15.0, "Sedan");
        car.displayVehicleType();
        System.out.println(car);

        // Create a Truck object
        Truck truck = new Truck(15.0, 20.0, 3, 30.0, 10000);
        truck.displayVehicleType();
        System.out.println(truck);

        // Create a Minivan object
        Minivan minivan = new Minivan(20.0, 28.0, 7, 40.0, true);
        minivan.displayVehicleType();
        System.out.println(minivan);

        // Display whether the minivan has a rear entertainment system
        if (minivan.hasRearEntertainmentSystem()) {
            System.out.println("The minivan is equipped with a rear entertainment system.");
        } else {
            System.out.println("The minivan does not have a rear entertainment system.");
        }
    }
}

/* Screen Dump

This is a Car.
Fuel Economy (City): 25.0 mpg, Fuel Economy (Highway): 35.0 mpg, Seating Capacity: 5, Cargo Volume: 15.0 cubic feet, Body Style: Sedan
This is a Truck.
Fuel Economy (City): 15.0 mpg, Fuel Economy (Highway): 20.0 mpg, Seating Capacity: 3, Cargo Volume: 30.0 cubic feet, Towing Capacity: 10000.0 lbs
This is a Minivan.
Fuel Economy (City): 20.0 mpg, Fuel Economy (Highway): 28.0 mpg, Seating Capacity: 7, Cargo Volume: 40.0 cubic feet, Rear Entertainment System: Yes
The minivan is equipped with a rear entertainment system.

*/