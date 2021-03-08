package com.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertNull(challenge.findFirstNonRepeatingCharacter("toot"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterCaseSensitive() {
        assertNotEquals(Character.valueOf('S'), challenge.findFirstNonRepeatingCharacter("Sensitive"));
    }

    @Test
    public void testFindFirstNonRepeatedCharacterCaseInsensitive() {
        assertEquals(Character.valueOf('n'), challenge.findFirstNonRepeatingCharacter("Sensitive"));
    }

}
