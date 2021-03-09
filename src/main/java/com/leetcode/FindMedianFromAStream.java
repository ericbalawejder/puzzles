package com.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class FindMedianFromAStream {

    final Queue<Integer> minHeap = new PriorityQueue<>();
    final Queue<Integer> maxHeap = new PriorityQueue<>(11, Comparator.reverseOrder());

    public static void main(String[] args) {
        final FindMedianFromAStream findMedianFromAStream = new FindMedianFromAStream();
        final List<Integer> numbers = List.of(4, 5, 9, 23, 1, 3, 8, 0);

        numbers.forEach(findMedianFromAStream::addNum);

        System.out.println(findMedianFromAStream.findMedian());
    }

    void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    double findMedian() {
        if (minHeap.peek() == null || maxHeap.peek() == null) {
            throw new RuntimeException("heap is empty. input must be > 1");
        }
        if (minHeap.size() == maxHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return (double) maxHeap.peek();
        }
    }

    Queue<Integer> getMinHeap() {
        return minHeap;
    }

    Queue<Integer> getMaxHeap() {
        return maxHeap;
    }

}
