package com.Hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestions {

    public static void main(String[] args) {
        final List<String> repository = List.of("mobile", "mouse", "moneypot", "monitor", "mousepad");
        System.out.println(searchSuggestions(repository, "mouse"));
    }

    static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        final List<List<String>> results = new ArrayList<>();

        final List<String> sortedRepository = repository.stream()
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toUnmodifiableList());

        for (int i = 2; i <= customerQuery.length(); i++) {
            String tempQuery = customerQuery.substring(0, i).toLowerCase();
            final List<String> singlePassResult = new ArrayList<>();
            for (String word : sortedRepository) {
                if (word.startsWith(tempQuery) && singlePassResult.size() < 3) {
                    singlePassResult.add(word);
                }
            }
            results.add(singlePassResult);
        }
        return List.copyOf(results);
    }

}
