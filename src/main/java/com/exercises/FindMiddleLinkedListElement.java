package com.exercises;

// https://www.javacodegeeks.com/2019/03/middle-element-linked-list-java-single-pass.html
public class FindMiddleLinkedListElement {

    private Node head;
    private Node tail;

    public static void main(String[] args) {
        // Creating LinkedList with 5 elements including head
        FindMiddleLinkedListElement linkedList = new FindMiddleLinkedListElement();
        linkedList.add(new Node("9"));
        linkedList.add(new Node("81"));
        linkedList.add(new Node("31"));
        linkedList.add(new Node("44"));
        linkedList.add(new Node("111"));
        linkedList.add(new Node("2"));

        linkedList.printList();

        // finding middle element of LinkedList in single pass
        Node current = linkedList.getHead();
        Node middle = linkedList.getHead();
        int length = 0;

        while (current.next() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }

        if (length % 2 == 1) {
            middle = middle.next();
        }

        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);
    }

    public FindMiddleLinkedListElement() {
        this.head = new Node("head");
        tail = head;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;

        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static final class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }
    }

}
