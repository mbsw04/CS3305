// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: intellij

import java.util.Scanner;

public class DailyTemps {
    //Creating Scanner object
    Scanner scan = new Scanner(System.in);
    //An array to store Daily Temps, index[0] being monday.
    private int[] temps = new int[7];
    //An array that stores the name of the days.
    private final String[] names = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

    //Constructor that takes in 7 ints for 7 days of the week.
    DailyTemps(int m,int t,int w,int th,int f, int sa,int  su){
        temps[0] = m;temps[1] = t;temps[2] = w;temps[3] = th;temps[4] = f;temps[5] = sa;temps[6] = su;
    }

    //when called lets user change the temp of a selected day.
    public void setTemp() {
        // getting user input for which day
       System.out.print("Enter an Int to select day 0.monday to 6.sunday: ");
       int day = scan.nextInt();
        // getting user input for temp they want to change it to.
       System.out.print("Enter a Temp (Int) which you want to change "+names[day]+"'s temp to: ");
       int temp = scan.nextInt();
       //setting the new temp.
       this.temps[day] = temp;
    }

    //when called returns the number of days below 32F.
    public int Freezing() {
        int count = 0;
        for (int x:temps) {
            if(x<32){count++;}
        }
        return count;
    }

    //when called returns the name of the warmest day of the week
    public String Warmest(){
        String day = "";
        int hottest = 0;
        for(int i = 0; i < 7;i++){
            if(temps[i]>hottest){
                hottest = temps[i];
                day = names[i];
            }
        }
        return day;
    }

    //When called it prints out the names and the temps of all the days
    public void printTemps(){
        System.out.print(names[0]+"\t\t"+temps[0]+"\n");
        System.out.print(names[1]+"\t\t"+temps[1]+"\n");
        System.out.print(names[2]+"\t"+temps[2]+"\n");
        System.out.print(names[3]+"\t"+temps[3]+"\n");
        System.out.print(names[4]+"\t\t"+temps[4]+"\n");
        System.out.print(names[5]+"\t"+temps[5]+"\n");
        System.out.print(names[6]+"\t\t"+temps[6]+"\n");


    }

}
