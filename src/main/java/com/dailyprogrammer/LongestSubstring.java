package com.dailyprogrammer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("doeqdoes"));
        System.out.println(longestSubstrings("aba"));
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int length = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                length = Math.max(length, set.size());
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
        return length;
    }

    static String longestSubstrings(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        final Set<Character> set = new HashSet<>();
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
        return string.substring(j, j + length);
    }

    int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        int ans = 0;
        final Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    int lengthOfLongestSubstringSlidingWindow(String string) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < string.length()) {
            char r = string.charAt(right);
            chars[r]++;
            while (chars[r] > 1) {
                char l = string.charAt(left);
                chars[l]--;
                left++;
            }
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }

    int lengthOfLongestSubstringBruteForce(String string) {
        final int n = string.length();
        int length = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isRepetition(string, i, j)) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return length;
    }

    private boolean isRepetition(String string, int start, int end) {
        int[] chars = new int[128];
        for (int i = start; i <= end; i++) {
            char c = string.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }

}
