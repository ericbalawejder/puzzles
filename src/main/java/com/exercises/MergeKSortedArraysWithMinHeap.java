package com.exercises;

import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

//https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
class MergeKSortedArraysWithMinHeap {

    public static void main(String... args) {
        int[] array1 = { 1, 3, 5, 17 };
        int[] array2 = { 2, 4, 6, 8 };
        int[] array3 = { 0, 9, 10, 12 };
        int[] array4 = { 11, 19, 20, 31 };

        int[] result = mergeKSortedArrays(new int[][] { array1, array2, array3, array4 });
        System.out.println(Arrays.toString(result));
        System.out.println(findMedian(result));
        System.out.println(result[result.length / 2]);
    }

    static int[] mergeKSortedArrays(int[][] array) {
        PriorityQueue<ArrayContainer> minHeap = new PriorityQueue<ArrayContainer>();
        int numberOfElements = 0;

        for (int i = 0; i < array.length; i++) {
            minHeap.add(new ArrayContainer(array[i], 0));
            numberOfElements += array[i].length;
        }

        int m = 0;
        int result[] = new int[numberOfElements];

        while (!minHeap.isEmpty()) {
            ArrayContainer arrayContainer = minHeap.poll();
            result[m] = arrayContainer.array[arrayContainer.index];
            m++;

            if (arrayContainer.index < arrayContainer.array.length - 1) {
                minHeap.add(new ArrayContainer(arrayContainer.array, arrayContainer.index + 1));
            }
        }
        return result;
    }

    static double findMedian(int[] array) {
        double median = 0;
        if (array.length % 2 == 0) {
            median = (array[(array.length - 1) / 2] + array[array.length / 2]) / 2.0;
        } else {
            median = array[array.length / 2];
        }
        return median;
    }

    private static final class ArrayContainer implements Comparable<ArrayContainer> {
        private int[] array;
        private int index;

        public ArrayContainer(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.array[this.index] - o.array[o.index];
        }
    }
}
