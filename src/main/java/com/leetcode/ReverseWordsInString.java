package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsInString {

    public static void main(String[] args) {
        //System.out.println(reverse("Hello how are you today?"));
    }

    /*
    static String reverse(String sentence) {
        String[] words = sentence.split(" ");
        List<String> list = Arrays.asList(words);
        return list.stream()
                .mapToInt()
                .map(ReverseWordsInString::reverse)
                .collect(Collectors.joining(" "));
    }
    */

    static IntStream reverseRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    }
}
