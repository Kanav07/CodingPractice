package com.kanav.oopBasics.BasicsPractice;

public class Circle1 extends Shape {

    protected double radius;

    public Circle1() {
        super();
        System.out.println("\nCIRCLE1 CONSTRUCOR 1 ");

        radius = 1.0;
    }

    public Circle1(double radius) {
        super();
        System.out.println("\nCIRCLE1 CONSTRUCOR 2 ");

        this.radius = radius;
    }

    public Circle1(double radius , String color, boolean isFilled) {
        super(isFilled, color);
        System.out.println("\nCIRCLE1 CONSTRUCOR 3 ");
        this.radius = radius;
    }



    public double getRadius() {
        System.out.println("CIRCLE1 METHOD");
        return radius;
    }

    public void setRadius(double radius) {

        System.out.println("CIRCLE1 METHOD");
        this.radius = radius;
    }

    public double getArea(){
        System.out.println("CIRCLE1 METHOD");
        return  Math.PI * this.radius * this.radius ;
    }

    public  double getPerimeter (){

        System.out.println("CIRCLE1 METHOD");
        return  2* Math.PI * this.radius ;
    }

    @Override
    public String toString() {
        System.out.println("CIRCLE1 METHOD");
        return "Circle1{" +
                "radius=" + radius +
                '}';
    }
}

