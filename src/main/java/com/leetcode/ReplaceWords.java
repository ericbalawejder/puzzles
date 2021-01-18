package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/replace-words/
 * 
 * Input: dict = ["cat", "bat", "rat"] 
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 */

class ReplaceWords {

    public static void main(String... args) {
        System.out.println(replaceWords(new ArrayList<String>(Arrays.asList("cat", "bat", "rat")),
                "the cattle was rattled by the battery"));

        System.out.println(replaceWordsWithTrie(new ArrayList<String>(Arrays.asList("cat", "bat", "rat")),
                "the cattle was rattled by the battery"));
    }

    static String replaceWords(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet<>();
        for (String root : roots)
            rootset.add(root);

        StringBuilder answer = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) {
                    break;
                }

            }
            if (answer.length() > 0) {
                answer.append(" ");
            }
            answer.append(prefix);
        }
        return answer.toString();
    }

    static String replaceWordsWithTrie(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : roots) {
            TrieNode current = trie;
            for (char letter : root.toCharArray()) {
                if (current.children[letter - 'a'] == null) {
                    current.children[letter - 'a'] = new TrieNode();
                }
                current = current.children[letter - 'a'];
            }
            current.word = root;
        }

        StringBuilder answer = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (answer.length() > 0) {
                answer.append(" ");
            }

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[letter - 'a'];
            }
            answer.append(cur.word != null ? cur.word : word);
        }
        return answer.toString();
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

}
