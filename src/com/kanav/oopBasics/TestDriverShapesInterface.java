package com.kanav.oopBasics;

public class TestDriverShapesInterface {
    public static  void main(String[] args){
        GeometricObject g = new GeometricObject() {
            @Override
            public double getArea() {
                return 3.4;
            }

            @Override
            public double getPerimeter() {
                return 20.1;
            }
        };
        System.out.println(g.getArea() + "\t" + g.getPerimeter());
        Circle2 c = new Circle2(9.0);
        System.out.println(c.getRadius() + "\t"+ c.getArea() + "\t"+ c.getPerimeter());
        ResizableCircle rc = new ResizableCircle();
        System.out.println(rc.getRadius() + "\t"+ rc.getArea() + "\t"+ rc.getPerimeter());
        Circle2 c1 = rc;
        System.out.println(c1.getRadius());
        System.out.println(rc.resize(100));
        ResizableCircle rc1 = (ResizableCircle) c;
        System.out.println(rc1.getRadius() + "\t"+ rc1.getArea() + "\t"+ rc1.getPerimeter());

    }
}
