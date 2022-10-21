package org.training.arrays;

public class ThreeDimensionalArray {
    public static void main(String[] args) {
        int i = 10;
        int[] iArr = new int[]{2, 3, 4, 1, 34, 5, 56};
        int[] iArr1 = new int[]{24, 32, 44, 15, 34, 56, 256};
        int[] iArr2 = new int[]{122, 333, 445, 154, 34312, 51, 562};
        int[][] twoDimArr = new int[][]{iArr, iArr1, iArr2};
        int[][] twoDimArr2 = new int[][]{iArr, iArr1, iArr2};
        int[][] twoDimArr3 = new int[][]{iArr, iArr1, iArr2};
        int[][][] threeDimArr = new int[][][]{twoDimArr3, twoDimArr2, twoDimArr};
        // {{2, 3, 4, 1, 34, 5, 56},{24, 32, 44, 15, 34, 56, 256},{122, 333, 445, 154, 34312, 51, 562}}
        System.out.println(threeDimArr[0][0][0]);
        System.out.println(threeDimArr[1][2][2]);
        System.out.println(threeDimArr[2][1][3]);
        for (int l = 0; l < threeDimArr.length; l++) {
            int[][] twoDimArrEx = threeDimArr[l];
            for (int j = 0; j < twoDimArrEx.length; j++) {
                int[] arr = twoDimArrEx[j];
                for (int k = 0; k < arr.length; k++) {
                    System.out.println(arr[k]);
                }
            }
        }
    }
}
