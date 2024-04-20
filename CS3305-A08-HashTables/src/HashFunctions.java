// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: intellij

import java.util.Scanner;

public class HashFunctions {
    // Array of keys to be hashed
    private static final int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

    private static final int TABLE_SIZE = 50;// Size of the hash table
    private static final int MAX_ATTEMPTS = 50;// Maximum number of attempts for probing

    private static int[][] Table = new int[TABLE_SIZE][2];// Hash table represented as a 2D array where each row contains a key and its probe count

    // Main method
    public static void main(String[] args) {
        initializeTable();
        displayMenu();
    }
    // Method to initialize the hash table with default values
    private static void initializeTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            Table[i][0] = -1; // Initialize keys with -1 (empty)
            Table[i][1] = 0;  // Initialize probe count to 0
        }
    }

    // Method to display the main menu
    private static void displayMenu() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n\n-----MAIN MENU--------------------------------------");
            System.out.println("1. Run HF1 (Division method with Linear Probing)");
            System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3. Run HF3 (Division method with Double Hashing)");
            System.out.println("4. Run HF4 (Student Designed HF)");
            System.out.println("5. Exit program");
            System.out.print("Enter option number: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    HF1();
                    break;
                case 2:
                    HF2();
                    break;
                case 3:
                    HF3();
                    break;
                case 4:
                    HF4();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 5);
    }

    // Method to run the first hash function (HF1)
    private static void HF1() {
        initializeTable();
        for (int key : keys) {
            int index = key % TABLE_SIZE;
            int attempts = 0;
            while (Table[index][0] != -1 && attempts < MAX_ATTEMPTS) {
                index = (index + 1) % TABLE_SIZE; // Linear probing
                attempts++;
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Unable to hash key " + key + " to the table.");
            } else {
                Table[index][0] = key;
                Table[index][1] = attempts;
            }
        }
        displayHashTable("HF1");
    }
    // Method to run the second hash function (HF2)
    private static void HF2() {
        initializeTable();
        for (int key : keys) {
            int index = key % TABLE_SIZE;
            int attempts = 0;
            while (Table[index][0] != -1 && attempts < MAX_ATTEMPTS) {
                index = (index + attempts * attempts) % TABLE_SIZE; // Quadratic probing
                attempts++;
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Unable to hash key " + key + " to the table.");
            } else {
                Table[index][0] = key;
                Table[index][1] = attempts;
            }
        }
        displayHashTable("HF2");
    }

    // Method to run the third hash function (HF3)
    private static void HF3() {
        initializeTable();
        for (int key : keys) {
            int index = key % TABLE_SIZE;
            int h2 = 30 - key % 25;
            int attempts = 0;
            while (Table[index][0] != -1 && attempts < MAX_ATTEMPTS) {
                index = (index + attempts * h2) % TABLE_SIZE; // Double hashing
                attempts++;
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Unable to hash key " + key + " to the table.");
            } else {
                Table[index][0] = key;
                Table[index][1] = attempts;
            }
        }
        displayHashTable("HF3");
    }

    // Method to run the fourth hash function (HF4)
    /*
      HF4() implements a custom hashing method along with double hashing for collision resolution.
      It utilizes a custom hash function (customHashFunction()) to calculate the initial index for each key.
      Double hashing is employed using a secondary hash function (customSecondaryHashFunction()) to generate a step size for probing.
      The method iterates through the keys, attempting to hash each one while limiting the number of attempts, and displays the resulting hash table with the sum of probe values.
     */
    private static void HF4() {
        initializeTable();
        for (int key : keys) {
            int index = customHashFunction(key);
            int h2 = customSecondaryHashFunction(key);
            int attempts = 0;
            while (Table[index][0] != -1 && attempts < MAX_ATTEMPTS) {
                index = (index + h2) % TABLE_SIZE; // Double hashing
                attempts++;
            }
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Unable to hash key " + key + " to the table.");
            } else {
                Table[index][0] = key;
                Table[index][1] = attempts;
            }
        }
        displayHashTable("HF4 (Custom Hash Function with Double Hashing)");
    }


    private static int customHashFunction(int key) {
        // Custom hash function to generate an index for the given key
        return (key % 47);
    }


    private static int customSecondaryHashFunction(int key) {
        // Custom secondary hash function for double hashing
        return 23 - (key % 23);
    }


    // Method to display the resulting hash table
    private static void displayHashTable(String label) {
        System.out.println("\nHash table resulted from " + label + ":");
        System.out.println(" Index\tKey\t\tProbes");
        System.out.println("------------------------");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (Table[i][0] != -1) {
                System.out.println(" "+i + "\t\t" + Table[i][0] + "\t\t" + Table[i][1]);
            }
        }

        System.out.println("------------------------");
        System.out.println("Sum of probe values = " + sumProbes() + " probes.");
    }

    // Method to calculate the sum of probe counts in the hash table
    private static int sumProbes() {
        int sum = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            sum += Table[i][1];
        }
        return sum;
    }
}
