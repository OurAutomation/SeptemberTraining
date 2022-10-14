package org.training.loops;

import java.util.Scanner;

public class LoginFunctionality {
    public static void main(String[] args) {
        String expectedUsername = "abcd", expectedPassword = "1234", username2 = "abc", password2 = "123";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username :: ");
        String username = scanner.nextLine();
        System.out.print("Enter the password :: ");
        String password = scanner.nextLine();
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            System.out.println("User logged in");
        } else if (username.equals(username2) && password.equals(password2)) {
            System.out.println("User logged in");
        } else {
            System.out.println("user is not logged in");
        }
    }
}
