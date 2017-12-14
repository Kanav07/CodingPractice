package com.kanav.oopBasics.BasicsPractice;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super();
        this.height = 1.0;
    }

    public Cylinder(double height){
        super();
        this.height = height;
    }

    public  Cylinder( double height , double radius){
        super(radius);
        this.height = height;
    }

    public  Cylinder ( double height , double radius, String color){
        super(radius,color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public  double getVolume(){
        return super.getArea()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }

}
