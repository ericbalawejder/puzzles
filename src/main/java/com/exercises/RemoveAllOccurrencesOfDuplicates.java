package com.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Map;

public class RemoveAllOccurrencesOfDuplicates {
    public static void main(String... args) {

        List<String> countries = new ArrayList<>(Arrays.asList(
                "USA", "Columbia", "Japan", "Canada", "USA", "USA", "Japan", "Hati", "Brazil"));
        System.out.println(countWords(countries));
        System.out.println(removeAllDuplicates(countries));
    }

    static List<String> removeAllDuplicates(List<String> list) {
        return countWords(list)
                .entrySet()
                .stream()
                .filter(key -> key.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());

    }

    private static Map<String, Integer> countWords(List<String> list) {
        return list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(key -> key, value -> 1, Integer::sum),
                        Collections::unmodifiableMap));
    }

}
