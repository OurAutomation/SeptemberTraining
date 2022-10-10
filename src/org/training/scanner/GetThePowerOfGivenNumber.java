package org.training.scanner;

import java.util.Scanner;

public class GetThePowerOfGivenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base :: ");
        int base = scanner.nextInt();
        System.out.print("Enter the power :: ");
        int power = scanner.nextInt();
        System.out.println("The power value is :: " + Math.pow(base,power));
    }
}
