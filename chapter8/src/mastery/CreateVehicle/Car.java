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
