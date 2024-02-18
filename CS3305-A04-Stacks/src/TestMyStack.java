// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: intellij

import java.util.Scanner;


public class TestMyStack {
    public static void main(String[] args) {
        // Create a new Stack of Integers
        Stack<Integer> testStack = new Stack<>();
        // Create a new Scanner object for user input
        Scanner scan = new Scanner(System.in);

        //loop for the menu
        while (true){
            // Display the main menu to the user
            System.out.print("""
                    --------MAIN MENU-------
                    1 – Push element
                    2 – Pop element
                    3 – Get top element
                    4 – Get stack size
                    5 – Is empty stack?
                    6 - Print stack
                    7 - Exit program
                    
                    Enter option number:""");
            // Get the user's choice
            int choice = scan.nextInt();
            System.out.println();

            // Perform an action based on the user's choice
            switch (choice){
                case 1 -> {
                    // Ask the user for an integer to push onto the stack
                    System.out.println("Enter the integer you want to push: ");
                    int push = scan.nextInt();
                    System.out.println("Before:");testStack.printStack();
                    // Push the integer onto the stack
                    testStack.push(push);
                    // Inform the user that the integer was pushed onto the stack
                    System.out.println(testStack.top()+" was pushed into the stack");
                    System.out.println("After:");testStack.printStack();
                    System.out.println();
                }
                case 2 -> {
                    if(testStack.isEmpty()){
                        System.out.println("The Stack is Empty");
                    }else {
                        System.out.println("Before:");testStack.printStack();
                        // Inform the user that the top element was popped from the stack
                        System.out.println(testStack.top() + " was poped from the stack");
                        // Pop the top element from the stack
                        testStack.pop();
                        System.out.println("After:");testStack.printStack();

                    }
                    System.out.println();
                }
                case 3 -> {
                    if(testStack.isEmpty()){
                        System.out.println("The Stack is Empty");
                    }else {// Display the top element of the stack
                        System.out.println(testStack.top() + " is the element on top");

                    }
                    System.out.println();
                }
                case 4 -> {
                    if(testStack.isEmpty()){
                        System.out.println("The Stack is Empty");
                    }else {// Display the size of the stack
                        System.out.println("The size of the Stack is " + testStack.size());

                    }
                    System.out.println();
                }
                case 5 -> {
                    // Check if the stack is empty and inform the user
                    if(testStack.isEmpty()){
                        System.out.println("The Stack is empty");
                    }else{
                        System.out.println("The Stack is not empty");
                    }
                    System.out.println();
                }
                case 6 -> {
                    if(testStack.isEmpty()){
                        System.out.println("The Stack is Empty");
                    }else{
                        // Print the elements of the stack
                        System.out.print("The Stack:");
                        testStack.printStack();

                    }
                    System.out.println();
                }
                case 7 -> {
                    // Exit the program
                    System.out.println("Exiting Program");
                    System.exit(0);
                }
            }
        }
    }
}

