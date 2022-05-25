

## System design Parking Lot
[Exponent](https://www.youtube.com/watch?v=NtMvNh0WFVM)

## Complex Parking Lot case:
[Grokking OOD](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/gxM3gRxmr8Z)

## Simplified Parking Lot:
1. two kinds of vehicle: car(largeSize) and truck(smallSize)
2. half parking spot is small, half is large
3. can park larger or equal parking spot
4. parking lot has level



# Step 0. Specify classes
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

# Step 1: finish all functions
``` java
/*
1. two kinds of vehicle: car(largeSize) and truck(smallSize)
2. half parking spot is small, half is large
3. can park larger or equal parking spot
4. parking lot has level

*/ 
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
        List<ParkingSpot> list = new ArrayList<>();
        int i = 0;
        for (i = 0; i < NUMOFSPOTS / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < NUMOFSPOTS; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    };
    boolean hasSpot(Vehicle v) { 
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                return true;
            }
        }
        return false;
    }; // iterate spots find fit
    
    boolean park(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                spot.park(v);
                return true;
            }
        }
        return false;
    };
    boolean leave(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == v) {
                spot.leave();
                return true;
            }
        }
        return false;    
    };
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
    boolean hasSpot(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.hasSpot(v)) {
                return true;
            }
        }
        return false;
    };    
    boolean park(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.hasSpot(v)) {
                lvl.park(v);
                return true;
            }
        }
        return false;    
    };
    boolean leave(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.leave(v)) {
                return true;
            }
        }
        return false;      
    };
}

class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    
    ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    
    boolean fit(Vehicle v) { 
        return currentVehicle == null && v.getSize().getSize() <= size.getSize();
    }
    void park(Vehicle v) {
        this.currentVehicle = v;
    }
    void leave() {
         this.currentVehicle = null;
    }
    Vehicle getVehicle() {
        return currentVehicle; 
    }
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


# Step 3: Complete test case


``` java

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(4, 5);
        List<Vehicle> list = new ArrayList<>(); // shuffle test is more meaningful, exception handle (corner cases)!!!,
        for (int i = 0; i < 30; i++) {
            final Vehicle v = (i%2==0) ? new Car() : new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpot(v);        
          
                System.out.println("i=" + i + ":" + v.getSize().getSize() + ", " + hasSpot + " , canPark?:" + lot.park(v));
                // assert(hasSpot);
                // assert(lot.park(v));        
            
        }
        System.out.println();
        int j = 0;
        /*
        to-do: shuffle the list
        */ 
        
        for (Vehicle v : list) {
            System.out.println(lot.leave(v) + "," + (j++));
        }        
    }
 
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
    
    boolean hasSpot(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.hasSpot(v)) {
                return true;
            }
        }
        return false;
    };
    
    boolean park(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.hasSpot(v)) {
                lvl.park(v);
                return true;
            }
        }
        return false;    
    };
    
    boolean leave(Vehicle v) { 
        for (Level lvl : levels) {
            if (lvl.leave(v)) {
                return true;
            }
        }
        return false;      
    };
}

class Level { 
    private final List<ParkingSpot> spots;
    private int NUMOFSPOTS;
    Level(int numOfSpots) {
        this.NUMOFSPOTS = numOfSpots;
        List<ParkingSpot> list = new ArrayList<>();
        int i = 0;
        for (i = 0; i < NUMOFSPOTS / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < NUMOFSPOTS; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    };
    boolean hasSpot(Vehicle v) { 
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                return true;
            }
        }
        return false;
    }; // iterate spots find fit
    
    boolean park(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(v)) {
                spot.park(v);
                return true;
            }
        }
        return false;
    };
    // follow up: has spot
    boolean leave(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == v) { //! improve with vehicle_id, write equals method in Vehicle
                spot.leave();
                return true;
            }
        }
        return false;    
    };
}

class ParkingSpot { 
     private final VehicleSize size;
     private Vehicle currentVehicle;
    
    ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    
    boolean fit(Vehicle v) { 
        return currentVehicle == null && v.getSize().getSize() <= size.getSize();
    }
    
    void park(Vehicle v) {
        this.currentVehicle = v;
    }
    
    void leave() {
         this.currentVehicle = null;
    }  
    
    Vehicle getVehicle() {
        return currentVehicle; 
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
```