package org.training.exceptionHandling;

public class Test {
    public static void main(String[] args) {
        try {
            printNumber();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Test completed");
    }

    public static void printNumber() {
//        System.out.println("Print number");
        printNumber();
    }
}
