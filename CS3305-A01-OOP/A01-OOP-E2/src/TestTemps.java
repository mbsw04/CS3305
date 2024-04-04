// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: intellij

import java.util.Scanner;

public class TestTemps {
    public static void main(String[] args) {
        //Creating scanner object.
        Scanner scan = new Scanner(System.in);
        //vars to store user input.
        int m,t,w,th,f,sa,su;

        //Taking user input for temps.
        System.out.print("Enter Monday's Temp (int): ");
        m = scan.nextInt();
        System.out.print("Enter Tuesday's Temp (int): ");
        t = scan.nextInt();
        System.out.print("Enter wednesday's Temp (int): ");
        w = scan.nextInt();
        System.out.print("Enter Thursday's Temp (int): ");
        th = scan.nextInt();
        System.out.print("Enter Friday's Temp (int): ");
        f = scan.nextInt();
        System.out.print("Enter Saturday's Temp (int): ");
        sa = scan.nextInt();
        System.out.print("Enter Sunday's Temp (int): ");
        su = scan.nextInt();
        System.out.println();

        //Creating an instance of DailyTemps using the inputs from user.
        DailyTemps DT = new DailyTemps(m,t,w,th,f,sa,su);

        //Testing printTemps.
        System.out.println("Testing method printTemps:");
        DT.printTemps();

        //Testing setTemp and then printing temps.
        System.out.println("Testing method setTemp:");
        DT.setTemp();
        DT.printTemps();

        //Testing Freezing.
        System.out.println("Testing method Freezing:");
        System.out.println( "Number of freezing days is "+DT.Freezing()+" days.");

        //Testing Warmest.
        System.out.println("Testing method Warmest:");
        System.out.println("The warmest day of the week is "+DT.Warmest()+".");

    }
}