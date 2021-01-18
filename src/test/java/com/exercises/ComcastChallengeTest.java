package com.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComcastChallengeTest {

    private ComcastChallenge challenge;

    @BeforeEach
    void setup() {
        challenge = new ComcastChallenge();
    }

    @Test
    public void testFindFirstNonRepeatedCharacterAirplane() {
        assertEquals(Character.valueOf('i'), challenge.findFirstNonRepeatingCharacter("airplane"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterLlama() {
        assertEquals(Character.valueOf('m'), challenge.findFirstNonRepeatingCharacter("llama"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterToot() {
        assertEquals(null, challenge.findFirstNonRepeatingCharacter("toot"));
    }

    // Case insensitivity is NOT implemented

    // This will pass.
    @Test
    public void testFindFirstNonRepeatedCharacterCaseSensitive() {
        assertEquals(Character.valueOf('S'), challenge.findFirstNonRepeatingCharacter("Sensitive"));
    }

    // This will fail.
    @Disabled
    @Test
    public void testFindFirstNonRepeatedCharacterCaseInsensitive() {
        assertEquals(Character.valueOf('n'), challenge.findFirstNonRepeatingCharacter("Sensitive"));
    }

    //--------------------------------------------------------------------------------------------------
    // Optional<Character> implementation tests.

    @Test
    public void testFindFirstNonRepeatedCharacterOptionalAirplane() {
        assertEquals(Optional.of('i'), challenge.findFirstNonRepeatingCharacterOptional("airplane"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterOptionalLlama() {
        assertEquals(Optional.of('m'), challenge.findFirstNonRepeatingCharacterOptional("llama"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterOptionalToot() {
        assertEquals(Optional.empty(), challenge.findFirstNonRepeatingCharacterOptional("toot"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterOptionalCaseSensitive() {
        assertEquals(Optional.of('S'), challenge.findFirstNonRepeatingCharacterOptional("Sensitive"));
    }

    @Disabled
    @Test
    public void testFindFirstNonRepeatedCharacterOptionalCaseInsensitive() {
        assertEquals(Optional.of('n'), challenge.findFirstNonRepeatingCharacterOptional("Sensitive"));
    }

}
