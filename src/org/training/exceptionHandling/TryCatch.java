package org.training.exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TryCatch {

    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.out.println("you are passing values which gives infinity value");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }

        try {
            System.out.println(1 / 0);
            FileInputStream fis = new FileInputStream("");
        } catch (ArithmeticException | FileNotFoundException e) {
            System.out.println("Wrong filwe or wrong values are passed");
        }  finally {
            System.out.println("finally block");
        }

        /*try {
            System.out.println(0 / 0);
            System.out.println(1 / 0);
        } finally {
            System.out.println("finally block");
        }*/

    }
}
