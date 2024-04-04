// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: intellij

import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PQ_heap<Integer> intPriorityQueue = null; // Integer priority queue
        PQ_heap<String> stringPriorityQueue = null; // String priority queue

        while (true) {
            // Displaying the main menu
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("0. Enter Queue Type (integer or string)");
            System.out.println("1. Enqueue Element");
            System.out.println("2. Dequeue Element");
            System.out.println("3. Check is_Full");
            System.out.println("4. Check is_Empty");
            System.out.println("5. Print PQueue Size");
            System.out.println("6. Display Front Element");
            System.out.println("7. Print PQueue Elements");
            System.out.println("8. Exit program");
            System.out.print("Enter option number: ");

            int option = scanner.nextInt(); // Reading user input for menu option
            scanner.nextLine(); // Consume newline
            System.out.println();

            switch (option) {
                case 0: // Option to select queue type
                    System.out.println("Testing type set (Option 0)");
                    System.out.print("Enter Queue Type (integer or string): ");
                    String type = scanner.nextLine(); // Reading user input for queue type
                    if (type.equalsIgnoreCase("integer")) { // Creating integer priority queue
                        intPriorityQueue = new PQ_heap<>();
                    } else if (type.equalsIgnoreCase("string")) { // Creating string priority queue
                        stringPriorityQueue = new PQ_heap<>();
                    } else {
                        System.out.println("Invalid queue type."); // Handling invalid queue type
                    }
                    break;
                case 1: // Option to enqueue element
                    System.out.println("Testing method enqueue (Option 1)");
                    if (intPriorityQueue != null) {
                        System.out.print("Enter integer element to enqueue: ");
                        int intValue = scanner.nextInt(); // Reading integer input
                        intPriorityQueue.enqueue(intValue); // Enqueueing integer element
                        System.out.println("Enqueued integer element: " + intValue);
                    } else if (stringPriorityQueue != null) {
                        System.out.print("Enter string element to enqueue: ");
                        String stringValue = scanner.nextLine(); // Reading string input
                        stringPriorityQueue.enqueue(stringValue); // Enqueueing string element
                        System.out.println("Enqueued string element: " + stringValue);
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 2: // Option to dequeue element
                    System.out.println("Testing method dequeue (Option 2)");
                    if (intPriorityQueue != null) {
                        if (!intPriorityQueue.is_empty()) {
                            int dequeuedElement = intPriorityQueue.dequeue(); // Dequeueing integer element
                            System.out.println("Dequeued integer element: " + dequeuedElement);
                        } else {
                            System.out.println("Integer priority queue is empty.");
                        }
                    } else if (stringPriorityQueue != null) {
                        if (!stringPriorityQueue.is_empty()) {
                            String dequeuedElement = stringPriorityQueue.dequeue(); // Dequeueing string element
                            System.out.println("Dequeued string element: " + dequeuedElement);
                        } else {
                            System.out.println("String priority queue is empty.");
                        }
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 3: // Option to check if queue is full
                    System.out.println("Testing method isFull (Option 3)");
                    if (intPriorityQueue != null) {
                        System.out.println("Integer priority queue is full: " + intPriorityQueue.is_full());
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 4: // Option to check if queue is empty
                    System.out.println("Testing method isEmpty (Option 4)");
                    if (intPriorityQueue != null) {
                        System.out.println("Integer priority queue is empty: " + intPriorityQueue.is_empty());
                    } else if (stringPriorityQueue != null) {
                        System.out.println("String priority queue is empty: " + stringPriorityQueue.is_empty());
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 5: // Option to print queue size
                    System.out.println("Testing method size (Option 5)");
                    if (intPriorityQueue != null) {
                        System.out.println("Integer priority queue size: " + intPriorityQueue.size());
                    } else if (stringPriorityQueue != null) {
                        System.out.println("String priority queue size: " + stringPriorityQueue.size());
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 6: // Option to display front element
                    System.out.println("Testing method front (Option 6)");
                    if (intPriorityQueue != null) {
                        if (!intPriorityQueue.is_empty()) {
                            System.out.println("Front integer element: " + intPriorityQueue.front());
                        } else {
                            System.out.println("Integer priority queue is empty.");
                        }
                    } else if (stringPriorityQueue != null) {
                        if (!stringPriorityQueue.is_empty()) {
                            System.out.println("Front string element: " + stringPriorityQueue.front());
                        } else {
                            System.out.println("String priority queue is empty.");
                        }
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 7: // Option to print queue elements
                    System.out.println("Testing method printPQueueElements (Option 7)");
                    System.out.println("Printing PQueue Elements:");
                    if (intPriorityQueue != null) {
                        printPQueueElements(intPriorityQueue);
                    } else if (stringPriorityQueue != null) {
                        printPQueueElements(stringPriorityQueue);
                    } else {
                        System.out.println("Please select queue type first (option 0).");
                    }
                    break;
                case 8: // Option to exit program
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default: // Handling invalid menu option
                    System.out.println("Invalid option. Please choose from 0 to 8.");
                    break;
            }
            System.out.println(); // Blank line after exercising an option
        }
    }

    // Method to print the elements of the priority queue
    private static <E extends Comparable<E>> void printPQueueElements(PQ_heap<E> priorityQueue) {
        int size = priorityQueue.size();
        int level = 0;
        int index = 0;

        while (index < size) {
            int elementsInLevel = (int) Math.pow(2, level);
            for (int i = 0; i < elementsInLevel && index < size; i++) {
                System.out.print("Index " + index + ": ");
                for (int j = 0; j < elementsInLevel && index < size; j++) {
                    System.out.print(priorityQueue.heap.get(index) + " ");
                    index++;
                }
                System.out.println();
            }
            level++;
        }
    }
}
