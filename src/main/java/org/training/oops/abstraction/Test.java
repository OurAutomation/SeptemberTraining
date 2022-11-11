package org.training.oops.abstraction;

public class Test {
    public static void main(String[] args) {
        ICalculatorImpl calculator = new ICalculatorImpl();
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.subtract(1, 2));
        System.out.println(calculator.multiply(1, 2));
        System.out.println(calculator.add(451, 2));
        ChildAbstractClass childAbstractClass = new ChildAbstractClass();
        System.out.println(childAbstractClass.add(1, 2));
        System.out.println(childAbstractClass.multiply(5, 2));

        AbstractCalculator abstractCalculator = new ChildAbstractClass();
        System.out.println(abstractCalculator.add(1, 2));
        System.out.println(childAbstractClass.multiply(5, 2));
    }
}

/**
 * Abstract class:- Can contain abstract methods and concurrent methods
 * Interface :- Can contain only abstract methods
 * Abstract class:- To Access methods in abstract class you need to extend it with child class and create abn object and use them
 * Interface :- You have to implement an interface in a java class and write implementation of all the abstract methods
 * Abstract class:- You can extend only one abstract class
 * Interface:- You can implement multiple interfaces in a single java class
 */
