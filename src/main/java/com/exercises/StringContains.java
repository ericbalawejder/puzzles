package com.exercises;

import java.util.Arrays;
import java.util.List;

public class StringContains {

    public static void main(String[] args) {
        System.out.println(contains("The quick brown fox.", List.of("brown", "the")));
        System.out.println(containsCharacter("abcd efgh ijkxxcb hgs", 'g'));
    }

    static boolean contains(String input, List<String> words) {
        final List<String> inputList = Arrays.asList(input.toLowerCase().split(" "));
        return inputList.containsAll(words);
    }

    static boolean containsCharacter(String string, Character character) {
        return string.toLowerCase()
                .replaceAll(" ", "")
                .chars()
                .mapToObj(c -> (char) c)
                .anyMatch(c -> c.equals(character));
    }
}
