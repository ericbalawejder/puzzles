package com.exercises;

import java.util.function.Supplier;
import java.util.stream.Stream;

class FibonacciEuler {
    public static void main(String... args) {
        System.out.println("The sum of first 17 odd fibonacci numbers is " + fibSum(17));
    }

    static Long fibSum(int fibNumber) {
        Stream<Long> fibStream = Stream.generate(new FibonacciSupplier());

        return fibStream
                .filter(i -> i % 2 != 0)
                .limit(fibNumber)
                .reduce(0L, Long::sum);
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
