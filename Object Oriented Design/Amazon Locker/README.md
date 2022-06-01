

# Step 0. Define class
```java
// "static void main" must be defined in a public class.

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