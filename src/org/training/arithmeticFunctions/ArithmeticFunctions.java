package org.training.arithmeticFunctions;

public class ArithmeticFunctions {
    public static int i=10;
    public static String str="1000 bhargha %4$$$8*&^";
    public static char c='1';
    public static void main(String[] args) {
        /*System.out.println(1+2);
        System.out.println(7-2);
        System.out.println(7*2);
        System.out.println(8/2);*/
        System.out.println(i);
        System.out.println(i*10);
        System.out.println(i/2);
        System.out.println(str);
        System.out.println(c);
        ArithmeticFunctions arithmeticFunctions = new ArithmeticFunctions();
        arithmeticFunctions.add(2,3);
        arithmeticFunctions.add(2,3);
        arithmeticFunctions.add(5,6);
        arithmeticFunctions.subtract(4,2);
        arithmeticFunctions.multiply(5,6);
        arithmeticFunctions.divide(7,7);
        printHelloWorld();
    }

    public static void printHelloWorld() {
        System.out.println("Hello World !!!");
    }
//public,private,protected,default
    public static void add(int i, int j) {
        System.out.println(i+j);
    }

    public void subtract(int i, int j) {
        System.out.println(i-j);
    }

    public void multiply(int i, int j) {
        System.out.println(i*j);
    }

    public void divide(int i,int j) {
        System.out.println(i/j);
    }
}
