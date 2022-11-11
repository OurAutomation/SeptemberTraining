package org.training.loops.forLoop;

public class PrintAllTheNumbersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]
                {11, 2, 2, 5, 45, 5, 8, 54, 1, 6, 9, 8989, 78, 89, 56, 43, 2, 23,
                        56566, 588, 9, 88, 9, 88, 777, 8, 8, 8, 99};
        System.out.println("Length of the array is :: " + arr.length);
        for (int i = 0; i <= arr.length - 1; i++) {
            int presentNumber = arr[i];
            System.out.println(presentNumber);
        }
        for (int i = 0; i < arr.length; i++) {
            int presentNumber = arr[i];
            System.out.println(presentNumber);
        }
    }
}
