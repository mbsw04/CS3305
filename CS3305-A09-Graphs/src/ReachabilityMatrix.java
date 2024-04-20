import java.util.Scanner;

public class ReachabilityMatrix {
    public static void main(String[] args) {

        int[][] adjMatrix1 = null;

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            // Main menu for user interaction
            System.out.println("\n------MAIN MENU------");
            System.out.println("1. Enter graph data");
            System.out.println("2. Print outputs");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    // Option 1: User inputs the graph data
                    int numNodes;
                    System.out.print("Enter the number of nodes in the graph: ");
                    numNodes = scanner.nextInt();
                    adjMatrix1 = new int[numNodes][numNodes];
                    System.out.println("Enter the adjacency matrix:");
                    for (int i = 0; i < numNodes; i++) {
                        for (int j = 0; j < numNodes; j++) {
                            System.out.print("Enter A1[" + i + "," + j + "]: ");
                            adjMatrix1[i][j] = scanner.nextInt();
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    // Option 2: Print the outputs of the graph analysis
                    if (adjMatrix1 == null){
                        System.out.println("First input a matrix (Option 1)");
                        break;
                    }
                    analyzeGraph(adjMatrix1);
                    System.out.println();
                    break;
                case 3:
                    // Option 3: Exit the program
                    System.out.println("Exiting program.");
                    System.out.println();
                    break;
                default:
                    // Invalid option entered by the user
                    System.out.println("Invalid option. Please try again.");
                    System.out.println();
            }
        } while (option != 3);
        scanner.close();
    }

    // Method to multiply two matrices
    private static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Method to add two matrices
    private static int[][] addMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // Method to raise a matrix to a specified power
    private static int[][] powerMatrix(int[][] A, int power) {
        int n = A.length;
        int[][] C = new int[n][n];
        if (power == 0) {
            for (int i = 0; i < n; i++) {
                C[i][i] = 1;
            }
        } else {
            C = A;
            for (int p = 1; p < power; p++) {
                C = multiplyMatrix(C, A);
            }
        }
        return C;
    }

    // Method to calculate the reachability matrix of a given matrix
    private static int[][] reachabilityMatrix(int[][] A) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 1; i <= n; i++) {
            C = addMatrix(C, powerMatrix(A, i));
        }
        return C;
    }

    // Method to analyze the graph and print the results
    public static void analyzeGraph(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int[][] reachMatrix = reachabilityMatrix(adjMatrix);
        int selfLoops = 0;
        int cyclesN = 0;
        int paths1 = 0;
        int pathsN = 0;
        int[] inDegrees = new int[n];
        int[] outDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paths1 += adjMatrix[i][j];
                pathsN += reachMatrix[i][j];
                inDegrees[j] += adjMatrix[i][j];
                outDegrees[i] += adjMatrix[i][j];
                if (i == j) {
                    selfLoops += adjMatrix[i][j];
                    cyclesN += reachMatrix[i][j];
                }
            }
        }
        int paths1ToN = paths1 + pathsN;
        int cycles1ToN = selfLoops + cyclesN;

        // Print results
        System.out.println("Input Matrix: ");
        printMatrix(adjMatrix);
        System.out.println();

        System.out.println("Reachability Matrix:");
        printMatrix(reachMatrix);
        System.out.println();

        System.out.println("In-degrees:");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + (i + 1) + " in-degree is " + inDegrees[i]);
        }
        System.out.println();

        System.out.println("Out-degrees:");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + (i + 1) + " out-degree is " + outDegrees[i]);
        }
        System.out.println();

        System.out.println("Total number of self-loops: " + selfLoops);
        System.out.println("Total number of cycles of length " + n + " edges: " + cyclesN);
        System.out.println("Total number of paths of length 1 edge: " + paths1);
        System.out.println("Total number of paths of length " + n + " edges: " + pathsN);
        System.out.println("Total number of paths of length 1 to " + n + " edges: " + paths1ToN);
        System.out.println("Total number of cycles of length 1 to " + n + " edges: " + cycles1ToN);
        System.out.println("--------------------------------------------------");
    }

    // Method to print a given matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
