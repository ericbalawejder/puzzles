package com.exercises;

import java.math.BigDecimal;
import java.util.stream.LongStream;

class Factorial {

    public static void main(String... args) {
        System.out.println(factorial(10));
        System.out.println(factorialStream(10));
    }

    static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("input must be greater or equal to 0");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static long factorialStream(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("input must be greater or equal to 0");
        } else if (n == 0) {
            return 1;
        } else {
            return LongStream.rangeClosed(2, n)
                    .reduce(1, Math::multiplyExact);
        }
    }

    private static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }

}
