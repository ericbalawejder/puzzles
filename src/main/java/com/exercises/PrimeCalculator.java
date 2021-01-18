package com.exercises;

import java.util.stream.IntStream;
import static java.util.stream.IntStream.iterate;

//Given a number n, determine what the nth prime is.
class PrimeCalculator {
    public static void main(String... args) {
        PrimeCalculator primeCalculator = new PrimeCalculator();
        System.out.println(primeCalculator.nthPrime(10000));
    }

    int nthPrime(int nth) {
        return iterate(2, i -> i + 1)
                .filter(this::isPrime)
                .limit(nth)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isPrime(int number) {
        if (number <= 1) throw new IllegalArgumentException("Number must be larger than 1.");
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        return IntStream.iterate(3, n -> n <= (int) Math.sqrt(number), n -> n + 2)
                .noneMatch(n -> number % n == 0);
    }

    private boolean isPrime2(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }

    // create 9 and 3
    private boolean isDigitalRootOf3(int number) {
        int digit;
        int sum = 0;
        int value = number;
        for (int i = 0; i < Math.log10(number) + 1; i ++) {
            digit = Math.floorMod(value, 10);
            sum += digit;
            value /= 10;
        }
        return Math.floorMod(sum, 3) == 0;
    }

}
