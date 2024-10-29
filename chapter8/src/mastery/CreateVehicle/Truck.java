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
