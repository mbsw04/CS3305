// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: intellij

import java.util.Scanner;
import java.util.Arrays;

public class AverageGrades {

    //when called this method returns an average of an array of integers using a recursive algorithm
    public static double findAverage(int[] x){
        if(x.length==0){
            return 0;
        }else{
            int[] arrToPass = Arrays.copyOfRange(x, 1, x.length);
            return (x[0]+findAverage(arrToPass)*arrToPass.length) / x.length;
        }
    }

    public static void main(String[] args) {
        //cresting a scanner object
        Scanner scan = new Scanner(System.in);
        //to store the array that the user creates
        int[] classGrades = null;


        while (true) {
            //printing menu
            System.out.print("""
                    --------MAIN MENU-------
                    1. Read class size
                    2. Read class grades
                    3. Compute class average
                    4. Exit program
                                    
                     Enter option number: """);
            //getting and storing user input
            int choice = scan.nextInt();
            scan.nextLine();

            System.out.println();

            // switch to implement menu options
            switch (choice) {
                //read class size
                case 1 -> {
                    boolean correctResponse = true;
                    while(correctResponse) {
                        System.out.print("Enter class size (1+): ");
                        int classSize = scan.nextInt();
                        if (classSize < 1){
                            System.out.println("class size has to be 1 or more");
                        }else{
                            classGrades = new int[classSize];
                            correctResponse = false;
                        }
                    }
                    System.out.println();
                }
                //read class grades
                case 2 -> {
                    if(classGrades == null){
                        System.out.println("First enter class size in option 1");
                    }else {
                        for (int i = 0; i < classGrades.length; i++) {
                            boolean correctResponse = true;
                            while(correctResponse) {
                                System.out.print("Enter Grade " + (i + 1) + ": ");
                                classGrades[i] = scan.nextInt();
                                if(!(classGrades[i]>=0&&classGrades[i]<=100)){
                                    System.out.println("Enter grade has to be between 0-100");
                                }else{
                                    correctResponse = false;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                //compute and print class average and class size and all the class grades
                case 3 -> {
                    if(classGrades == null){
                        System.out.println("First enter class size in option 1 and enter grades in option 2");
                    }else{
                        System.out.println("You entered class size:\t"+classGrades.length);
                        System.out.print("you entered grades:\t\t");
                        for (int x:classGrades) {
                            System.out.print(x+"\t");
                        }
                        System.out.print("\nClass average:\t\t\t");
                        System.out.format("%.2f",findAverage(classGrades));
                    }
                    System.out.println();
                }
                //Exits program
                case 4 -> {
                    System.out.println("Exited the program.");
                    System.exit(0);
                }
            }
        }

    }

}