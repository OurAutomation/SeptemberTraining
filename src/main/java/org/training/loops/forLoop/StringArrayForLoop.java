package org.training.loops.forLoop;

public class StringArrayForLoop {
    static String[] strArr = new String[]{"abc", "sdff", "afggh", "eurghteuighetu", "trtr", "yuuu", "try"};

    public static void main(String[] args) {
        System.out.println("Length of the array :: " + strArr.length);
        for (int i = 0; i <= strArr.length - 1; i++) {
            String presentString = strArr[i];
            System.out.println(presentString);
        }
        for (int i = 0; i < strArr.length; i++) {
            String presentString = strArr[i];
            System.out.println(presentString);
        }
        for (String str : strArr) {
            System.out.println(str);
        }
    }
}
