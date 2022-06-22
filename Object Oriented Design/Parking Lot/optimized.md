
``` java
// 1.
enum VehicleType {
    SMALL,
    MEDIUM,
    LARGE;
}

abstract class Vehicle {
    protected String name;
    protected String plateNum; // protected
    private final VehicleType type; // final
    
    public Vehicle(VehicleType type) {
        this.type = type;
    }
}

class Car extends Vehicle {
    public Car() {
        super(VehicleType.MEDIUM);
    }
}

class Bus extends Vehicle {
    public Bus() {
        super(VehicleType.Large);
    }
}


class Motobike extends Vehicle {
    public Motobike() {
        super(VehicleType.SMALL);
    }
}

```

2. Functions: levels, costs
/***from small to large*****/
public enum ParkingSpotType {
    SMALL,
    MEDIUM,
    LARGE,
    HANDICAP;
}

class ParkingSpot { // show only once is enough
    private final ParkingSpotType type;
    private boolean isAvailable;
    private Vehicle vehicle;
    private int spotNo;
    private Level level;
    
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }
}

class Level {
    private List<ParkingSpot> spots;
    private int availableCount;
    private boolean available;
    
    public Level(int availableCount) {
        this.available = NUM_SPOTS;
    }
}

class Constants {
    public static final int NUM_SPOTS = 100;    
    public static final int NUM_SMALL = 100;    
    public static final int NUM_MEDIUM = 100;    
    public static final int NUM_LARGET = 100;



}

class ParkingLot {
    private String name;
    private boolean available;
    private List<Level> levels;
    
}

3. Method adding
```java
// 1.
enum VehicleType {
    SMALL,
    MEDIUM,
    LARGE;
}

abstract class Vehicle {
    protected String name;
    protected String plateNum; // protected
    private final VehicleType type; // final
    
    public Vehicle(VehicleType type) {
        this.type = type;
    }
}

class Car extends Vehicle {
    public Car() {
        super(VehicleType.MEDIUM);
    }
}

class Bus extends Vehicle {
    public Bus() {
        super(VehicleType.Large);
    }
}


class Motobike extends Vehicle {
    public Motobike() {
        super(VehicleType.SMALL);
    }
}
/***from small to large*****/
public enum ParkingSpotType {
    SMALL,
    MEDIUM,
    LARGE,
    HANDICAP;
}

class ParkingSpot { // show only once is enough
    private final ParkingSpotType type;
    private boolean available;
    private Vehicle vehicle;
    private int spotNo;
    private Level level;
    
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }
    
    public boolean isAvailable() {
        return available();
    }
    
    public boolean canVehicleFit() {
        return true;
    }
    
    // public void park(Vehicle v) {
    //     vehicle = v;
    // }
    public void takeSpot() {
        available = false;
    }

    public void leaveSpot() {
        available = false;
    }
}

class Level {
    private List<ParkingSpot> spots;
    private int availableCount;
    private boolean available;
    
    public Level(int availableCount) {
        this.available = NUM_SPOTS;
    }
    public boolean isAvailable() {
        return available();
    }
    public int getAvailableCount() {
        return availableCount;
    }
    public void updateAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
}

class Constants {
    public static final int NUM_SPOTS = 100;    
    public static final int NUM_SMALL = 100;    
    public static final int NUM_MEDIUM = 100;    
    public static final int NUM_LARGET = 100;
}

class ParkingLot {
    private String name;
    private boolean available;
    private List<Level> levels;    
    
    public void enter(Vehicle vehicle) {}
    
    public boolean isAvailable() {
        return available;
    }
    
    public Level findLevelAvailable() {
        return null;
    }
    
    public int getAvailableCount() {
        return 1;
    }
    
    public Ticket exit(Vehicle vehicle) {
        return null;
    }
    
    public boolean canVehicleFit(Vehicle vehicle) {
        
    }
    
    public float calculate(Ticket ticket) {
        return 0;
    }
}

class Ticket {
    private String id;
    private float amount;
    private Vehicle vehicle;
    private Date enterTime;    
    private Date exitTime;
    
    private int status; // paid, unpaid, enum better
    private int paymentMethod; // Credit, Debit, Cash
    
}

// Step0, class, constructor and variable
// add methods according to use case
// sequence: 1. enter -> 2. find -> 3. update -> 4. exit -> 5. calculate
// small->large, large->small , easy 2 implement


```