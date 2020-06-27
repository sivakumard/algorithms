package com.cisan.data_structure.array;

import java.util.Arrays;

public class RotateArray {
    //rotate one by one
    private void leftRotate(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            int j, temp;
            temp = arr[0];
            for (j = 0; j < n - 1; j++)
                arr[j] = arr[j + 1];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }

    //Rotate by gcd (A Juggling Algorithm)
    private void leftRotate1(int[] arr, int d) {
        int n = arr.length;
        int j, k, temp;
        int gcd = gcd(n, d);
        for (int i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = (j + d) >= n ? j + d - n : j + d;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        System.out.println(gcd + " : " + Arrays.toString(arr));

    }

    int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    //Reverse array

    private void leftRotate2(int[] arr, int d) {
        int n = arr.length;
        rotateArray(arr, 0, d - 1);
        rotateArray(arr, d, n - 1);
        rotateArray(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

    }

    void rotateArray(int[] arr, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().leftRotate(arr, 4);
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().leftRotate1(arr1, 4);

        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().leftRotate2(arr2, 4);

    }


}
