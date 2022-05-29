# Singleton

## <b>Problem Description</b>

https://www.lintcode.com/problem/204/

Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. 
For example, for class Mouse (not a animal mouse), we should design it in singleton.

You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.

**Example**

      In Java:
    
        A a = A.getInstance();
        A b = A.getInstance();
    
      a should equal to b.

**Challenge:**

- If we call getInstance concurrently, can you make sure your code could run correctly?

----

 编写单例模式需要考虑的事情:

- 单例模式：任何时候获取的对象，应该是同一个
- 需禁止类外使用 new 关键字构造对象，所以用 private 关键字修饰构造函数，将其私有化
- 因为不能使用 new 关键字构建对象，所以我们需要暴露一个方法给外部，作为单例对象与外界沟通的唯一方式。使用静态方法是个不错的选择。
- 多线程情况下，需要保证对象是单例的。

```java
public class Singleton {
    // 1. 私有单例对象，禁止通过 类名。属性 访问
     // 2. 将其声明为静态成员，使得在静态方法中得以访问
     // 3. 使用 volatile 关键字，消除指令重排序的影响
     private static volatile Singleton instance;

    // 1. 私有构造函数
     private Singleton() {
    
    }   
    
    // 静态方法，返回单例对象。双重检查 + synchroinzed 锁，保证多线程下 instance 对象唯一
     public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    // 多线程并发访问，只会有一个线程初始化成功
                     instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
```

----

## 基本式

```java
public class ParkingLot {
	private static ParkingLot _instance = null;

	private List<Level> levels;

	private ParkingLot() {
		levels = new ArrayList<Level>();
	}

	public static synchronized ParkingLot getInstance() {
		if (_instance == null) {
			_instance = new ParkingLot();
		}

		return _instance;
	}
} 
```

## 静态内部类

<aside> 💡 static, nested class
</aside>

既是线程安全的，又性能比较好

```java
public class ParkingLot {
	private ParkingLot() {}
	
	// 静态内部类
	private static class LazyParkingLot {
		static final ParkingLot _instance = new ParkingLot();
	}

	public static ParkingLot getInstance() {
		return LazyParkingLot._instance;
	}
}
```

- 由于 `LazyParkingLot` 在 `ParkingLot` 的内部，所以可以调用 `ParkingLot` 的构造函数

- `_instance `是 `final`的，所以不需要 `synchronize`关键词也是线程安全的
  - 即使有多个线程，也不会创造多个 instance
  - 在创建 `LayParkingLot` 的时候，就已经完成了 `new ParkingLot`

------

## V1: 双重检查+synchronized锁 - 懒汉版

```java
// V1:双重检查+synchronized锁 - 懒汉版
public class Solution{
    
    // 1. 私有单例对象，禁止通过 类名.属性 访问
    // 2. 将其声明为静态成员，使得在静态方法中得以访问
    // 3. 使用volatile关键字，消除指令重排序的影响
    private static volatile Solution instance;
    
    // 1. 私有构造函数
    private Soltion(){
        
    }
    
    // 静态方法，返回单例对象。双重检查+synchroinzed锁，保证多线程下instance对象唯一
    public static Solution getInstance(){
        if(instance == null){
            synchronized(Solution.class){
                if(instance == null){
                    // 多线程并发访问，只会有一个线程初始化成功
                    instance = new Soltion();
                }
            }
        }
        return instance;
            
    }
}
```

## V2: 静态内部类版

```java
// V2: 静态内部类版
public class Solution{
   
    static class InnerClass{
        private static Solution instance = new Sotluion();
    }
    
    public static Solution getInstance(){
        return Solution.instance;
    }
    
}
```

## V3: 枚举类版

```java
// V3: 枚举类版
public enum Solution{
    INSTANCE;
    
    public static Solutin getInstance(){
        return Solution.INSTANCE;
    }
}
```

