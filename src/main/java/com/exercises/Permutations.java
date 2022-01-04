package com.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Limited by int data type size for factorial().
 */
public class Permutations {

    public static void main(String[] args) {
        final List<String> words = List.of(
                "motion", "axis", "works", "R", "project");

        System.out.println(findPermutations(words));
    }

    public static <T> List<List<T>> findPermutations(final List<T> items) {
        return IntStream.range(0, factorial(items.size()))
                .mapToObj(i -> permutation(i, items))
                //.flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());
    }

    public static <T> Stream<Stream<T>> of(final List<T> items) {
        return IntStream.range(0, factorial(items.size()))
                .mapToObj(i -> permutation(i, items).stream());
    }

    private static int factorial(final int num) {
        return IntStream.rangeClosed(2, num)
                .reduce(1, Math::multiplyExact);
    }

    private static <T> List<T> permutation(final int count, final List<T> items) {
        return permutation(count, new LinkedList<>(items), new ArrayList<>());
    }

    private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
        if (input.isEmpty()) return output;

        final int factorial = factorial(input.size() - 1);
        //int index = count / factorial;
        output.add(input.remove(count / factorial));
        return permutation(count % factorial, input, output);
    }

}
