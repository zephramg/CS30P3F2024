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
    }
}
