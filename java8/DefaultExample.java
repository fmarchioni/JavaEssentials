package java8;

interface Vehicle {
    void start();
            
    default void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}
        
class Car implements Vehicle {
    public void start() {
        System.out.println("Car started.");
    }
}
        
public class DefaultExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();

        // default method from the interface
        car.displayInfo();    

    }
}

        