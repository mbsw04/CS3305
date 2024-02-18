// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: intellij

public class Stack<E> {
    //node
    private class Node
    {
        private E data;  //data field
        private Node next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }

    //Pointer for the head
    public Node head;
    //Constructor
    public Stack()
    {
        head = null;
    }

    //adds first node to Stack
    public void push(E data)
    {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }

    //removes first node from Stack
    public void pop()
    {
        head = head.next;
    }

    //Returns value of the first node of the Stack
    public E top(){
        return head.data;
    }

    //Returns the size of the stack by counting the nodes
    public int size()
    {
        int listSize= 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            listSize++;
        }

        return listSize;

    }

    public void printStack()
    {
        Node temp;
        temp = head;

        while (temp != null) {
            System.out.print("\t"+temp.data);
            temp = temp.next;
        }
    }

    //returns true if stack is empty and false if not
    public boolean isEmpty(){
        return head == null;
    }
}