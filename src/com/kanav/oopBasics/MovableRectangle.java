package com.kanav.oopBasics;

public class MovableRectangle implements Movable {

    private MovablePoint leftUpper;
    private  MovablePoint rightLower;

    public MovableRectangle(MovablePoint leftUpper, MovablePoint rightLower) {
        this.leftUpper = leftUpper;
        this.rightLower = rightLower;
    }

    public MovableRectangle(double x, double y, double length, double breadth,double x_speed, double y_speed) {
        this.leftUpper = new MovablePoint(x,y,x_speed,y_speed);
        this.rightLower= new MovablePoint(x+length,y-breadth,x_speed,y_speed);
    }
    

    @Override
    public void MoveUp() {
        this.leftUpper.setY(this.leftUpper.getY() + this.leftUpper.getY_speed());
        this.rightLower.setY(this.rightLower.getY() + this.rightLower.getY_speed());
    }

    @Override
    public void MoveDown() {
        this.leftUpper.setY(this.leftUpper.getY() - this.leftUpper.getY_speed());
        this.rightLower.setY(this.rightLower.getY() - this.rightLower.getY_speed());
    }

    @Override
    public void MoveRight() {
        this.leftUpper.setX(this.leftUpper.getX() + this.leftUpper.getX_speed());
        this.rightLower.setX(this.rightLower.getX() + this.rightLower.getX_speed());
    }

    @Override
    public void MoveLeft() {
        this.leftUpper.setX(this.leftUpper.getX() - this.leftUpper.getX_speed());
        this.rightLower.setX(this.rightLower.getX() - this.rightLower.getX_speed());
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "leftUpper=" + leftUpper.toString() +
                ", rightLower=" + rightLower.toString() +
                '}';
    }
}
