package com.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyList {
    public static void main(String[] args) {
        final List<String> characters = List.of("t", "a", "t", "b", "b", "b",
                "t", "t", "c", "c", "t", "c");

        final List<String> words = generateInput(1000);

        System.out.println(frequencyList(characters));
        System.out.println(frequencyList(words));
        System.out.println(frequencyListHeap(words));
        System.out.println(frequencyListTreeMap(words));
    }

    static List<Map.Entry<String, Integer>> frequencyList(List<String> words) {
        final Map<String, Integer> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, value -> 1, Integer::sum)));

        final Comparator<Map.Entry<String, Integer>> frequencyThenLexicographicOrder =
                (w1, w2) -> w1.getValue().equals(w2.getValue()) ?
                        w1.getKey().compareTo(w2.getKey()) :
                        Integer.compare(w2.getValue(), w1.getValue());

        return wordCount.entrySet()
                .stream()
                .sorted(frequencyThenLexicographicOrder)
                .collect(Collectors.toUnmodifiableList());
    }

    static List<String> frequencyListHeap(List<String> words) {
        final Map<String, Integer> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.reducing(0, value -> 1, Integer::sum)));

        final Comparator<String> frequencyByLexicographicOrder =
                (w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ?
                        w1.compareTo(w2) : Integer.compare(wordCount.get(w2), wordCount.get(w1));

        final Queue<String> maxHeap = wordCount.keySet()
                .stream()
                .collect(Collectors.toCollection(
                        () -> new PriorityQueue<>(frequencyByLexicographicOrder)));

        return IntStream.range(0, maxHeap.size())
                .mapToObj(i -> maxHeap.remove())
                .map(s -> s.concat("=" + wordCount.get(s)))
                .collect(Collectors.toUnmodifiableList());
    }


    static Map<String, Integer> frequencyListTreeMap(List<String> words) {
        final Comparator<Map.Entry<String, Integer>> frequencyThenLexicographicOrder =
                (w1, w2) -> w1.getValue().equals(w2.getValue()) ?
                        w1.getKey().compareTo(w2.getKey()) :
                        Integer.compare(w2.getValue(), w1.getValue());

        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        () -> new TreeMap<>(),
                        Collectors.reducing(0, value -> 1, Integer::sum)));
    }

    private static List<String> generateInput(int length) {
        final List<String> words = List.of("abc", "def", "ghi", "jkl", "mno", "pqr");

        return IntStream.range(0, length)
                .mapToObj(i -> words.get((int) (words.size() * Math.random())))
                .collect(Collectors.toUnmodifiableList());
    }

}
