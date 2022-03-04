package com.graph;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class HasPath {

    private static final Map<Character, Set<Character>> GRAPH = Map.of(
            'f', Set.of('g', 'i'),
            'g', Set.of('h'),
            'h', Set.of('k'),
            'i', Set.of('g', 'k'),
            'j', Set.of('i'),
            'k', Set.of('k')
    );

    public static void main(String[] args) {
        System.out.println(hasPath(GRAPH, 'h', 'k'));
        System.out.println(hasPathRecursive(GRAPH, 'h', 'k'));
    }

    static boolean hasPath(Map<Character, Set<Character>> graph, char source, char destination) {
        final Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            final Character currentNode = stack.pop();
            if (currentNode == destination) {
                return true;
            }
            for (Character neighbor : graph.get(currentNode)) {
                stack.push(neighbor);
            }
        }
        return false;
    }

    static boolean hasPathRecursive(Map<Character, Set<Character>> graph, char source, char destination) {
        if (source == destination) return true;
        for (Character neighbor : graph.get(source)) {
            if (hasPathRecursive(graph, neighbor, destination)) {
                return true;
            }
        }
        return false;
    }

}
