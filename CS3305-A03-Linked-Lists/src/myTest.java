// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: intellij

import java.util.Scanner;

public class myTest {
   public static void main(String[] args) {
      // Created a Scanner object for reading input
      Scanner scan = new Scanner(System.in);
      // Created a LinkedList object
      LinkedList myList = new LinkedList();

      // Main loop for the interactive menu
      while (true) {
         // Print the menu
         System.out.print("""
                    ---------MAIN MENU--------
                    1 – Add First Node
                    2 – Add Last Node
                    3 – Add At Index
                    4 – Remove First Node
                    5 – Remove Last Node
                    6 – Remove At Index
                    7 – Print List Size
                    8 – Print List (Forward)
                    9 – Print List (In Reverse)
                    10- Exit program
                    
                    Enter option number:"""
         );
         // Read the user's choice
         int choice = scan.nextInt();
         // Variables for the value and index to be used in the switch statement
         int value, index;

         // Perform the appropriate action based on the user's choice
         switch (choice) {
            case 1 -> {
               // Add a node at the beginning of the list
               System.out.print("Enter value for the first node: ");
               value = scan.nextInt();
               System.out.println("Adding value " + value + " as first node.");
               System.out.print("List content before adding " + value + " is: ");
               myList.printList();
               myList.addFirstNode(value);
               System.out.print("\nList content after adding " + value + " is: ");
               myList.printList();
               System.out.println();
            }
            case 2 -> {
               // Add a node at the end of the list
               System.out.print("Enter value for the last node: ");
               value = scan.nextInt();
               System.out.println("Adding value " + value + " as last node.");
               System.out.print("List content before adding " + value + " is: ");
               myList.printList();
               myList.addLastNode(value);
               System.out.print("\nList content after adding " + value + " is: ");
               myList.printList();
               System.out.println();
            }
            case 3 -> {
               // Add a node at a specific index in the list
               System.out.print("Enter index for the node: ");
               index = scan.nextInt();
               System.out.print("Enter value for the node: ");
               value = scan.nextInt();
               if(index < 0 || index >= myList.countNodes()){
                  System.out.println("Invalid index, try again");
               }else{
                  System.out.println("Adding value " + value + " at index " + index + ".");
                  System.out.print("List content before adding " + value + " is: ");
                  myList.printList();
                  myList.addAtIndex(index, value);
                  System.out.print("\nList content after adding " + value + " is: ");
                  myList.printList();
                  System.out.println();
               }
            }
            case 4 -> {
               // Remove the first node in the list
               if(myList.countNodes() == 0){
                  System.out.println("List is Empty");
               }else{
                  System.out.println("Removing first node.");
                  System.out.print("List content before removing first node is: ");
                  myList.printList();
                  myList.removeFirstNode();
                  System.out.print("\nList content after removing first node is: ");
                  myList.printList();
                  System.out.println();
               }
            }
            case 5 -> {
               // Remove the last node in the list
               if(myList.countNodes() == 0){
                  System.out.println("List is Empty");
               }else{
                  System.out.println("Removing last node.");
                  System.out.print("List content before removing last node is: ");
                  myList.printList();
                  myList.removeLastNode();
                  System.out.print("\nList content after removing last node is: ");
                  myList.printList();
                  System.out.println();
               }
            }
            case 6 -> {
               // Remove a node at a specific index in the list
               System.out.print("Enter index of the node to remove: ");
               index = scan.nextInt();
               if(index < 0 || index >= myList.countNodes()){
                  System.out.println("Invalid index, try again");
               }else{
                  System.out.println("Removing node at index " + index + ".");
                  System.out.print("List content before removing node at index " + index + " is: ");
                  myList.printList();
                  myList.removeAtIndex(index);
                  System.out.print("\nList content after removing node at index " + index + " is: ");
                  myList.printList();
                  System.out.println();
               }
            }
            case 7 -> System.out.println("List size is: " + myList.countNodes());
            case 8 -> {
               // Print the list in forward order
               System.out.print("List content is: ");
               myList.printList();
               System.out.println();
            }
            case 9 -> {
               // Print the list in reverse order
               System.out.print("List content in reverse is: ");
               myList.printInReverse(myList.head);
               System.out.println();
            }
            case 10 -> {
               // Exit the program
               System.out.println("Exiting program");
               System.exit(0);
            }
         }
      }
   }
}

