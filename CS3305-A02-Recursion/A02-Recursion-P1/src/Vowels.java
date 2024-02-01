// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: intellij

import java.util.Scanner;

public class Vowels {

    // When called this method counts the number of Vowels in a String recursively.
    public static int countVowels(String x){

        if(x.length()==0){// if the string is empty
            return 0;
        }

        // this var of type boolean checks if first char of the string is a Vowel
        boolean firstCharIsVowel = x.charAt(0) =='A'||x.charAt(0) =='a'||x.charAt(0) =='E'||x.charAt(0) =='e'||x.charAt(0) =='I'||x.charAt(0) =='i'||x.charAt(0) =='O'||x.charAt(0) =='o'||x.charAt(0) =='U'||x.charAt(0) =='u';

        if(x.length()==1){// if the string has only one char
            if (firstCharIsVowel) {
                return 1;
            }else{
                return 0;
            }
        }else{// if the string has more then one char
            if (firstCharIsVowel) {
                return 1 + countVowels(x.substring(1)); //recursive call
            }else{
                return countVowels(x.substring(1)); //recursive call
            }
        }

    }

    public static void main(String[] args) {
        //cresting a scanner object
        Scanner scan = new Scanner(System.in);
        // var of data type string to hold the input string.
        String input = "";

        // this while loop repeats the menu until user exits the program
        while (true){
            //prints menu
            System.out.print("""
                    ---------MAIN MENU---------
                    1. Read input string
                    2. Compute number of vowels
                    3. Exit program
                    
                    Enter option number: """);
            //gets and stores user choice.
            int choice = scan.nextInt();
            scan.nextLine();

            System.out.println();

            // switch to implement menu options
            switch (choice) {
                // reads input string
                case 1 -> {
                    System.out.print("Enter your String: ");
                    input = scan.nextLine();
                    System.out.println();
                }
                // calls countVowels and prints the number of Vowels
                case 2 ->{
                    System.out.println("You entered string:\t"+input);
                    System.out.println("Number of vowels:\t"+countVowels(input));
                    System.out.println();
                }
                // Exits program
                case 3 ->{
                    System.out.println("Exited the program.");
                    System.exit(0);
                }
            }
        }
    }
}
