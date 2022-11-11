package org.training.oops.polymorphism.methodOverloading;

public class Test {
    public static void main(String[] args) {
        ArithmeticFunctions arithmeticFunctions = new ArithmeticFunctions();
        System.out.println(arithmeticFunctions.add(1, 2, 3));
        System.out.println(arithmeticFunctions.add(1, 3));
        System.out.println(arithmeticFunctions.add("1", "2"));
    }
}
