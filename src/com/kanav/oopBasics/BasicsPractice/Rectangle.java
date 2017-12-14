package com.kanav.oopBasics.BasicsPractice;

public class Rectangle extends  Shape {

    protected double length;
    protected   double width;

    public Rectangle() {
        super();
        System.out.println("\nRECTANGLE CONSTRUCOR 1 ");
        this.length=1.0;
        this.width=1.0;
    }

    public Rectangle(double length, double width) {
        System.out.println("\nRECTANGLE CONSTRUCOR 2 ");
        this.length = length;
        this.width = width;
    }

    public Rectangle(  double width, double length,  String color, boolean isFilled) {
        super(isFilled, color);
        System.out.println("\nRECTANGLE CONSTRUCOR 3 ");
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        System.out.println("RECTANGLE METHOD");
        return length;
    }

    public void setLength(double length) {

        System.out.println("RECTANGLE METHOD");
        this.length = length;
    }

    public double getWidth() {

        System.out.println("RECTANGLE METHOD");
        return width;
    }

    public void setWidth(double width) {

        System.out.println("RECTANGLE METHOD");
        this.width = width;
    }

    public double getArea(){

        System.out.println("RECTANGLE METHOD");
        return this.length * this.width;
    }

    public  double getPerimeter(){

        System.out.println("RECTANGLE METHOD");
        return 2*(this.length+this.width);
    }

    @Override
    public String toString() {
        System.out.println("RECTANGLE METHOD");
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
