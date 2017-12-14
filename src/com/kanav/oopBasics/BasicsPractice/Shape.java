package com.kanav.oopBasics.BasicsPractice;

public abstract class Shape {
    protected boolean isFilled;
    protected String color;

    public Shape() {
        System.out.println("\nSHAPE CONSTRUCOR 1 ");
        this.color="Red";
        this.isFilled= true;
    }

    public Shape(boolean isFilled, String color) {
        System.out.println("\nSHAPE CONSTRUCOR 2 ");
        this.isFilled = isFilled;
        this.color = color;
    }

    @Override
    public abstract String toString();

    public boolean isFilled() {

        System.out.println("SHAPE METHOD");
        return isFilled;
    }

    public void setFilled(boolean filled) {
        System.out.println("SHAPE METHOD");
        isFilled = filled;
    }

    public String getColor() {
        System.out.println("SHAPE METHOD");
        return color;
    }

    public void setColor(String color) {
        System.out.println("SHAPE METHOD");
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
