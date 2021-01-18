package com.exercises;

public class LinkedList<E> {

    protected Node<E> head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(E[] list) {
        this();
        addAll(list);
    }

    public void addAll(E[] list) {
        for (int i = 0; i < list.length; i++)
            add(list[i]);
    }

    public void add(E e) {
        if (head == null) {
            head = new Node<E>(e);
        } else {
            Node<E> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(e);
        }
    }

    public void reverseList() {
        Node<E> current = head;
        Node<E> previous = null;
        Node<E> incoming = null;

        while (current != null) {
            incoming = current.next; // store incoming item

            current.next = previous; // swap nodes
            previous = current; // increment also previous

            current = incoming; // increment current
        }
        head = previous; // previous is the latest item where current is null
    }

    public void printList() {
        Node<E> temp = head;

        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static final class Node<E> {

        protected E data;
        protected Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
