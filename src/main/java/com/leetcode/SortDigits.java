package com.leetcode;

//* Sort Digits
//*
//* Given an integer, sort the digits in ascending order and return the new integer.
//* Ignore leading zeros.
//*
//* Parameters
//* Input: num {Integer}
//* Output: {Integer}
//*
//* Constraints
//* Do not convert the integer into a string or other data type.
//*
//* Time: O(N) where N is the number of digits.
//* Space: O(1)
//*
//* Examples
//* 8970 --> 789
//* 32445 --> 23445
//* 10101 --> 111

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortDigits {

    public static void main(String[] args) {
        System.out.println(sortDigits(5498202390044L));
    }

    static long sortDigits(long value) {
        if (value == 0) {
            throw new IllegalArgumentException("Must be a natural number");
        }
        final int length = (int) (Math.log10(value) + 1);
        final Queue<Integer> minHeap = new PriorityQueue<>();
        long number = value;
        for (int i = 0; i < length; i++) {
            int digit = (int) (number % 10);
            number /= 10;
            if (digit > 0) {
                minHeap.add(digit);
            }
        }
        final String sortedNumber = IntStream.range(0, minHeap.size())
                .map(i -> minHeap.poll())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return Long.parseLong(sortedNumber);
    }

}
