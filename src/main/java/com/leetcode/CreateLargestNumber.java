package com.leetcode;

import java.util.Arrays;

public class CreateLargestNumber {

    /**
     * Sorts numbers such that if you form a number n by
     * concatenating digits in order a[0]....a[size], it results being the largest
     * number possible.
     * 
     * For example, I/P: {54, 546, 548, 60} O/P: {60, 548, 546, 54}, i.e, 6054854654
     * 
     * I/P: {1, 34, 3, 98, 9, 76, 45, 4} O/P: {9, 98, 76, 45, 4, 34, 3, 1}, i.e,
     * 998764543431
     *
     */

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(arrangeArrayOfNumbersToFormBiggestNumber(new Integer[] { 45, 567, 12, 1 })));
        System.out.println(
                Arrays.toString(arrangeArrayOfNumbersToFormBiggestNumber(new Integer[] { 54, 546, 548, 60 })));
        System.out.println(
                Arrays.toString(arrangeArrayOfNumbersToFormBiggestNumber(new Integer[] { 1, 34, 3, 98, 9, 76, 45, 4 })));
    }

    private static Integer[] arrangeArrayOfNumbersToFormBiggestNumber(Integer[] numbers) {

        Arrays.sort(numbers, (o1, o2) -> 
                Integer.parseInt("" + o1 + o2) >= Integer.parseInt("" + o2 + o1) ? -1 : 1);
        return numbers;
    }
}
