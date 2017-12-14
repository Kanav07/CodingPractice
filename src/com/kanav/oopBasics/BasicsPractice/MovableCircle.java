package com.kanav.oopBasics.BasicsPractice;

public class MovableCircle extends Circle implements Movable {
    MovablePoint centre;

    public MovableCircle(MovablePoint centre) {
        super();
        this.centre = centre;
    }

    public MovableCircle(double r, MovablePoint centre) {
        super(r);
        this.centre = centre;
    }

    public MovableCircle() {
        super();
        this.centre = new MovablePoint();
    }

    public  MovableCircle(double x, double y, double x_speed, double y_speed){
        super();
        this.centre = new MovablePoint(x,y,x_speed,y_speed);
    }

    @Override
    public void MoveUp() {
        this.centre.setY(this.centre.getY() + this.centre.getY_speed());
    }

    @Override
    public void MoveDown() {
        this.centre.setY(this.centre.getY() - this.centre.getY_speed());
    }

    @Override
    public void MoveRight() {
        this.centre.setX(this.centre.getX() + this.centre.getX_speed());
    }

    @Override
    public void MoveLeft() {
        this.centre.setX(this.centre.getX() - this.centre.getX_speed());
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "centre=" + centre.toString() +
                '}';
    }
}
