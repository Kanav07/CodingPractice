package com.kanav.oopBasics.BasicsPractice;

public class Square extends Rectangle {


    public Square() {
        super();
        System.out.println("\nSQUARE CONSTRUCOR 1 ");
    }

    public Square(double side) {
        super(side, side);
        System.out.println("\nSQUARE CONSTRUCOR 2 ");
    }

    public Square(boolean isFilled, String color, double side) {
        super( side, side, color, isFilled);
        System.out.println("\nSQUARE CONSTRUCOR 3 ");
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
        System.out.println("SQUARE METHOD");
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
        System.out.println("SQUARE METHOD");
    }

    public  void setSide ( double side){
        super.setLength(side);
        super.setWidth(side);
        System.out.println("SQUARE METHOD");
    }

    public double getSide(){

        return super.getLength();
    }
}
