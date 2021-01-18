package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"apple", "the", "day", "is", "sunny", "the",
                "bill", "the", "the", "sunny", "is", "bill", "the"};

        //System.out.println(topKFrequent(words, 2));
        System.out.println(topKFrequentHeap(words, 5));
    }

    static List<String> topKFrequent(String[] words, int k) {

        final Map<String, Integer> wordCount =
                Arrays.stream(words)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(key -> key, value -> 1, Integer::sum),
                        Collections::unmodifiableMap));

        final List<String> candidates = new ArrayList(wordCount.keySet());
        Collections.sort(candidates, (w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ?
                w1.compareTo(w2) : wordCount.get(w2) - wordCount.get(w1));

        return candidates.subList(0, k);
    }

    static List<String> topKFrequentHeap(String[] words, int k) {

        final Map<String, Integer> wordCount =
                Arrays.stream(words)
                        .collect(Collectors.collectingAndThen(
                                Collectors.toMap(key -> key, value -> 1, Integer::sum),
                                Collections::unmodifiableMap));

        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ?
                        w2.compareTo(w1) : wordCount.get(w1) - wordCount.get(w2));

        for (String word: wordCount.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        List<String> list = new ArrayList();

        while (!heap.isEmpty()) {
            list.add(0, heap.remove());
        }
        return Collections.unmodifiableList(list);
    }
}
