package com.kanav.oopBasics.BasicsPractice;


public class ResizableCircle extends Circle2 implements Resizable {


    @Override
    public double resize(int percent) {
        return (percent < 100 ?  super.radius * percent/100 : super.radius + super.radius * percent/100) ;
    }
}
