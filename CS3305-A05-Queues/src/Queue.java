// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: intellij

public class Queue<E> {
    // Node class for queue elements
    private class Node {
        private E data; // Data of the node
        private Node next; // Pointer to the next node

        // Node constructor
        public Node(E item) {
            data = item;
            next = null;
        }
    }

    private Node head, tail; // Head and tail of the queue

    // Queue constructor
    public Queue() {
        head = null;
        tail = null;
    }

    // Method to add an element to the queue
    public void enqueue(E data) {
        if (tail == null)
            head = tail = new Node(data);
        else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    // Method to remove an element from the queue
    public void dequeue() {
        if(head == null){
            return;
        }
        head = head.next;
    }

    // Method to get the front element of the queue
    public E front() {
        if(head == null){
            return null;
        }
        return head.data;
    }

    // Method to get the size of the queue
    public int size() {
        int queueSize= 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            queueSize++;
        }
        return queueSize;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to Print Queue
    public void printQueue()
    {
        Node temp;
        temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
