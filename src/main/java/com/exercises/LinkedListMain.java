package com.exercises;

public class LinkedListMain {
    public static void main(String...args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(10);
        linkedList.add(9);
        Integer[] list = {8, 7, 6, 5, 4, 3, 2, 1};
        linkedList.addAll(list);
        linkedList.printList();
        linkedList.reverseList();
        linkedList.printList();
    }
}
