# Coffee Maker - Step By Step
## Description 
Design a coffee maker, that take a coffee pack, and can simply make a cup of coffee.

1. Coffee pack contains the recipe of the coffee:
    - how many milk
    - how many sugar to be added in the coffee

2. Coffee maker can make coffee based on the recipe provided by the coffee pack
    - Only consider 2 type of ingredients: sugar and milk

3. Cost :
    the cost of Plain coffee is 2.
    Add one portion of milk/sugar will increase the cost by 0.5

4. Consider use decorator design pattern

## 2. what is decorator design pattern ?
> Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
>
> This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
> 
> - Example of shape use decorator pattern : https://dzone.com/articles/decorator-design-pattern-in-java
> 
> - Example of Christmas Tree use decorator pattern : https://www.baeldung.com/java-decorator-pattern

## 2. Second how to implement Decrator Pattern in Design
Procedure:
1. Create an interface.
2. Create concrete classes implementing the same interface.
3. Create an abstract decorator class implementing the above same interface.
4. Create a concrete decorator class extending the above abstract decorator class.
5. Use the concrete decorator class created above to decorate interface objects.

## 3. Use case

-Actors:
    Maker
        -read recipe
        -make coffee
            -add milk
            -add sugar

    Cost calculator
        -count milk
        -count sugar

    Payment
        -cash
        -credit card


## 4. Coffee Maker Class Diagram

CoffeePack
    -Recipe

Recipe
    -milkCount
    -sugarCount

CoffeeMachine
    -makeCoffee(CoffeePack)
    -charge()

Coffee
