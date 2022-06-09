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
    public static final int SEATS = 100;

}

class Cinema {
    private String id;
    private String name;
 
    private List<Movie> movies;    
    private List<Show> shows; // private CinemaHall[] cinemaHalls;

    public Cinema() {
        this.cinemaHalls = new CinemaHall[Constants.HALLS_NUM];
    }

    public Booking book(Customer customer, int persion, Show show) { // find the seat in show
        return null;
    }
    
    private void findSeat(int person, Show show) { // seats in show, seat can also be a class
        
    }
    
    public Ticket pay(Booking booking) {
        return null;
    }
    
    public void cancelBooking(Booking booking) {
        
    }
    
    public void cancelTicket(Ticket ticket) {
        
    }   
}


```

## Extended questions
``` java

/*
Exception:

Design pattern: Observation pattern -> audio
Announce all users about prices changes

observer mode
*/
public abstract class Price {
    protected float price;
    protected Subject subject;
    
    public Price(float price, Subject subject) {
        this.price = price;
        this.subject = subject;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public Subject getSubject() {
        return this.subject;
    }
    
    public abstract void update();
}

public class Adult extends Price {
    public Adult(float price, Subject subject) {
        super(price, subject);
    }
    
    @Override
    public void update() {
        System.out.println(subject.getAction()) + "\n" + price + "\n" + "Adult Get it.");
    }
}

public class Student extends Price {
    public Adult(float price, Subject subject) {
        super(price, subject);
    }
    
    @Override
    public void update() {
        System.out.println(subject.getAction()) + "\n" + price + "\n" + "Student Get it.");
    }
}
public interface Subject {
    public void add(Price price);
    public void remove(Price price);
    public void notifyObservers();
    public void setAction(String action);
    public String getAction();
}

public class Cinema implements Subjects{
    private List<Price> prices;
    private String action;
    public Cinema() {
        prices = new ArrayList<>();
    }
    // CRUD
    @Override
    public void add(Price price) {
        prices.add(price);
    }
    
    @Override
    public void remove(Price price) {
        prices.remove(price);
    }

    @Override
    public void notifyObservers() {
        for (Price price : prices) {
            price.update();
        }
    }
    
    @Override
    public void setAction(String action) {
        this.action = action;
    }
    
    @Override
    public String getAction() {
        return action;
    }
}

public class client {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        
        Price student = new Student(11, cinema);        
        Price adultt = new Adult(11, cinema);

        cinema.add(student);
        cinema.add(adult);
        
        cinema.setAction("Announcement of price change");
        cinema.notifyObservers();
    }
}
```