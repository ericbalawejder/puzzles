package com.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringTree {

    public static void main(String[] args) {
        /* Create String A out of substrings of String B. 
           Return the minimum number of copies that you need to do this.

        Example:

        A="zaza", B="baz"

        copy1="z"
        copy2="az"
        copy3="a
        A=copy1+copy2+copy3

        Returns 3
        */
    }

    private static int numCopies(String a, String b) {
        Set<String> bSubStrings = substrings(a, b);

        List<String> sortedBSubStrings = new ArrayList<>(bSubStrings.size());
        sortedBSubStrings.addAll(bSubStrings);
        Collections.sort(sortedBSubStrings, (o1, o2) -> Integer.compare(o2.length(), o1.length())); // longest substring
                                                                                                    // comes first

        return numCopies(a, sortedBSubStrings, 0);
    }

    private static int numCopies(String a, List<String> bSubStrings, int copies) {
        if (a.equals("")) {
            return copies;
        }

        int resultCopies = 0;

        for (String bSubString : bSubStrings) {
            int indexOfB = a.indexOf(bSubString);
            if (indexOfB != -1) {
                // remove B substring from String A
                String aRemaining = a.substring(0, indexOfB) + a.substring(indexOfB + bSubString.length());
                resultCopies = numCopies(aRemaining, bSubStrings, copies + 1);

                if (resultCopies > 0) {
                    return resultCopies;
                }
            }
        }
        return resultCopies;
    }

    // build all substrings of B which are contained in A
    private static Set<String> substrings(String a, String b) {
        Set<String> substrings = new HashSet<>();

        for (int i = 0; i < b.length(); i++) {
            for (int j = i; j < b.length(); j++) {
                String substring = b.substring(i, j + 1);
                if (a.contains(substring)) {
                    substrings.add(substring);
                }
            }
        }
        return substrings;
    }

}
