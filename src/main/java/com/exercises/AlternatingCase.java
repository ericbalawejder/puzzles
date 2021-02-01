package com.exercises;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlternatingCase {

    public static void main(String[] args) {
        System.out.println(getAlternatingCaps("Hard work leads to success."));
    }

    // https://www.urbandictionary.com/define.php?term=aLtErNaTiNg%20CaPs
    static String getAlternatingCaps(String sentence) {
        return IntStream.range(0, sentence.length())
                .mapToObj(i -> String.valueOf(i % 2 == 1 ? sentence.charAt(i) :
                        Character.toUpperCase(sentence.charAt(i))))
                .collect(Collectors.joining());
    }

}
