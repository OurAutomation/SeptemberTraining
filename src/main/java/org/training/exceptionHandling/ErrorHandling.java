package org.training.exceptionHandling;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ErrorHandling {

    public static void main(String[] args) throws SravanException, FileNotFoundException {
        try {
            System.out.println(1 / 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        recursion(10);
        int a = 10;
        int b = 12;
        FileInputStream fis = new FileInputStream("");
        System.out.println("completed");
        throw new SravanException();
    }

    public static void recursion(int i) {
        if (i != 0) {
            recursion(i + 1);
        } else {
            throw new ArithmeticException("Value is zero");
        }

    }
}
