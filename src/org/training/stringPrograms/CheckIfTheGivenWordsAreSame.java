package org.training.stringPrograms;

import java.util.Scanner;

public class CheckIfTheGivenWordsAreSame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Word 1 :: ");
        String word1 = scanner.nextLine();
        System.out.print("Enter the word 2 :: ");
        String word2 = scanner.nextLine();
        if (word1.equalsIgnoreCase(word2)) {
            System.out.println("Both are equal");
        } else {
            System.out.println("Both are not equal");
        }
    }
}
