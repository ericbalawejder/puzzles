package com.exercises;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fib(7));
    }

    static long fibonacci(int n) {

        Map<Integer, Long> fibonacciValues = new HashMap<>();

        if (n < 1) {
            throw new IllegalArgumentException("Natural numbers only.");
        } else if (n <= 2) {
            return 1;
        } else if (fibonacciValues.containsKey(n)) {
            return fibonacciValues.get(n);
        } else {
            Long value = fibonacci(n - 1) + fibonacci(n - 2);
            fibonacciValues.put(n, value);
            // System.out.println(fibonacciValues);
            return value;
        }
    }

    static long fib(int n) {

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
            //System.out.println(prevPrev + " " + prev + " " + current);
        }
        return current;
    }

}
