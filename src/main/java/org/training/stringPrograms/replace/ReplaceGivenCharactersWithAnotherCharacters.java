package org.training.stringPrograms.replace;

import java.util.Scanner;

public class ReplaceGivenCharactersWithAnotherCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
        System.out.print("Enter the word to be replaced with :: ");
        String replaceWord = scanner.nextLine();
        System.out.print("Enter the word should be replaced with :: ");
        String newWord = scanner.nextLine();
        System.out.println(paragraph.replace(replaceWord, newWord));
    }
}
