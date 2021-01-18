package com.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * Given a String find the first occurrence of a non-repeated character.
 *
 * For example:
 *
 * airplane -> 'i'
 * llama -> 'm'
 * toot -> null
 *
 * See ComcastChallengeTest file for implementation.
 */

public class ComcastChallenge {

    public Character findFirstNonRepeatingCharacter(String word) {

        Set<Character> repeatingCharacters = new HashSet<>();
        List<Character> nonRepeatingCharacters = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (nonRepeatingCharacters.contains(character)) {
                nonRepeatingCharacters.remove(character);
                repeatingCharacters.add(character);
            } else {
                nonRepeatingCharacters.add(character);
            }
        }
        return nonRepeatingCharacters.size() == 0 ? null : nonRepeatingCharacters.get(0);
    }

    // A better solution is to return an empty collection or an empty Optional rather than null.
    public Optional<Character> findFirstNonRepeatingCharacterOptional(String word) {
        return word.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();
    }

}
