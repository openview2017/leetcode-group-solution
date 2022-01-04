## Design Online Shopping System

### Requirements
```
  User can search by name/category
  User can view products
  User can add/remove/modify products in shopping cart
  Registered User can checkout the shopping cart and buy products 
  User can post review, rate products they bought
  User specify shipping address
  User can cancel order before shipping
  User can return product after delivery , before limited time
  User can pay by online payment method or credit card
  User should be able to track shipment
  User can add new product to sell
  System will send notification to user once there is change in the order or shipping status
```

### Use Case Diagram
```
  Actors :
    Admin: account management, adding, modify product category
    Customer
    Guest: 
      search products, 
      view products,
      add product to shopping cart
      Register as a member
    Member
      search products 
      view
      add to cart
      checkout
      add product to sell
    System
      sending notification for orders, shipments 
  Top Use Case of Online Shopping System
    Add/Update/Remove products for sell
    Search product - by name, by category, sort by price, sort by sold 
    Add/Update/Remove products in shopping cart
    Check out to buy the products in shopping cart
    Make payment/ Place order
    Add a new product to category
    Send notification to members with order/shipment updates
```

### Class Diagram
```
  Account
  Admin
  Member
  Guest
  Catalog : keep index of products for searching
  ProductCategory
  Product
  ProductReview
  ShoppingCart
  Item *** 
  Order
  OrderStatus/OrderLog
  ShipmentLog
  Notification
  Payment
```
