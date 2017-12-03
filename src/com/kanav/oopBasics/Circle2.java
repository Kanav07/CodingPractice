package com.kanav.oopBasics;

public class Circle2 implements GeometricObject {
    protected double radius;


    public Circle2() {
        System.out.print("\t Circle2 Circle2()\t");
        radius = 1.0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle2(double radius) {
        System.out.print("\t Circle2 Circle2(double radius)\t");
        this.radius = radius;
    }

    @Override
    public double getArea(){

        return  Math.PI * this.radius * this.radius ;
    }

    @Override
    public  double getPerimeter (){


        return  2* Math.PI * this.radius ;
    }
}
