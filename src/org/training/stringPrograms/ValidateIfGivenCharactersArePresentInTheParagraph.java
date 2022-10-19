package org.training.stringPrograms;

import java.util.Locale;
import java.util.Scanner;

public class ValidateIfGivenCharactersArePresentInTheParagraph {
    //Videos, stories and exercises on the 30 human rights. For example: The Right to Life, Freedom of Thought, Freedom of Expression, and others. A video and story to illustrate each right.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
        System.out.print("Enter the word :: ");
        String word = scanner.nextLine();
        if (paragraph.contains(word)) {
            System.out.println("Given word is present");
        } else if (paragraph.toLowerCase().contains(word.toLowerCase())) {
            System.out.println("Given word is present but in a different case");
        } else {
            System.out.println("Given word is not present");
        }
    }
}
