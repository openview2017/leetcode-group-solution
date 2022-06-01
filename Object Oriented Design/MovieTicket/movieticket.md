# Movie Ticket

# 0. Define class
``` java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Customer{
    private String name;
    private String phone;
    private String DriverLicense;
}

class MovieSystem {
    List<Cinema> cinemas;
    
    public List<Cinema> search(City city) {
        return null;
    }
    
    public List<Cinema> search(Movie movie) { // polymorphism
        return null;
    }
    
    public Cinema select(String name) {
        return null;
    }
    
    public void addCinema(Cinema cinema) {
        
    }
}

class City {
    private String id;    
    private String name;

}

class CinemaHall {
    private int id;
    private List<Movie> movies; 
    private List<Show> shows;
    private boolean[] seats;
}

class Movie {
    private String id;
    private String name;
    private int duration;
    // arrange CRUD
    private List<Show> shows;
    
    public List<Show> addShow(Movie movie) {
        return null;
    }
}

class Show { // 
    private String id;
    private Date startTime;
    private Date endTime;
    private CinemaHall cinemaHall;
    private Movie movie;
    private Price price;
    private boolean[] seats; // can be class, if classify and override
    private boolean available;
    
    // CRUD
    
}

class Booking {
    private String id;
    private Customer customer;
    private List<Customer> customers; // can order multiple tickets
    private Show show;

    public void addCustomer(Customer customer) {
        
    }
}

class Ticket {
    private String id;
    private Booking booking;
    private int paymentmethod;
    private float price;
}

class Price {
    private final PriceType type;
    protected float price;
    
    public Price(PriceType type) {
        this.type = type;
    }
}

enum PriceTag {
    ADULT,
    CHILD,
    STUDENT;
}

class Student extends Price {
    public Student() {
        super(PriceType.STUDENT);
    }
}

class Child extends Price {
    public Child() {
        super(PriceType.CHILD);
    }
}

class Adult extends Price {
    public Adult() {
        super(PriceType.ADULT);
    }
}

class Constants {
    public static final int HALLS_NUM = 10;
}

class Cinema {
    private String id;
    private String name;
    private CinemaHall[] cinemaHalls;
    private List<Movie> movies;    
    private List<Show> shows;

    
    public Cinema() {
        this.cinemaHalls = new CinemaHall[Constants.HALLS_NUM];
    }
}

```

## 1. Use case analysis
``` java

```