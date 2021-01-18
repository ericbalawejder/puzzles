package com.exercises;

//Merge two sorted arrays.
public class MergeSortedArrays {

    public static void main(String... args) {
        int[] powerOfTwo = { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67 };

        print(merge(powerOfTwo, primes));
    }

    public static int[] merge(int[] array1, int[] array2) {
        int mergedArraySize = array1.length + array2.length;
        int[] mergedArray = new int[mergedArraySize];
        int array1Index = 0;
        int array2Index = 0;
        int mergedArrayIndex = 0;

        while (mergedArrayIndex < mergedArraySize) {
            boolean isArray1Exhausted = array1Index >= array1.length;
            boolean isArray2Exhausted = array2Index >= array2.length;

            if (!isArray1Exhausted && (isArray2Exhausted || array1[array1Index] < array2[array2Index])) {
                mergedArray[mergedArrayIndex] = array1[array1Index];
                array1Index += 1;
            } else {
                mergedArray[mergedArrayIndex] = array2[array2Index];
                array2Index += 1;
            }
            mergedArrayIndex += 1;
        }
        return mergedArray;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
