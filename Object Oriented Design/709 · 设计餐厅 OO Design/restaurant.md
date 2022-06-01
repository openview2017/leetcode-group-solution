

# 描述

1. 不能预订座位
2. 不能订外卖
3. 餐馆的桌子有不同大小
4. 餐馆会优先选择适合当前Party最小的空桌（例如，如果客人一共有3个人，餐厅将分配一张4人的桌子，而不是10人的桌子）
5. 需要实现Restaurant Class


## steps
1. set up restaurant
2. find the table for party
3. place an order
4. check out;


## 0. define classes
``` java
class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;
}

class Table implements Comparable<Table>{
	private int capacity;
	private boolean available;
	private Order order;    
}

class Order { 
    private List<Meal> meals;
}

class Meal {
    private float price;
}

class Party {
    private int size;
}

```

## 1. set up restaurant
### Output
``` java
// Table: 0, table size: 4, isAvailable: true. No current order for this table.
// Table: 1, table size: 4, isAvailable: true. No current order for this table.
// Table: 2, table size: 10, isAvailable: true. No current order for this table.
```

### Code
``` java
public class Main {
    public static void main(String[] args) {
        Restaurant rest = new Restaurant();
        //创建三个桌子
        Table t1 = new Table(4);
        Table t2 = new Table(4);
        Table t3 = new Table(10);  
        rest.addTable(t1);        
        rest.addTable(t2);
        rest.addTable(t3);  
        
        //创建三个菜
        Meal m1 = new Meal(10.0f);
        Meal m2 = new Meal(13.0f);
        Meal m3 = new Meal(17.0f);        

        List<Meal> restMeal = rest.getMenu();
        restMeal.add(m1);
        restMeal.add(m2);
        restMeal.add(m3);
        System.out.println(rest.restaurantDescription());
    }
}


class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;

    	
	public Restaurant()
	{
		tables = new ArrayList<Table>();
		menu = new ArrayList<Meal>();
	}

    public List<Meal> getMenu()
	{
		return menu;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		//Collections.sort(tables);
	}
    
	public String restaurantDescription()
	{
        // Keep them, don't modify.
		String description = "";
		for(int i = 0; i < tables.size(); i++)
		{
			Table table = tables.get(i);
			description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
			if(table.getCurrentOrder() == null)
				description += " No current order for this table"; 
			else if (table.getCurrentOrder() == null)
                description +=  " Order price: 0.0";
            else
				description +=  " Order price: " + table.getCurrentOrder().getBill();
			
			description += ".\n";
		}
		description += "*****************************************\n";
		return description;
	}    
}

class Table {
	private int capacity;
	private boolean available;
	private Order order; 
    
	public Table(int capacity)
	{
		this.capacity = capacity;
		available = true;
		order = null;
	}
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}
	
	public Order getCurrentOrder()
	{
		return this.order;
	}
}

class Order { 
    private List<Meal> meals;
 
	public Order()
	{
		meals = new ArrayList<Meal>();
	}
    
	public float getBill()
	{ // !!!
		int bill = 0;
		return bill;
	}    
}

class Meal {
	private float price;
	
	public Meal(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

class Party {
    private int size;
}
```

## 2. find table for the party
### Output
```
Table: 0, table size: 4, isAvailable: true. No current order for this table.
Table: 1, table size: 4, isAvailable: true. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: true. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: false. No current order for this table.
*****************************************


```

