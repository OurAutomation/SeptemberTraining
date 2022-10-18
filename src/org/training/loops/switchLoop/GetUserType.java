package org.training.loops.switchLoop;

import java.util.Locale;
import java.util.Scanner;

public class GetUserType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username :: ");
        String username = scanner.nextLine();
        switch (username.toLowerCase(Locale.ROOT)) {
            case "adam":
                System.out.println("He is an admin user");
                break;
            case "jake":
                System.out.println("He is an organization level user");
                break;
            case "scott":
                System.out.println("He is a customer");
                break;
            case "brad":
                System.out.println("He is a hacker");
                break;
            default:
                System.out.println("Unknown user or he does not have any rights");
        }
    }
}
