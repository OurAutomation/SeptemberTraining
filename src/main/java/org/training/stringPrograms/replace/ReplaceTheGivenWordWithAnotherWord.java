package org.training.stringPrograms.replace;

import java.util.Scanner;

public class ReplaceTheGivenWordWithAnotherWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the paragraph :: ");
        String paragraph = scanner.nextLine();
        System.out.print("Enter the word to be replaced with :: ");
        String replaceWord = scanner.nextLine();
        System.out.print("Enter the word should be replaced with :: ");
        String newWord = scanner.nextLine();
        String[] strArr = paragraph.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            if(strArr[i].equalsIgnoreCase(replaceWord)) {
                strArr[i]=newWord;
            }
        }
        String replaceSentence = "";
        for (int i = 0; i < strArr.length; i++) {
            replaceSentence = replaceSentence + " "+strArr[i] + " ";
        }
        System.out.println(replaceSentence.trim());
    }
}
