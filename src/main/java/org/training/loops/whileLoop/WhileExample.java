package org.training.loops.whileLoop;

public class WhileExample {
    static String[] strArr = new String[]{"adam", "scott", "mark", "jennings", "cook", "root", "ross"};
    static String name = "cook";

    public static void main(String[] args) {
        int[] arr = new int[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = 0;
        while (index < arr.length) {
            System.out.println(arr[index]);
            index++;
        }

        index = -1;
        boolean isUserFound = false;
        /*while (!isUserFound && index < strArr.length) {
            index++;
            isUserFound = strArr[index].equals(name);
        }*/
        while (!isUserFound) {
            index++;
            isUserFound = strArr[index].equals(name);
            if (index == strArr.length - 1) {
                break;
            }
        }
        System.out.println("Position of the user is :: " + index);
    }
}
