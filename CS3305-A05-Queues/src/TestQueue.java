// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: intellij

import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {

        Queue<Integer> testQueue = new Queue<>(); // Create a new Queue of integers
        Scanner scan = new Scanner(System.in); // Create a new Scanner object for user input

        while(true){ // loop to keep the menu running until the user chooses to exit
            System.out.print("""
                    --------MAIN MENU--------
                    1 – Enqueue element
                    2 – Dequeue element
                    3 – Get front element
                    4 – get queue size
                    5 – Is Empty queue?
                    6 - Print queue
                    7 - Exit program
                    
                    Enter option number:"""
            );
            int choice = scan.nextInt();
            System.out.println();

            switch (choice){
                case 1 -> { // Enqueue an element
                    System.out.print("Enter the integer to enqueue: ");
                    int data = scan.nextInt();
                    System.out.print("Before:\t");testQueue.printQueue();System.out.println();
                    testQueue.enqueue(data); // Enqueue the user's integer
                    System.out.println(data+" has been enqueued");
                    System.out.print("After:\t");testQueue.printQueue();System.out.println();
                    System.out.println();
                }
                case 2 -> { // Dequeue an element
                    if(testQueue.isEmpty()){ // Check if the queue is empty
                        System.out.println("The queue is Empty");
                        System.out.println();
                    }else {
                        System.out.print("Before:\t");
                        testQueue.printQueue();
                        System.out.println();
                        System.out.println(testQueue.front() + " has been dequeued");
                        testQueue.dequeue(); // Dequeue the front element
                        System.out.print("After:\t");
                        testQueue.printQueue();
                        System.out.println();
                        System.out.println();
                    }
                }
                case 3 -> { // Get the front element
                    if(testQueue.isEmpty()){ // Check if the queue is empty
                        System.out.println("The queue is Empty");
                        System.out.println();
                    }else {
                        System.out.println(testQueue.front() + " is at the front of the queue");
                        System.out.println();
                    }
                }
                case 4 -> { // Get the size of the queue
                    if(testQueue.isEmpty()){ // Check if the queue is empty
                        System.out.println("The queue is Empty");
                        System.out.println();
                    }else {
                        System.out.println("Their are " + testQueue.size() + " elements in queue");
                        System.out.println();
                    }
                }
                case 5 -> { // Check if the queue is empty
                    if(testQueue.isEmpty()){
                        System.out.println("The queue is empty");
                    }else{
                        System.out.println("The queue is not empty");
                    }
                    System.out.println();
                }
                case 6 -> { // Print the queue
                    if(testQueue.isEmpty()){ // Check if the queue is empty
                        System.out.println("The queue is Empty");
                        System.out.println();
                    }else {
                        System.out.print("Queue:\t");
                        testQueue.printQueue(); // Print the elements of the queue
                        System.out.println();
                        System.out.println();
                    }
                }
                case 7 -> { // Exit the program
                    System.out.println("Exiting Program");
                    System.exit(0);
                }
            }
        }
    }
}

