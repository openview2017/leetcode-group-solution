import java.util.Date;

//Enums, data types and constants
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
public enum AccountStatus {
    ACTIVE, BLOCKED, BANNED, ARCHIVED, UNKNOWN
}
public enum OrderStatus {
    PENDING, SHIPPED, COMPLETED, CANCELLED, REFUNDED_APPLIED, REFUNDED_COMPLETED
}
public enum ShipmentStatus {
    PENDING, SHIPPED, DELIVERED
}
public enum PaymentStatus {
    UNPAID, PENDING, PAID, DECLINED, CANCELLED, REFUNDED
}

//main class
public class Account {
    private String userName;
    private String passWord;
    private String displayName;
    private AccountStatus status;
    private Address shipAddress;
    private String email;
    private String phone;

    private List<CreditCard> creditCardList;
    private List<ElectronicBank> electronicBankList;

    public boolean addProduct(Product product);
    public boolean addProductReview(ProductReview review);
    public boolean resetPassword();
}
public abstract class Customer {
    private Shoppingcart cart;
    private Order order;

    public Shoppingcart getShoppingCart();
    public boolean addItemToCart(Item item);
    public boolean removeItemFromCart(Item item);
}
public class Guest extends Customer {
    public boolean registerAccount();
}
public class Memeber extends Customer {
    private Account account;
    public OrderStatus placeOrder(Order order);
}

public class Product {
    private String productId;
    private double productPrice;
    private String name;
    private String description;
    private ProductCategory category;
    private int availableCount;
    private Account seller;

    public int getAvailableCount();
    public boolean updatePrice(double newPrice);
}
public class ProductCategory {
    private String name;
    private String description;
}

private class Item {
    private String productId;
    private int quantity;
    private double price;

    public boolean updateQuantity(int quantity);
}
private class Order {
    private String orderNumber;
    private OrderStatus orderStatus;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public boolean sendForShipment();
    public boolean makePayment();
    public boolean addLog(OrderLog orderLog);
}
private class OrderLog {
    private String orderNumber;
    private Date logCreatedTime;
    private OrderStatus orderStatus;
}
public class Shipment {
    private String shipmentNumber;
    private ShipmentStatus shipmentStatus;
    private Date shipDate;
    private Date estimatedDeliveryDate;
    private String shipMethod;
    private List<ShipmentLog> shipmentLogList;

    public boolean addShipmentLog(ShipmentLog, log);
}
public class ShipmentLog {
    private String shipmentId;
    private Date logCreatedDate;
    private ShipmentStatus shipmentStatus;
}


private class ProductReview {
    private double rate;
    private String review;
    private Member poster;
}


private class Shoppingcart {
    private List<Item> items;

    public boolean addItem(Item item);
    public boolean updateItemQuantity(Item item, int quantity);
    public boolean removeItem(Item item);
    public List<Item> getItems();
    public boolean checkout();
}


public abstract class Notification {
    private String notificationId;
    private String content;
    private Date date;

    public boolean sendNotification(Account account);
}

//Interface and implementation
public interface Search {
    public List<Product> searchProductByName(String name);
    public List<Product> searchProductByCategory(String category);
}
public class CataLog implements Search {
    HashMap<String, List<Product>> productNameMap;
    HashMap<String, List<Product>> productCategoryMap;

    public List<Product> searchProductByName(String name) {
        return productNameMap.get(name);
    }
    public List<Product> searchProductByCategory(String category) {
        return productCategoryMap.get(category);
    }
}


private class CreditCard {
}
private class ElectronicBank {
}