### Code
``` java
public class Main {
    public static void main(String[] args) throws NoTableException {
        Restaurant rest = new Restaurant();
        //创建三个桌子
        Table t1 = new Table(4);
        Table t2 = new Table(4);
        Table t3 = new Table(10);  
        rest.addTable(t1);        
        rest.addTable(t2);
        rest.addTable(t3);  
        
        //创建三个菜
        Meal m1 = new Meal(10.0f);
        Meal m2 = new Meal(13.0f);
        Meal m3 = new Meal(17.0f);        

        List<Meal> restMeal = rest.getMenu();
        restMeal.add(m1);
        restMeal.add(m2);
        restMeal.add(m3);
        System.out.println(rest.restaurantDescription());
 /**********************************************/
         //输入备选的party
        Party p1 = new Party(3);
        Party p3 = new Party(4);
        Party p4 = new Party(6);   
        //给第1，3，4的party安排桌子
        rest.findTable(p1);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p3);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p4);
        System.out.println(rest.restaurantDescription());
    }
}


class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;

    	
	public Restaurant()
	{
		tables = new ArrayList<Table>();
		menu = new ArrayList<Meal>();
	}

    public List<Meal> getMenu()
	{
		return menu;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		Collections.sort(tables);
	}

/************find the table*****************/
	public void findTable(Party p) throws NoTableException
	{
		for(Table t: tables)
		{
			if(t.isAvailable())
			{
				if(t.getCapacity() >= p.getSize())
				{
					t.markUnavailable();
					return;
				}
			}
		}
		throw new NoTableException(p);
	}
/************find the table*****************/
    
	public String restaurantDescription()
	{
        // Keep them, don't modify.
		String description = "";
		for(int i = 0; i < tables.size(); i++)
		{
			Table table = tables.get(i);
			description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
			if(table.getCurrentOrder() == null)
				description += " No current order for this table"; 
			else if (table.getCurrentOrder() == null)
                description +=  " Order price: 0.0";
            else
				description +=  " Order price: " + table.getCurrentOrder().getBill();
			
			description += ".\n";
		}
		description += "*****************************************\n";
		return description;
	}    
}

class Table implements Comparable<Table> {
	private int capacity;
	private boolean available;
	private Order order; 
    
	public Table(int capacity)
	{
		this.capacity = capacity;
		available = true;
		order = null;
	}
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}
     /*******/
	public void markAvailable()
	{
		this.available = true;
	}
	
	public void markUnavailable()
	{
		this.available = false;
	}
     /*******/	
	public Order getCurrentOrder()
	{
		return this.order;
	}
    
    /*******/
    @Override
	public int compareTo(Table compareTable) {
		// TODO Auto-generated method stub
		return this.capacity - compareTable.getCapacity();
	}
    /*******/
}

class Order { 
    private List<Meal> meals;
 
	public Order()
	{
		meals = new ArrayList<Meal>();
	}
    
	public float getBill()
	{ // !!!
		int bill = 0;
		return bill;
	}    
}

class Meal {
	private float price;
	
	public Meal(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

/*******/
class Party {
	private int size;
	
	public Party(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
}

class NoTableException extends Exception{

	public NoTableException(Party p)
	{
		super("No table available for party size: " + p.getSize());
	}
}
/*******/


```

## 3. place an order

### Output
```


```

