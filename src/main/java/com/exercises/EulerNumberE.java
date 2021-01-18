package com.exercises;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
https://en.wikipedia.org/wiki/E_(mathematical_constant)

Google was also responsible for a billboard[42] that appeared in the heart of Silicon Valley,
and later in Cambridge, Massachusetts; Seattle, Washington; and Austin, Texas.
It read "{first 10-digit prime found in consecutive digits of e}.com". The first 10-digit prime
in e is 7427466391, which starts at the 99th digit.[43] Solving this problem and visiting the
advertised (now defunct) website led to an even more difficult problem to solve, which consisted
in finding the fifth term in the sequence 7182818284, 8182845904, 8747135266, 7427466391.
It turned out that the sequence consisted of 10-digit numbers found in consecutive digits of e
whose digits summed to 49. The fifth term in the sequence is 5966290435, which starts at the 127th
digit. [44] Solving this second problem finally led to a Google Labs webpage where the visitor was
invited to submit a résumé.[45]
 */

public class EulerNumberE {

    public static void main(String[] args) throws IOException {
        // Import the expansion from The Online Encyclopedia of Integer Sequences.
        // https://oeis.org/A001113
        final String data = readFile("src/main/java/com/exercises/expansionOfE.txt");

        // Find the first contiguous substring that is prime.
        System.out.println(contiguousSubstringIsPrime(data));

        // Given a sequence of terms, find the next term.
        final List<String> sequence = List.of("7182818284", "8182845904", "8747135266", "7427466391");

        // By visual inspection, the first three values are not prime. Check the forth.
        sequence.forEach(i -> System.out.println(isPrime(Long.parseLong(i))));

        // Check the sum of each sequence. All 49.
        sequence.forEach(i -> System.out.println(sumSequence(i)));

        // Check for the fifth contiguous substring, not necessarily prime, that sums to 49.
        System.out.println(contiguousSubstringSum(data, 49));
    }

    static List<String> contiguousSubstringSum(String sequence, int sum) {
        return IntStream.iterate(0, i -> i <= sequence.length() - 10, i -> i + 1)
                .filter(i -> sumSequence(sequence.substring(i, i + 10)) == sum)
                .mapToObj(i -> sequence.substring(i, i + 10))
                .limit(5)
                .collect(Collectors.toUnmodifiableList());
    }

    static Optional<String> contiguousSubstringIsPrime(String sequence) {
        return IntStream.iterate(0, i -> i <= sequence.length() - 10, i -> i + 1)
                .filter(i -> isPrime(Long.parseLong(sequence.substring(i, i + 10))))
                .mapToObj(i -> sequence.substring(i, i + 10))
                .findFirst();
    }

    static int sumSequence(String sequence) {
        return IntStream.range(0, sequence.length())
                .mapToObj(sequence::charAt)
                .map(String::valueOf)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private static boolean isPrime(long number) {
        if (number <= 1) throw new IllegalArgumentException("Number must be >= 1");
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        return Stream.iterate(3, i -> i <= (long) Math.sqrt(number), i -> i + 2)
                .noneMatch(n -> number % n == 0);
    }

    // TODO This is inaccurate for given MathContext.
    // e = Sum_{k = 0...N} 1/k! = lim_{x -> 0} (1+x)^(1/x).
    private static BigDecimal calculateE(int summationBound) {
        final MathContext mathContext = new MathContext(100, RoundingMode.HALF_UP);
        return IntStream.rangeClosed(0, summationBound)
                .mapToObj(BigDecimal::new)
                .map(i -> BigDecimal.ONE.divide(factorial(i), mathContext))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }

    private static String readFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.map(String::valueOf)
                    .map(i -> i.substring(i.length() - 1))
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static List<Integer> readFileToList(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.map(String::valueOf)
                    .map(i -> i.substring(i.length() - 1))
                    .map(Integer::parseInt)
                    .collect(Collectors.toUnmodifiableList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
