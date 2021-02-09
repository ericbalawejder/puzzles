package com.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeArrays {

    public static void main(String[] args) {
        List<Integer> powerOfTwo = List.of(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);

        List<Integer> primes =
                List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67);

        List<Integer> cubes = List.of(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728);

        List<Integer> treesNUnlabeledNodes =
                List.of(1, 1, 1, 1, 2, 3, 6, 11, 23, 47, 106, 235, 551, 1301, 3159, 7741, 19320, 48629);

        System.out.println(mergeSortedListsIterative(primes, cubes, powerOfTwo));

        System.out.println(mergeSortedLists(primes, powerOfTwo, cubes, treesNUnlabeledNodes));

        System.out.println(mergeSortedListsGeneric(primes, powerOfTwo, cubes));
    }

    @SafeVarargs
    private static <T> List<T> mergeSortedListsGeneric(List<T>... lists) {
        final List<List<T>> values = List.of(lists);

        final Queue<T> minHeap = values.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(PriorityQueue::new));

        return IntStream.range(0, minHeap.size())
                .mapToObj(i -> minHeap.poll())
                .collect(Collectors.toUnmodifiableList());
    }

    // https://docs.oracle.com/javase/7/docs/api/java/lang/SafeVarargs.html
    // @SafeVarargs. Method only consumes the elements of the array and does not
    // (and never will) produce elements to put into the array
    @SafeVarargs
    private static List<Integer> mergeSortedLists(List<Integer>... lists) {
        final List<List<Integer>> values = List.of(lists);

        final Queue<Integer> minHeap = values.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(PriorityQueue::new));

        return IntStream.range(0, minHeap.size())
                .map(i -> minHeap.poll())
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Integer> mergeSortedListsIterative(
            List<Integer> primes, List<Integer> powerOfTwo, List<Integer> cubes) {

        final List<List<Integer>> values = List.of(primes, powerOfTwo, cubes);
        final Queue<Integer> minHeap = new PriorityQueue<>();
        for (List<Integer> list : values) {
            minHeap.addAll(list);
        }
        final List<Integer> sorted = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            sorted.add(minHeap.poll());
        }
        return List.copyOf(sorted);
    }

}
