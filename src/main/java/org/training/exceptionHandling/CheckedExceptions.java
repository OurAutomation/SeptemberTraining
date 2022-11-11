package org.training.exceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptions {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("Java.tx");
        /*try {
            FileInputStream fis = new FileInputStream(file);
            System.out.println("In try block");
            Thread.sleep(1000);
        } catch (FileNotFoundException e) {
            System.out.println("File Not found Exception occurred");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception occurred");
        }*/

        /*try {
            FileInputStream fis = new FileInputStream(file);
            System.out.println("In try block");
            Thread.sleep(1000);
        } catch (FileNotFoundException | InterruptedException e) {
            System.out.println("File Not found Exception occurred");
        }*/
        FileInputStream fis = null;
       /* try {
            fis = new FileInputStream(file);
            System.out.println("In try block");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("File Not found Exception occurred");
        } finally {
            System.out.println("Finally block");
            fis.close();
        }*/
        try {
            fis = new FileInputStream(file);
            System.out.println("In try block");
            Thread.sleep(1000);
        } finally {
            System.out.println("Finally block");
            fis.close();
        }
        System.out.println("ABNNC");
    }
}
