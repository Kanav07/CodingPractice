package com.kanav.oopBasics.OOPQuestions.Ques.Chapter1;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyStyle = new FlyNoWay();
        quackStyle = new Quack();
    }

    @Override
    public String toString() {
        return "ModelDuck{}";
    }
}
