package org.training.stringPrograms;

import java.util.Locale;
import java.util.Scanner;

public class RemoveTrainingAndLeadingWhiteSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sentence :: ");
        String word = scanner.nextLine();
        System.out.println(word.trim());
    }
}
