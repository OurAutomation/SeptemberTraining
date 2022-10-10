package org.training.scanner;

import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number :: ");
        int i = scanner.nextInt();
        System.out.print("Enter the second number :: ");
        int j = scanner.nextInt();
//        System.out.println(add(i,j));
        Add add = new Add();
        System.out.println("The sum of the two numbers is "+add.add(i,j));
    }

    public int add(int i, int j) {
        return i+j;
    }
}
