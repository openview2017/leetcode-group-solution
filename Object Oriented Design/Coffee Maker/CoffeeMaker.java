/*
*
*
Description
Design a coffee maker, that take a coffee pack, and can simply make a cup of coffee.
Coffee pack contains the recipe of the coffee, like how many milk / how many sugar to be added in the coffee
Coffee maker can make coffee based on the recipe provided by the coffee pack
Only consider 2 type of ingredients: sugar and milk
the cost of Plain coffee is 2. Add one portion of milk/sugar will increase the cost by 0.5
Consider use decorator design pattern
*
*/

import java.lang.Override;
import java.lang.String;

public class CoffeeMaker {
    public Coffee makeCoffee(CoffeePack pack) {
        int milkCount =  pack.getMilkCount();
        int sugarCount = pack.getSugarCount();
        Coffee coffee = new BaseCoffee();
        for (int i = 0; i < milkCount; i++) {
            coffee = new MilkCoffee(coffee);
        }
        for (int i = 0; i < sugarCount; i++) {
            coffee = new SugarCoffee(coffee);
        }
        return coffee;
    }
}

class CoffeePack {
    private int milkCount;
    private int sugarCount;

    //constructor
    public CoffeePack(int milk, int sugar) {
        this.milkCount = milk;
        this.sugarCount = sugar;
    }
    public int getMilkCount() {
        return milkCount;
    }
    public int getSugarCount() {
        return sugarCount;
    }
}

//1. use decorator pattern, first we need a base interface
interface Coffee {
    //functionality needs to be implemented
    public double getCost();
    public String getIngredients();
}

//2.concrete classes implementing the same interface
class BaseCoffee implements Coffee {
    //override all empty functionality of interface
    @Override
    public double getCost(){
        return 2;
    }

    @Override
    public String getIngredients() {
        return "Plain coffee";
    }
}

//3.an abstract decorator class implementing the above same interface
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    //all founctionality
    public double getCost() {
        return decoratedCoffee.getCost();
    }
    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}

//4. a concrete decorator class extending the above abstract decorator class
class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Coffee coffee) {
        super(coffee); //use base class constructor
    }
    //specialize the functionality here
    public double getCost() {
        return super.getCost() + 0.5;
    }
    public String getIngredients() {
        return super.getIngredients() + " ,Sugar";
    }
}

class MilkCoffee extends CoffeeDecorator {
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }
    //specialize the functionality here
    public double getCost() {
        return super.getCost() + 0.5;
    }
    public String getIngredients() {
        return super.getIngredients() + " ,Milk";
    }
}