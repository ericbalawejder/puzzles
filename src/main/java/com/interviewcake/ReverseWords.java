package com.interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWords {

    public static void main(String[] args) {
        final char[] message = { 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' };

        System.out.println(reverseWords(message));
    }

    static String reverseWords(char[] characters) {
        final String words = IntStream.range(0, characters.length)
                .mapToObj(i -> characters[i])
                .map(String::valueOf)
                .collect(Collectors.joining());

        final List<String> wordList = Arrays.asList(words.split(" "));

        final List<String> reversed = IntStream.range(0, wordList.size())
                .mapToObj(i -> wordList.get(wordList.size() - 1 - i))
                .collect(Collectors.toCollection(ArrayList::new));

        return String.join(" ", reversed);
    }

}
