// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: intellij

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        Scanner scan = new Scanner(System.in);

        String input = "";
        String reverse = "";

        //loop for the menu
        while (true){
            System.out.print("""
                    -----------------MAIN MENU----------------
                    1 – Read input string
                    2 – Check palindrome and display output
                    3 - Exit program
                    
                    Enter option number:""");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();


            switch (choice){
                case 1 -> {
                    //empty stack
                    while (!(stack.isEmpty())){
                        stack.pop();
                    }
                    // Read the input string
                    System.out.print("Enter the String:");
                    input = scan.nextLine();
                    System.out.println();
                }
                case 2 -> {
                    // Check if the input is a palindrome using a stack
                    for(int i = 0;i < input.length();i++){
                        stack.push(input.charAt(i));
                    }
                    while (!(stack.isEmpty())){
                        reverse = reverse + stack.top();
                        stack.pop();
                    }
                    System.out.println("Entered String:\t\t"+input);
                    System.out.print("Judgment:\t\t\t");
                    if(input.compareToIgnoreCase(reverse)==0){
                        System.out.println("Palindrome");
                    }else{
                        System.out.println("Not Palindrome");
                    }
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

