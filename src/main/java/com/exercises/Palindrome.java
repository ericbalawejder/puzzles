package com.exercises;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Palindrome {

    public static void main(String... args) {
        Palindrome palindrome = new Palindrome();

        System.out.println(palindrome.isPalindrome("racecar"));

        System.out.println(palindrome.findAllPalindromes("mommom"));

        System.out.println(palindrome.hasPalindromePermutation("civci"));
    }

    boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    List<String> findAllPalindromes(String word) {
        List<String> palindromes = new ArrayList<>();

        for (int i = 0; i < word.length() - 2; i++) {
            for (int j = i + 3; j <= word.length(); j++) {
                if (isPalindrome(word.substring(i, j))) {
                    palindromes.add(word.substring(i, j));
                }
            }
        }
        return palindromes;
    }

    boolean hasPalindromePermutation(String word) {
        Set<Character> unpairedCharacters = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }
        return unpairedCharacters.size() <= 1;
    }

}
