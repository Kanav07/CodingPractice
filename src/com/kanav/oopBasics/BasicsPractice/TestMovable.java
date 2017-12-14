package com.kanav.oopBasics.BasicsPractice;

public class TestMovable {
    public static void main(String[] args){
        MovablePoint mp1 = new MovablePoint(0,0.0,1,1);
        MovableCircle mc1 = new MovableCircle(1, mp1);
        System.out.println(mc1.toString());
        mc1.MoveUp();
        mc1.MoveUp();
        mc1.MoveLeft();
        System.out.println(mc1.toString());
        System.out.println(mc1.getArea() +" "+  mc1.getRadius() );



        MovableRectangle mr1 = new MovableRectangle(0,0,1,2,1,1);
        System.out.println(mr1);
        mr1.MoveDown();
        System.out.println(mr1);
        mr1.MoveLeft();
        System.out.println(mr1);
    }
}
