

## Step 0. Define class
```java
class Code {
    private String id;
    private String code;
    private Locker locker;
    private Customer customer;
    private Date startDate;
    private Date endDate;
    
}

class Customer {
    private String id;
    private List<Code> codes;
}

class abstract Locker {
    private String id;
    protected Package aPackage;
    protected boolean available;
    private final Size size;
    
    public Locker(Size size) {
        this.size = size;
    }
    
    public boolean isAvailable() {
        return true;
    }
}

class LargeLocker extends Locker {
    public LargeLocker {
        super(Size.LARGE);
    }
}

class MediumLocker extends Locker {
    public LargeLocker {
        super(Size.MEDIUM);
    }
}

class SmallLocker extends Locker {
    public LargeLocker {
        super(Size.SMALL);
    }
}

class LockerSystem {
    private Locker[] lockers;
    private List<Code> codes;
    
    private Date openTime;    
    private Date closeTime;
}

class Package {
    private String id; //???
    private final int length;
    private final int width;
    private final int height;
    
    public Package(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public int getSize() {
        return 0; // confirm with interviewer
    }
}

enum Size {
    SMALL(5), 
    MEDIUM(10),
    LARGE(20);
        
    private final int size;
    
    Size(int size) {
        this.size = size;
    }
}

```


## Step 1. Finish use case
```java
/*
1. in: package into lock
2. out: customer take out package
3. system put: generate code, give it to customer

flow chart
a. store package: postman
b. find optimal
c. send code
d. pick up
e. check code

*/


import java.util.*;
import java.text.*;

class Code {
    private String id;
    private String code;
    private Locker locker;
    private Customer customer;
    private Date startDate;
    private Date endDate;
    
}

class Customer {
    private String id;
    private List<Code> codes;
}

class abstract Locker {
    private String id;
    protected Package aPackage;
    protected boolean available;
    private final Size size;
    
    public Locker(Size size) {
        this.size = size;
    }
    
    public boolean isAvailable() {
        return true;
    }
}

class LargeLocker extends Locker {
    public LargeLocker {
        super(Size.LARGE);
    }
}

class MediumLocker extends Locker {
    public LargeLocker {
        super(Size.MEDIUM);
    }
}

class SmallLocker extends Locker {
    public LargeLocker {
        super(Size.SMALL);
    }
}

class LockerSystem {
    //private Locker[] lockers;
    private Locker[] smallLockers;
    private Locker[] mediumLockers;
    private Locker[] largeLockers;
    private List<Code> codes;
    
    private Date openTime;    
    private Date closeTime;
    
    public LockerSystem() {
        this.smallLockers = new Locker[Constants.LOCKER_SMALL];
        this.mediumLockers = new Locker[Constants.LOCKER_MEDIUM];
        this.largeLockers = new Locker[Constants.LOCKER_LARGE];
    }
    
    public Code storePackage(Package aPackage, Customer customer) {
        // open close time -> findOptimal -> gen code 
        return null;
    }
    
    private Locker findOptimal(Package aPackage) {
        // aPackage -> size check -> small/medium/large???
        return null;
    }
    
    public void sendCode(Code code) {
        // send code
    }
    
    public Locker pickUp(Customer customer) {
        // customer -> code -> locker
        return null;
    }
    
    public void checkCode() {
        // code -> date -> del, return amz
    }
}

class Package {
    private String id; //???
    private final int length;
    private final int width;
    private final int height;
    
    public Package(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public int getSize() {
        return 0; // confirm with interviewer !!!
    }
}

enum Size {
    SMALL(5), 
    MEDIUM(10),
    LARGE(20);
        
    private final int size;
    
    Size(int size) {
        this.size = size;
    }
}

class Constants {
    public static final int LOCKER_NUM = 100;    
    public static final int LOCKER_SMALL = 30;
    public static final int LOCKER_MEDIUM = 50;
    public static final int LOCKER_LARGE = 20;
    public static final int PERIOD = 3;
}

```