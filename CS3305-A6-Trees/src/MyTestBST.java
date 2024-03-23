// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: intellij

import java.util.Scanner;

public class MyTestBST {

    public static void main(String[] args) {
        // Declaring BST instances for integer and string types
        BST<Integer> intTree = null; // Integer BST
        BST<String> strTree = null;   // String BST
        boolean dataTypeSelected = false; //track if tree data type is selected

        // Scanner for user input
        Scanner scan = new Scanner(System.in);

        // Main menu loop
        while (true) {
            // Displaying main menu options
            System.out.println("""
                    ----------------MAIN MENU---------------
                    0. Enter Tree Data Type (integer or string)
                    1. Insert Data Element
                    2. Delete Data Element
                    3. Search for Data Element
                    4. Print Tree Size
                    5. Path from Root to Data Element
                    6. Check if Empty Tree
                    7. Print Preorder Traversal
                    8. Print Inorder Traversal
                    9. Print Postorder Traversal
                    10. Exit program
                                        
                    Enter option number:""");
            int choice = scan.nextInt(); // Reading user choice
            System.out.println();

            // Switch case to handle user choices
            switch (choice) {
                case 0:
                    // Option to select tree data type
                    System.out.print("Enter Tree Data Type (integer or string): ");
                    String dataType = scan.next().toLowerCase(); // Reading data type
                    if (dataType.equals("integer")) {
                        intTree = new BST<Integer>(); // Creating Integer BST instance
                        strTree = null; // Reset string tree
                        dataTypeSelected = true;
                    } else if (dataType.equals("string")) {
                        strTree = new BST<String>(); // Creating String BST instance
                        intTree = null; // Reset integer tree
                        dataTypeSelected = true;
                    } else {
                        System.out.println("Invalid data type entered. Please choose either integer or string.");
                    }
                    break;
                case 1:
                    // Option to insert data element into the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before inserting elements.");
                        break;
                    }
                    if (intTree != null) {
                        System.out.print("Enter data element to insert: ");
                        int element = scan.nextInt();
                        intTree.insert(element); // Inserting into Integer BST
                        System.out.println("Element inserted successfully into Integer BST.");
                    } else if (strTree != null) {
                        System.out.print("Enter data element to insert: ");
                        String element = scan.next();
                        strTree.insert(element); // Inserting into String BST
                        System.out.println("Element inserted successfully into String BST.");
                    }
                    break;
                case 2:
                    // Option to delete data element from the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before deleting elements.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Enter data element to delete from Integer BST: ");
                        int element = scan.nextInt();
                        intTree.delete(element); // Deleting from Integer BST
                        System.out.println("Element deleted successfully from Integer BST.");
                    } else if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Enter data element to delete from String BST: ");
                        String element = scan.next();
                        strTree.delete(element); // Deleting from String BST
                        System.out.println("Element deleted successfully from String BST.");
                    } else {
                        System.out.println("Cannot delete from an empty BST.");
                    }
                    break;
                case 3:
                    // Option to search for a data element in the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before searching elements.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Enter data element to search in Integer BST: ");
                        int intElement = scan.nextInt();
                        System.out.println("Is " + intElement + " in the Integer BST? " + intTree.search(intElement));
                    } else if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Enter data element to search in String BST: ");
                        String strElement = scan.next();
                        System.out.println("Is " + strElement + " in the String BST? " + strTree.search(strElement));
                    } else {
                        System.out.println("Cannot search in an empty BST.");
                    }
                    break;
                case 4:
                    // Option to print the size of the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before checking size.");
                        break;
                    }
                    if (intTree != null) {
                        System.out.println("Size of Integer BST: " + intTree.getSize());
                    }
                    if (strTree != null) {
                        System.out.println("Size of String BST: " + strTree.getSize());
                    }
                    break;
                case 5:
                    // Option to find the path from root to a data element in the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before finding paths.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Enter data element to find path for in Integer BST: ");
                        int intElement = scan.nextInt();
                        System.out.println("Path from root to " + intElement + " in Integer BST: " + intTree.path(intElement));
                    } else if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Enter data element to find path for in String BST: ");
                        String strElement = scan.next();
                        System.out.println("Path from root to " + strElement + " in String BST: " + strTree.path(strElement));
                    } else {
                        System.out.println("Cannot find path in an empty BST.");
                    }
                    break;
                case 6:
                    // Option to check if the selected BST is empty
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before checking if empty.");
                        break;
                    }
                    if (intTree != null) {
                        System.out.println("Is Integer BST empty? " + intTree.isEmpty());
                    }
                    if (strTree != null) {
                        System.out.println("Is String BST empty? " + strTree.isEmpty());
                    }
                    break;
                case 7:
                    // Option to print preorder traversal of the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before printing preorder traversal.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Preorder traversal of Integer BST: ");
                        intTree.preorder(); // Printing preorder
                        System.out.println();
                    }
                    if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Preorder traversal of String BST: ");
                        strTree.preorder(); // Printing preorder
                        System.out.println();
                    }
                    break;
                case 8:
                    // Option to print inorder traversal of the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before printing inorder traversal.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Inorder traversal of Integer BST: ");
                        intTree.inorder(); // Printing inorder
                        System.out.println();
                    }
                    if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Inorder traversal of String BST: ");
                        strTree.inorder(); // Printing inorder
                        System.out.println();
                    }
                    break;
                case 9:
                    // Option to print postorder traversal of the selected BST
                    if (!dataTypeSelected) {
                        System.out.println("Please select tree data type (Option 0) before printing postorder traversal.");
                        break;
                    }
                    if (intTree != null && !intTree.isEmpty()) {
                        System.out.print("Postorder traversal of Integer BST: ");
                        intTree.postorder(); // Printing postorder
                        System.out.println();
                    }
                    if (strTree != null && !strTree.isEmpty()) {
                        System.out.print("Postorder traversal of String BST: ");
                        strTree.postorder(); // Printing postorder
                        System.out.println();
                    }
                    break;
                case 10:
                    // Exiting the program
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
                default:
                    // Handling invalid options
                    System.out.println("Invalid option. Please choose a valid option (0-10).");
            }
        }
    }
}
