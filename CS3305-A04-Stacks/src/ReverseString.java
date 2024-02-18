// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: intellij

import java.util.Scanner;

public class ReverseString {

    // Method to reverse the order of words in a string
    public static String reverse(String x, Stack<String> y){
        String output = "";
        int b_ind = 0;
        int e_ind = 0;
        // Loop through the string
        for(int i = 0; i < x.length(); i++){
            // If a space is found or end of string is reached
            if(x.charAt(i) == ' ' || i == x.length() - 1){
                e_ind = (i == x.length() - 1) ? i + 1 : i;
                // Push the word into the stack
                y.push(x.substring(b_ind, e_ind));
                b_ind = e_ind + 1;
            }
        }
        // Pop the words from the stack to reverse the order
        while (!y.isEmpty()){
            output += y.top() + " ";
            y.pop();
        }
        // Return the reversed string
        return output.trim();
    }

    // Main method
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Scanner scan = new Scanner(System.in);

        String input = "";

        //loop for the menu
        while (true){
            System.out.print("""
                    -----------------MAIN MENU---------------
                    1 – Read input string of words
                    2 – Reverse string and display outputs
                    3 - Exit program
                    
                    Enter option number:""");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            // Switch case for the menu options
            switch (choice){
                // takes user input
                case 1 -> {
                    //empty stack
                    while (!(stack.isEmpty())){
                        stack.pop();
                    }

                    System.out.print("Enter the String: ");
                    input = scan.nextLine();
                    System.out.println();
                }
                // reverses the input
                case 2 -> {
                    System.out.println("Entered string:\t\t"+input);
                    System.out.println("Reversed string:\t"+reverse(input,stack));
                    System.out.println();

                }
                case 3 -> {
                    // Exit the program
                    System.out.println("Exiting Program");
                    System.exit(0);
                }
            }
        }
    }
}