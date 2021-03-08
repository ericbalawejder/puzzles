package com.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
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
        return word.chars()
                .mapToObj(i -> (char) i)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new,
                        Collectors.reducing(0, e -> 1, Integer::sum)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

}
