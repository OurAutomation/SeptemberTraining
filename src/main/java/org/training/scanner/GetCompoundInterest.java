package org.training.scanner;

import java.util.Scanner;

public class GetCompoundInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the principal amount :: ");
        int principal = scanner.nextInt();
        System.out.print("Enter the duration in number of months :: ");
        int time = scanner.nextInt();
        System.out.print("Enter the rate of interest :: ");
        int rate = scanner.nextInt();
        System.out.println("Interest amount is :: " + getCompoundInterest(principal, time, rate));
    }

    public static double getCompoundInterest(int principal, int time, int rate) {
        // Principal (1 + Rate)Time − Principal
        return principal*(Math.pow((1+rate),time))-principal ;
    }
}
