package com.kanav.oopBasics.OOPQuestions.Ques.Chapter1;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackStyle = new Quack();
        flyStyle = new FlyWithWings();
    }

    @Override
    public String toString() {
        return "MallardDuck{}";
    }
}
