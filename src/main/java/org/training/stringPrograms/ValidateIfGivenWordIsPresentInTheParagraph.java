package org.training.stringPrograms;

import java.util.Scanner;

public class ValidateIfGivenWordIsPresentInTheParagraph {
    //Videos, stories and exercises on the 30 human rights. For example: The Right to Life, Freedom of Thought, Freedom of Expression, and others. A video and story to illustrate each right.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
        System.out.print("Enter the word :: ");
        String word = scanner.nextLine();
        String[] allWords = paragraph.split(" ");
        boolean isWordPresent = false;
        for (String var : allWords) {
            if (var.equalsIgnoreCase(word)) {
                isWordPresent = true;
                break;
            }
        }
        if (isWordPresent) {
            System.out.println("Given word :: " + word + " is available in the given paragraph");
        } else {
            System.out.println("Given word :: " + word + " is not available in the given paragraph");
        }
    }
}