# Code
```java
public class Main {
    public static void main(String[] args) throws NoTableException {
        Restaurant rest = new Restaurant();
        //创建三个桌子
        Table t1 = new Table(4);
        Table t2 = new Table(4);
        Table t3 = new Table(10);  
        rest.addTable(t1);        
        rest.addTable(t2);
        rest.addTable(t3);  
        
        //创建三个菜
        Meal m1 = new Meal(10.0f);
        Meal m2 = new Meal(13.0f);
        Meal m3 = new Meal(17.0f);        

        List<Meal> restMeal = rest.getMenu();
        restMeal.add(m1);
        restMeal.add(m2);
        restMeal.add(m3);
        System.out.println(rest.restaurantDescription());

         //输入备选的party
        Party p1 = new Party(3);
        Party p3 = new Party(4);
        Party p4 = new Party(6);   
        //给第1，3，4的party安排桌子
        rest.findTable(p1);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p3);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p4);
        System.out.println(rest.restaurantDescription());
 
/************make order***********************/        
        //创建order
        Order o1 = new Order();
        o1.getMeals().add(m1);
        Order o2 = new Order();
        o2.getMeals().add(m2);        
        o2.getMeals().add(m3); 
        
        //第一桌点了第一个order
        rest.takeOrder(t1, o1);
        System.out.println(rest.restaurantDescription());
        
        //第三桌点了第二个order
        rest.takeOrder(t3, o2);
        System.out.println(rest.restaurantDescription());

    }
}


class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;

    	
	public Restaurant()
	{
		tables = new ArrayList<Table>();
		menu = new ArrayList<Meal>();
	}

    public List<Meal> getMenu()
	{
		return menu;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		Collections.sort(tables);
	}

	public void findTable(Party p) throws NoTableException
	{
		for(Table t: tables)
		{
			if(t.isAvailable())
			{
				if(t.getCapacity() >= p.getSize())
				{
					t.markUnavailable();
					return;
				}
			}
		}
		throw new NoTableException(p);
	}

/************make order***********************/
    public void takeOrder(Table t, Order o)
	{
		t.setOrder(o);
	}
    
	public String restaurantDescription()
	{
        // Keep them, don't modify.
		String description = "";
		for(int i = 0; i < tables.size(); i++)
		{
			Table table = tables.get(i);
			description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
			if(table.getCurrentOrder() == null)
				description += " No current order for this table"; 
			else if (table.getCurrentOrder() == null)
                description +=  " Order price: 0.0";
            else
				description +=  " Order price: " + table.getCurrentOrder().getBill();
			
			description += ".\n";
		}
		description += "*****************************************\n";
		return description;
	}    
}

class Table implements Comparable<Table> {
	private int capacity;
	private boolean available;
	private Order order; 
    
	public Table(int capacity)
	{
		this.capacity = capacity;
		available = true;
		order = null;
	}
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}
    
	public void markAvailable()
	{
		this.available = true;
	}
	
	public void markUnavailable()
	{
		this.available = false;
	}
    	
	public Order getCurrentOrder()
	{
		return this.order;
	}

    /*****set order********/
    public void setOrder(Order o)
	{
		if(order == null)
		{
			this.order = o;
		}
		else 
		{
			if(o != null)
			{
				this.order.mergeOrder(o);
			} else {
				this.order = o;
			}
		}
	}
    
    @Override
	public int compareTo(Table compareTable) {
		// TODO Auto-generated method stub
		return this.capacity - compareTable.getCapacity();
	}
}

class Order { 
    private List<Meal> meals;
 
	public Order()
	{
		meals = new ArrayList<Meal>();
	}

    /******add order*****/
    public List<Meal> getMeals()
	{
		return meals;
	}
    
	public void mergeOrder(Order order)
	{
		if(order != null)
		{
			for(Meal meal : order.getMeals())
			{
				meals.add(meal);
			}
		}
	}
    
	public float getBill()
	{
		int bill = 0;
		for(Meal meal : meals)
		{
			bill += meal.getPrice();
		}
		return bill;
	} 
    /******add order*****/
}

class Meal {
	private float price;
	
	public Meal(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

class Party {
	private int size;
	
	public Party(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
}

class NoTableException extends Exception{

	public NoTableException(Party p)
	{
		super("No table available for party size: " + p.getSize());
	}
}



```


