package org.training.stringPrograms;

import java.util.Locale;
import java.util.Scanner;

public class ConvertToSmallLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word :: ");
        String word = scanner.nextLine();
        System.out.println(word.toLowerCase(Locale.ROOT));
    }
}
