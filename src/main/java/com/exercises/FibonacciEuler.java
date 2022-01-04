package com.exercises;

import java.util.function.Supplier;
import java.util.stream.Stream;

class FibonacciEuler {
    public static void main(String... args) {
        System.out.println("The sum of first 17 odd fibonacci numbers is " + fibSum(17));
        System.out.println(fibonacciNumber(4));
    }

    static Long fibSum(int fibNumber) {
        return Stream.generate(new FibonacciSupplier())
                .filter(i -> i % 2 != 0)
                .limit(fibNumber)
                .reduce(0L, Long::sum);
    }

    static long fibonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Stream.generate(new FibonacciSupplier())
                .limit(n - 1)
                .reduce((fib1, fib2) -> fib2)
                .orElse(0L);
    }

    private static class FibonacciSupplier implements Supplier<Long> {
        private long a = 0;
        private long b = 1;

        @Override
        public Long get() {
            long next = a + b;
            a = b;
            b = next;
            return next;
        }

    }

}
