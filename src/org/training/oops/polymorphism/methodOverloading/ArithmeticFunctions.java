package org.training.oops.polymorphism.methodOverloading;

public class ArithmeticFunctions {
    //This is also called compile time polymorphism
    public int add(int a, int b) {
        return a + b;
    }
    //add2intint

    public int add(int a, int b, int c) {
        return a + b;
    }
    //add3intintint
    //Method Signature :-  NameOfTheMethod + NumberOfParameters + TypeOfParameters

    public String add(String a, String b) {
        return a+b;
    }
    //add2StringString
}
