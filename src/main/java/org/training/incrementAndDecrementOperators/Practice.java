package org.training.incrementAndDecrementOperators;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age :: ");
        int age = scanner.nextInt();
        age = age + 10;
        System.out.println("Age after 10 years is " + age);
        age = age + 10;
        System.out.println("Age after 20 years is " + age);
        age = age + 10;
        System.out.println("Age after 30 years is " + age);

    }
}
