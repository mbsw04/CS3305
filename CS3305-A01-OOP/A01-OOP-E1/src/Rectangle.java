// Name: Maan Bhagat
// Class: CS 3305/04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: intellij

public class Rectangle {

    // Creates variable width with double as a datatype
    private double width;

    // Creates variable height with double as a datatype
    private double height;

    // Default constructor with default values 1.00 for width and height.
    Rectangle(){
        width = 1.00;
        height = 1.00;
    }

    // overloaded constructor with parameters for width and height.
    Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    // when called it returns the width of the rectangle.
    public double getWidth() {
        return width;
    }

    // when called it returns the height of the rectangle.
    public double getHeight() {
        return height;
    }

    // when called it returns the Area of the rectangle by using the formula A = W*H.
    public double getArea(){
        return width*height;
    }

    // when called it returns the perimeter  of the rectangle by using the formula P = (2*W)+(2*H).
    public double getPerimeter(){
        return (2*width)+(2*height);
    }

    // when called it prints the object name inputted as a parameter and the width and the height of the Rectangle.
    public void printRectangle(String objectName){
        System.out.println("Rectangle "+objectName+" is "+width+" units wide and "+height+" units high.");
    }
}
