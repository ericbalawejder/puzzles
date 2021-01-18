package com.interviewcake;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Delimiter {

    public static void main(String... args) {
        String delimiterSequence = "di k76 ( gh [ dd222 { (()) }])";
        String delimiterSequence2 = "{{[([{[()]}])]}}";
        System.out.println(isValid(delimiterSequence));
        System.out.println(isValid(delimiterSequence2));
    }

    public static boolean isValid(String input) {

        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());
        Deque<Character> openersStack = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openersStack.isEmpty();
    }
}
