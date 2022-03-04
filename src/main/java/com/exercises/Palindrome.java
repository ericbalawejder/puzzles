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
        System.out.println(palindrome.isPalindrome(123454321));
        System.out.println(palindrome.reverseNumber(1534236469));
    }

    boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    List<String> findAllPalindromes(String word) {
        final List<String> palindromes = new ArrayList<>();
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
        final Set<Character> unpairedCharacters = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }
        return unpairedCharacters.size() <= 1;
    }

    boolean isPalindrome(long number) {
        return number == reverseNumber(number);
    }

    private long reverseNumber(long number) {
        long reversedNumber = 0L;
        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        }
        return reversedNumber;
    }

    private int reverseNumber(int n) {
        int number = n;
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        }
        return reversedNumber;
    }

}
