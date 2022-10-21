package org.training.arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int i = 10;
        int[] iArr = new int[]{2, 3, 4, 1, 34, 5, 56};
        int[] iArr1 = new int[]{24, 32, 44, 15, 34, 56, 256};
        int[] iArr2 = new int[]{122, 333, 445, 154, 34312, 51, 562};
        int[][] twoDimArr = new int[][]{iArr, iArr1, iArr2};
        // {{2, 3, 4, 1, 34, 5, 56},{24, 32, 44, 15, 34, 56, 256},{122, 333, 445, 154, 34312, 51, 562}}
        System.out.println(iArr[0]);
        System.out.println(twoDimArr[0][0]);
        System.out.println(twoDimArr[1][2]);
        System.out.println(twoDimArr[2][1]);
        for (int j = 0; j < twoDimArr.length; j++) {
            int[] arr = twoDimArr[j];
            for (int k = 0; k < arr.length; k++) {
                System.out.println(arr[k]);
            }
        }
    }
}
