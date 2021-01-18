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

import java.util.Set;
import java.util.TreeSet;

public class SortDigits {

    public static void main(String[] args) {
        System.out.println(sortDigits(549820));
    }

    static Set sortDigits(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Must be a natural number");
        }
        int length = (int) (Math.log10(number) + 1);
        Set<Integer> digits = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            int digit = number % 10;
            number = number / 10;
            if (digit > 0) {
                digits.add(digit);
            }
        }
        return digits;
    }

}
