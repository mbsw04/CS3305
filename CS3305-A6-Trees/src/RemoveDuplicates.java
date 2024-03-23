// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: intellij

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading input
        BST<String> bst = new BST<>(); // Create a Binary Search Tree object
        boolean running = true; // Control variable for the main program loop

        String[] words = null; // Array to hold words from input text
        String inputText = null; // String to hold the input text
        while (running) {
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1. Read input string");
            System.out.println("2. Remove duplicates and display outputs");
            System.out.println("3. Exit program");
            System.out.print("Enter option number: ");
            int option = scanner.nextInt(); // Read the user's menu option
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    words = null;
                    inputText = null;
                    System.out.print("Enter text input: ");
                    inputText = scanner.nextLine(); // Read the user's text input
                    words = inputText.split(" "); // Split the input text into words
                    for (String word : words) {
                        bst.insert(word); // Insert each word into the BST
                    }
                    System.out.println("Text input stored.");
                    break;
                case 2:
                    if (inputText == null) {
                        System.out.println("No text input provided yet.");
                    } else {
                        System.out.println("Original Text:");
                        System.out.println(inputText);
                        System.out.println("Processed Text:");
                        bst.inorder(); // Print the words in the BST in order
                    }
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    running = false; // Exit the program
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
    }
}

