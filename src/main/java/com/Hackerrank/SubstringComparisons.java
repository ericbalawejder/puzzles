package com.Hackerrank;

import java.util.SortedSet;
import java.util.TreeSet;

public class SubstringComparisons {

    public static void main(String... args) {

        System.out.println(getSmallestAndLargestLexicographicalSubstring("welcometojava", 3));
    }

    static String getSmallestAndLargestLexicographicalSubstring(String word, int length) {
        SortedSet<String> substrings = new TreeSet<>();

        for (int i = 0; i < word.length() / length; i++) {
            for (int j = i; j <= word.length() - length; j += length) {
                substrings.add(word.substring(j, j + length));
            }
        }
        return substrings.first() + "\n" + substrings.last();
    }
}
