package org.training.loops.forLoop;

public class PrintAlternativesOrEvenIndexesOfAnArray {
    static String[] strArr = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd", "try"};
    static String[] strArr1 = new String[]{"abc", "sdff", "afggh", "test", "trtr", "yuuu", "abcd"};

    public static void main(String[] args) {
        for (int i = 0; i < strArr.length; i = i + 2) {
            System.out.println(strArr[i]);
        }
        for (int i = 0; i < strArr1.length; i = i + 2) {
            System.out.println(strArr[i]);
        }
    }
}
