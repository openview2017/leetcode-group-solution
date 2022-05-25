# Step 0
## Specify classes

```java
// "static void main" must be defined in a public class.
public class Main { // testing
    public static void main(String[] args) {
        Vehicle car_a = new Car();
        System.out.println(car_a.getSize().getSize());
        Vehicle truck_b = new Truck();
        System.out.println(truck_b.getSize().getSize());
    }
}

class Level {
    private final List<ParkingSpot> spots;
    private int NUMOFSPOTS;
    Level(int numOfSpots) {
        this.NUMOFSPOTS = numOfSpots;
        this.spots = new ArrayList<>();
    };
    boolean hasSpot(Vehicle v) { return false; }; // iterate spots find fit
    boolean park(Vehicle v) { return false; };
    boolean leave(Vehicle v) { return false; };
}

class ParkingLot {
    private final Level[] levels;
    private int NUMOFLEVEL;
    ParkingLot(int numOfLevel, int numOfSpotsPerLevel) {
        this.NUMOFLEVEL = numOfLevel;
        this.levels = new Level[numOfLevel];
        for (int i = 0; i < numOfLevel; i++) {
            levels[i] = new Level(numOfSpotsPerLevel);
        }
    }
    boolean hasSpot(Vehicle v) { return false; };    
    boolean park(Vehicle v) { return false; };
    boolean leave(Vehicle v) { return false; };
}

class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    
    ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    
    boolean fit(Vehicle v) { return false; }
    void park(Vehicle v) {}
    void lead(Vehicle v) {}
    Vehicle getVehicle() {return currentVehicle; }
}


abstract class Vehicle {
    public abstract VehicleSize getSize();
}

class Car extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
} 

class Truck extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.Large;
    }
} 

enum VehicleSize {
    Compact(1),
    Large(2);
    private final int size;
    VehicleSize(int size) {
        this.size = size;
    }
    public int getSize(){
        return size;
    }
}

```