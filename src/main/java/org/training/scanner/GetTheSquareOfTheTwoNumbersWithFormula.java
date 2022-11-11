package org.training.scanner;

import java.util.Scanner;

public class GetTheSquareOfTheTwoNumbersWithFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the A value :: ");
        int a = scanner.nextInt();
        System.out.print("Enter the B value :: ");
        int b = scanner.nextInt();
        int squareValue = a * a + b * b + 2 * a * b;
        System.out.println("Square value is :: " + squareValue);
    }
}
