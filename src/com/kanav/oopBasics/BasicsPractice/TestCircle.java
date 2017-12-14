package com.kanav.oopBasics.BasicsPractice;

public class TestCircle {
    public static void main(String[] args) {   // Program entry point
        // Declare and Construct an instance of the Circle class called c1
        System.out.println("C1");
        Circle c1 = new Circle(2.0, "blue");  // Use 3rd constructor
        System.out.println("The radius is: " + c1.getRadius());  // use dot operator to invoke member methods
        System.out.println("The color is: " + c1.getColor());
        System.out.printf("The area is: %.2f%n", c1.getArea());
        c1.setRadius(3.2);
        System.out.println("The radius is: " + c1.getRadius());
        System.out.println(c1.toString());   // Explicitly calling toString()
        System.out.println(c1);              // Implicit call to c1.toString()
        System.out.println("c1 is: " + c1);



        // Declare and Construct another instance of the Circle class called c2
        System.out.println("\nC2");
        Circle c2 = new Circle(2.0);  // Use 2nd constructor
        System.out.println("The radius is: " + c2.getRadius());
        System.out.println("The color is: " + c2.getColor());
        System.out.printf("The area is: %.2f%n", c2.getArea());

        // Declare and Construct yet another instance of the Circle class called c3
        System.out.println("\nC3");
        Circle c3 = new Circle();  // Use 1st constructor
        System.out.println("The radius is: " + c3.getRadius());
        System.out.println("The color is: " + c3.getColor());
        System.out.printf("The area is: %.2f%n", c3.getArea());
    }
}
