package java17;

public sealed class Vehicle permits Car, Motorcycle {
        
    private final String brand;
            
    public Vehicle(String brand) {
        this.brand = brand;
    }
            
    public String getBrand() {
        return brand;
    }
}

        

final class Car extends Vehicle {
        
    private final int numberOfDoors;
            
    public Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = numberOfDoors;
    }
            
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

        

final class Motorcycle extends Vehicle {
        
    private final boolean hasFairing;
            
    public Motorcycle(String brand, boolean hasFairing) {
        super(brand);
        this.hasFairing = hasFairing;
    }
            
    public boolean hasFairing() {
        return hasFairing;
    }
}

        