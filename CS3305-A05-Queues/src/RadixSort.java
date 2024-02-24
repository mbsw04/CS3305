// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: intellij

import java.util.Scanner;

public class RadixSort {
    // extract a specific digit from a number
    static int ExtractDigit(int x, int digit) {
        if (digit > CountDigits(x)) {
            return 0;
        }
        int modifier = (int) Math.pow(10, digit - 1);
        return (x / modifier) % 10;
    }

    // count the number of digits in a number
    static int CountDigits(int x) {
        int length = 0;
        int temp = x;
        while (temp != 0) {
            temp /= 10;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        // queues for each digit
        Queue<Integer> Q0 = new Queue<>();
        Queue<Integer> Q1 = new Queue<>();
        Queue<Integer> Q2 = new Queue<>();
        Queue<Integer> Q3 = new Queue<>();
        Queue<Integer> Q4 = new Queue<>();
        Queue<Integer> Q5 = new Queue<>();
        Queue<Integer> Q6 = new Queue<>();
        Queue<Integer> Q7 = new Queue<>();
        Queue<Integer> Q8 = new Queue<>();
        Queue<Integer> Q9 = new Queue<>();

        // Scanner for user input
        Scanner scan = new Scanner(System.in);

        // array and size variables
        int[] arry = null;
        int size = 0;

        // Main loop for user interaction
        while (true) {
            System.out.print("""
                    ---------------MAIN MENU---------------
                    1 – Read array size
                    2 – Read array values
                    3 – Run Radix Sort and print outputs
                    4 – Exit program
                    
                    Enter option number:""");
            int choice = scan.nextInt();
            System.out.println();

            switch (choice) {
                // Option 1: Read array size
                case 1 -> {
                    System.out.print("Enter the size of the array: ");
                    size = scan.nextInt();
                    arry = new int[size];
                    System.out.println(arry.length);
                }
                // Option 2: Read array values
                case 2 -> {
                    if (arry == null) {
                        System.out.println("You haven't specified the size of the array");
                        System.out.println();
                        break;
                    }
                    for (int i = 0; i < size; i++) {
                        System.out.print("set index " + i + ": ");
                        arry[i] = scan.nextInt();
                    }
                    System.out.println();
                }
                // Option 3: Run Radix Sort and print outputs
                case 3 -> {
                    if (arry == null) {
                        System.out.println("You haven't specified the size of the array");
                        System.out.println();
                        break;
                    }
                    // Find the maximum number of digits among all elements in the array
                    int radix_count = 0;
                    for (int x : arry) {
                        if (radix_count < CountDigits(x)) {
                            radix_count = CountDigits(x);
                        }
                    }

                    System.out.print("Array values before sorting:\t");
                    for (int x : arry) {
                        System.out.print(x + "\t");
                        System.out.println();
                    }

                    // Radix Sort
                    for (int i = 1; i <= radix_count; i++) {
                        for (int x : arry) {
                            int digit = ExtractDigit(x, i);
                            // Enqueue elements based on their extracted digits
                            switch (digit) {
                                case 0 -> Q0.enqueue(x);
                                case 1 -> Q1.enqueue(x);
                                case 2 -> Q2.enqueue(x);
                                case 3 -> Q3.enqueue(x);
                                case 4 -> Q4.enqueue(x);
                                case 5 -> Q5.enqueue(x);
                                case 6 -> Q6.enqueue(x);
                                case 7 -> Q7.enqueue(x);
                                case 8 -> Q8.enqueue(x);
                                case 9 -> Q9.enqueue(x);
                            }
                        }

                        // Dequeue elements back to the array, preserving the order
                        int arry_index = 0;
                        while (!(Q0.isEmpty())) {
                            arry[arry_index] = Q0.front();
                            arry_index++;
                            Q0.dequeue();
                        }
                        while (!(Q1.isEmpty())) {
                            arry[arry_index] = Q1.front();
                            arry_index++;
                            Q1.dequeue();
                        }
                        while (!(Q2.isEmpty())) {
                            arry[arry_index] = Q2.front();
                            arry_index++;
                            Q2.dequeue();
                        }
                        while (!(Q3.isEmpty())) {
                            arry[arry_index] = Q3.front();
                            arry_index++;
                            Q3.dequeue();
                        }
                        while (!(Q4.isEmpty())) {
                            arry[arry_index] = Q4.front();
                            arry_index++;
                            Q4.dequeue();
                        }
                        while (!(Q5.isEmpty())) {
                            arry[arry_index] = Q5.front();
                            arry_index++;
                            Q5.dequeue();
                        }
                        while (!(Q6.isEmpty())) {
                            arry[arry_index] = Q6.front();
                            arry_index++;
                            Q6.dequeue();
                        }
                        while (!(Q7.isEmpty())) {
                            arry[arry_index] = Q7.front();
                            arry_index++;
                            Q7.dequeue();
                        }
                        while (!(Q8.isEmpty())) {
                            arry[arry_index] = Q8.front();
                            arry_index++;
                            Q8.dequeue();
                        }
                        while (!(Q9.isEmpty())) {
                            arry[arry_index] = Q9.front();
                            arry_index++;
                            Q9.dequeue();
                        }
                    }
                    // Print sorted array
                    System.out.print("Array values after sorting:\t");
                    for (int x : arry) {
                        System.out.print(x + "\t");
                        System.out.println();
                    }
                    System.out.println();
                }
                // Option 4: Exit program
                case 4 -> {
                    System.out.println("Exiting Program");
                    System.exit(0);
                }
            }
        }
    }
}
