package org.training.loops;

import java.util.Scanner;

public class TollPlaza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the available balance :: ");
        long availableBalance = scanner.nextLong();
        System.out.print("The charge of the toll :: ");
        long tollAmount = scanner.nextLong();
        /*if (availableBalance > tollAmount) {
            System.out.println("pass");
        } else if (availableBalance == tollAmount) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("insufficient funds");
        }*/

        if (availableBalance >= tollAmount) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("insufficient funds");
        }
    }
}
