// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: intellij

// Generic code for class priority_queue_heap for Assignment 7


public class PQ_heap<E extends Comparable<E>> {
    public Heap<E> heap;

    // Constructor method
    public PQ_heap() {
        heap = new Heap<>();
    }

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
        return heap.getSize() == 0;
    }

    // Return true if priority queue is full; otherwise return false
    public boolean is_full() {
        // There is no explicit capacity limit in the updated Heap class
        // Therefore, the priority queue is never considered full
        return false;
    }

    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front() {
        if (is_empty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.remove(); // Return the root (maximum) element
    }

    // Return number of elements in the queue
    public int size() {
        return heap.getSize();
    }

    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue() {
        if (is_empty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.remove(); // Remove and return the root (maximum) element
    }

    // Inserts the 'value' into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value) {
        heap.add(value); // Add the value to the priority queue
    }
}