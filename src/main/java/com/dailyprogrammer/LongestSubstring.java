package com.dailyprogrammer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("doeqdoes"));
        System.out.println(longestSubstrings("doeqdoes"));
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int result = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                result = Math.max(result, set.size());
            } else {
                while (i < j) {
                    if (s.charAt(i) == c) {
                        i++;
                        break;
                    }

                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return result;
    }

    // place substrings in a List or TreeSet
    static List<String> longestSubstrings(String string) {
        if (string == null || string.length() == 0) {
            return new ArrayList<>();
        }

        List<String> substrings = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int length = 1;
        int j = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                length = Math.max(length, set.size());
            } else {
                while (j < i) {
                    if (string.charAt(j) == c) {
                        j++;
                        break;
                    }
                    set.remove(string.charAt(j));
                    j++;
                }
            }
        }
        return Collections.unmodifiableList(substrings);
    }
}
