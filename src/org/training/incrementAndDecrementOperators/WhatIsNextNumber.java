package org.training.incrementAndDecrementOperators;

import java.util.Scanner;

public class WhatIsNextNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number :: ");
        int numberGiven = scanner.nextInt();
        int number = numberGiven + 1;
        System.out.println("Next number is ::  " + number);
        number = numberGiven - 1;
        System.out.println("previous number is :: " + number);
    }
}
