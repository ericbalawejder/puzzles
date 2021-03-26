package com.exercises;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {

    public static void main(String[] args) {
        final String characters = "aaaaabbbbbbbccdddefffghhhiijjjjjjkkkkkkz";
        System.out.println(countCharacters(characters));
    }

    static Map<Character, Integer> countCharacters(String characters) {
        return characters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        TreeMap::new,
                        Collectors.reducing(0, e -> 1, Integer::sum)));
    }

}
