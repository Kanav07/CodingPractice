package com.kanav.oopBasics.BasicsPractice;

public class Circle {
    // Private instance variables
    private double radius;
    private String color;

    // Constructors (overloaded)
    public Circle() {                   // 1st Constructor
        radius = 1.0;
        color = "red";
    }
    public Circle(double r) {           // 2nd Constructor
        radius = r;
        color = "red";
    }
    public Circle(double r, String c) { // 3rd Constructor
        radius = r;
        color = c;
    }

    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }

    // Public methods
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public void setColor(String newColor) {
        color = newColor;
    }

    // Setter for radius
    public void setRadius(double newRadius) {
        radius = newRadius;
    }
}
