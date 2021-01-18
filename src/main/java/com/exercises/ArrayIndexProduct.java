package com.exercises;

import java.util.Arrays;

public class ArrayIndexProduct {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int totalMultiplication = 1;
        for (int j : arr) {
            totalMultiplication *= j;
        }

        int[] finalArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            finalArr[i] = totalMultiplication / arr[i];
        }

        System.out.println(Arrays.toString(finalArr));

        // Extension: Do not use division.
        finalArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = totalMultiplication;
            int val = arr[i];
            int count = 0;
            while (temp - val >= 0) {
                count++;
                temp -= val;
            }
            finalArr[i] = count;
        }
        System.out.println(Arrays.toString(finalArr));
    }
}
