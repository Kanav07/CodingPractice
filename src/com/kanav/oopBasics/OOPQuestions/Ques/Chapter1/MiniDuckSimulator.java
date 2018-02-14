package com.kanav.oopBasics.OOPQuestions.Ques.Chapter1;

public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck d = new MallardDuck();
        System.out.println(d);
        d.performFly();
        d.performQuack();
        d.swim();

        Duck model = new ModelDuck();
        System.out.println(model);
        model.performQuack();
        model.performFly();
        model.setFlyStyle(new FlyRocketPowered());
        model.performFly();
    }
}
