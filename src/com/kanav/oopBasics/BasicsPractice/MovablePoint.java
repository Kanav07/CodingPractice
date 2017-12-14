package com.kanav.oopBasics.BasicsPractice;

public class MovablePoint {
    private double x;
    private double y;
    private double x_speed;
    private double y_speed;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
        this.x_speed = 0.0;
        this.y_speed = 0.0;
    }

    public MovablePoint(double x, double y, double x_speed, double y_speed) {

        this.x = x;
        this.y = y;
        this.x_speed = x_speed;
        this.y_speed = y_speed;
    }

    public MovablePoint() {
        this.x = 0.0;
        this.y= 0.0;
        this.x_speed = 0.0;
        this.y_speed = 0.0;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX_speed() {
        return x_speed;
    }

    public void setX_speed(double x_speed) {
        this.x_speed = x_speed;
    }

    public double getY_speed() {
        return y_speed;
    }

    public void setY_speed(double y_speed) {
        this.y_speed = y_speed;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", x_speed=" + x_speed +
                ", y_speed=" + y_speed +
                '}';
    }
}
