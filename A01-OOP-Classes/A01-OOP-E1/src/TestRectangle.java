// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: intellij

import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {

        //creating a scanner object,
        Scanner scan = new Scanner(System.in);

        //creating myRectangle with default constructor.
        Rectangle myRectangle = new Rectangle();

        //Creating vars to store user input
        double width;
        double height;

        //Asking user to enter the width for yourRectangle.
        System.out.print("Enter the width for yourRectangle (Double):");
        //taking the user input and storing it in width
        width = scan.nextDouble();

        //Asking user to enter the height for yourRectangle.
        System.out.print("Enter the height for yourRectangle (Double):");
        //taking the user input and storing it in height
        height = scan.nextDouble();

        //Creating yourRectangle with user defined parameter with the overloaded constructor.
        Rectangle yourRectangle = new Rectangle(width,height);

        //Printing test data for myRectangle.
        System.out.println("""
                myRectangle:
                ------------""");
        System.out.println("Width:\t\t"+myRectangle.getWidth()+"\nHeight:\t\t"+myRectangle.getHeight()+"\nArea:\t\t"+myRectangle.getArea()+"\nPerimeter:\t"+myRectangle.getPerimeter()+"\n");
        myRectangle.printRectangle("myRectangle");
        System.out.println();

        //Printing test data for yourRectangle.
        System.out.println("""
                yourRectangle:
                --------------""");
        System.out.println("Width:\t\t"+yourRectangle.getWidth()+"\nHeight:\t\t"+yourRectangle.getHeight()+"\nArea:\t\t"+yourRectangle.getArea()+"\nPerimeter:\t"+yourRectangle.getPerimeter()+"\n");
        yourRectangle.printRectangle("yourRectangle");
        System.out.println();
    }
}