## 4. check_out and Complete code
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) throws NoTableException {
        Restaurant rest = new Restaurant();
        //创建三个桌子
        Table t1 = new Table(4);
        Table t2 = new Table(4);
        Table t3 = new Table(10);
        
        rest.addTable(t1);        
        rest.addTable(t2);
        rest.addTable(t3);

        //创建三个菜
        Meal m1 = new Meal(10.0f);
        Meal m2 = new Meal(13.0f);
        Meal m3 = new Meal(17.0f);        

        List<Meal> restMeal = rest.getMenu();
        restMeal.add(m1);
        restMeal.add(m2);
        restMeal.add(m3);
        System.out.println(rest.restaurantDescription());
        

        
        //输入备选的party
        Party p1 = new Party(3);
        Party p3 = new Party(4);
        Party p4 = new Party(6);
        
        //创建order
        Order o1 = new Order();
        o1.getMeals().add(m1);
        Order o2 = new Order();
        o2.getMeals().add(m2);        
        o2.getMeals().add(m3);

        //给第1，3，4的party安排桌子
        rest.findTable(p1);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p3);
        System.out.println(rest.restaurantDescription());
        rest.findTable(p4);
        System.out.println(rest.restaurantDescription());
        
        //第一桌点了第一个order
        rest.takeOrder(t1, o1);
        System.out.println(rest.restaurantDescription());
        
        //第三桌点了第二个order
        rest.takeOrder(t3, o2);
        System.out.println(rest.restaurantDescription());
        
        //第三桌checkout
        rest.checkOut(t3);
        System.out.println(rest.restaurantDescription());
        //给第4个party安排桌子
        rest.findTable(p4);
        System.out.println(rest.restaurantDescription());

    }
}

class NoTableException extends Exception{

	public NoTableException(Party p)
	{
		super("No table available for party size: " + p.getSize());
	}
}

class Meal {
	private float price;
	
	public Meal(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

class Order {
	private List<Meal> meals;
	
	public Order()
	{
		meals = new ArrayList<Meal>();
	}
	
	public List<Meal> getMeals()
	{
		return meals;
	}
	
	public void mergeOrder(Order order)
	{
		if(order != null)
		{
			for(Meal meal : order.getMeals())
			{
				meals.add(meal);
			}
		}
	}
	
	public float getBill()
	{
		int bill = 0;
		for(Meal meal : meals)
		{
			bill += meal.getPrice();
		}
		return bill;
	}
}

class Party {
	private int size;
	
	public Party(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
}

class Table implements Comparable<Table>{
	private int capacity;
	private boolean available;
	private Order order;
	
	public Table(int capacity)
	{
		this.capacity = capacity;
		available = true;
		order = null;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}
	
	public void markAvailable()
	{
		this.available = true;
	}
	
	public void markUnavailable()
	{
		this.available = false;
	}
	
	public Order getCurrentOrder()
	{
		return this.order;
	}
	
	public void setOrder(Order o)
	{
		if(order == null)
		{
			this.order = o;
		}
		else 
		{
			if(o != null)
			{
				this.order.mergeOrder(o);
			} else {
				this.order = o;
			}
		}
	}

	@Override
	public int compareTo(Table compareTable) {
		// TODO Auto-generated method stub
		return this.capacity - compareTable.getCapacity();
	}
}

class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;
	
	public Restaurant()
	{
		tables = new ArrayList<Table>();
		menu = new ArrayList<Meal>();
	}
	
	public void findTable(Party p) throws NoTableException
	{
		for(Table t: tables)
		{
			if(t.isAvailable())
			{
				if(t.getCapacity() >= p.getSize())
				{
					t.markUnavailable();
					return;
				}
			}
		}
		throw new NoTableException(p);
	}
	
	public void takeOrder(Table t, Order o)
	{
		t.setOrder(o);
	}
	
	public float checkOut(Table t)
	{
		float bill = 0;
		if(t.getCurrentOrder() != null)
		{
			bill = t.getCurrentOrder().getBill();
		}

		t.markAvailable();
		t.setOrder(null);
		
		return bill;
	}
	
	public List<Meal> getMenu()
	{
		return menu;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		Collections.sort(tables);
	}
	
	public String restaurantDescription()
	{
        // Keep them, don't modify.
		String description = "";
		for(int i = 0; i < tables.size(); i++)
		{
			Table table = tables.get(i);
			description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
			if(table.getCurrentOrder() == null)
				description += " No current order for this table"; 
			else
				description +=  " Order price: " + table.getCurrentOrder().getBill();
			
			description += ".\n";
		}
		description += "*****************************************\n";
		return description;
	}
}

```

