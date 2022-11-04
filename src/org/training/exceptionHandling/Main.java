package org.training.exceptionHandling;

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        int i=0;
        int j=1;
        divideTheValues(i,j);
        try {
            divideTheValues(j,i);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("Hello world");
        System.out.println("Hello world1");
        System.out.println("Hello world2");
        //Here you will get checked exception called as interrupted exception
        /*for (int i = 0; i < 10;) {
            Thread.sleep(1 * 1000);
            System.out.println("Waiting for " + ++i +" seconds");
        }*/
        //Here you will get checked exception called as class not found exception
       /* Class.forName("com.ExceptionHandling.Main");*/
//Here you will get checked exception called as IO and File not found exception
//        FileInputStream fis =new FileInputStream("Java.txt");
       /* FileInputStream fis =new FileInputStream("J.txt");*/


    }

    public static void divideTheValues(int i, int j) {
        System.out.println(i / j);
    }

    /**
     * StackTrace:-
     *Exception in thread "main" java.lang.ArithmeticException: / by zero
     * 	at com.ExceptionHandling.Main.divideTheValues(Main.java:13)
     * 	at com.ExceptionHandling.Main.main(Main.java:8)
     */
}
