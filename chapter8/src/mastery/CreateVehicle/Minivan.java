package mastery.CreateVehicle;

public class Minivan extends Vehicle {
    private boolean hasRearEntertainmentSystem;  // Additional member for minivan

    // Constructor
    public Minivan(double fuelEconomyCity, double fuelEconomyHwy, int seatingCapacity, double cargoVolume, boolean hasRearEntertainmentSystem) {
        super(fuelEconomyCity, fuelEconomyHwy, seatingCapacity, cargoVolume);
        this.hasRearEntertainmentSystem = hasRearEntertainmentSystem;
    }

    // Implement abstract method
    @Override
    public void displayVehicleType() {
        System.out.println("This is a Minivan.");
    }

    // Additional method specific to Minivan
    public boolean hasRearEntertainmentSystem() {
        return hasRearEntertainmentSystem;
    }

    // toString method to display minivan-specific details
    @Override
    public String toString() {
        return super.toString() + ", Rear Entertainment System: " + (hasRearEntertainmentSystem ? "Yes" : "No");
    }
}
 