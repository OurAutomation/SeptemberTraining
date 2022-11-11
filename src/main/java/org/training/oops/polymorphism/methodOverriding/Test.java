package org.training.oops.polymorphism.methodOverriding;

public class Test {
    public static void main(String[] args) {
        CarVersion1 carVersion2 = new CarVersion2();
        carVersion2.tyres();
        carVersion2.wheel();
        carVersion2.windows();
        carVersion2 = new CarVersion1();
        carVersion2.windows();
    }

    //compile time polymorphism, static polymorphism & method overloading
    //Runtime polymorphism, dynamic polymorphism & method overriding

}
