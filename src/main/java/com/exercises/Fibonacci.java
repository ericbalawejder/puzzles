package com.exercises;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer, Long> fibonacciValues = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibonacciMemoization(40));
        System.out.println(fibonacci(40));
        System.out.println(fibBottomUp(40));
    }

    static long fibonacciMemoization(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Natural numbers only.");
        } else if (n <= 2) {
            return 1;
        } else if (fibonacciValues.containsKey(n)) {
            return fibonacciValues.get(n);
        } else {
            long value = fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2);
            fibonacciValues.put(n, value);
            return value;
        }
    }

    static long fibonacci(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Natural numbers only.");
        } else if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static long fibBottomUp(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Natural numbers only.");
        } else if (n <= 2) {
            return 1;
        }
        // we'll be building the fibonacci series from the bottom up
        // so we'll need to track the previous 2 numbers at each step
        long prevPrev = 0; // 0th fibonacci
        long prev = 1; // 1st fibonacci
        long current = 0; // Declare and initialize current

        for (int i = 1; i < n; i++) {

            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        return current;
    }

}
