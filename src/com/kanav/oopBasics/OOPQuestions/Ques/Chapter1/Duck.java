package com.kanav.oopBasics.OOPQuestions.Ques.Chapter1;

public class Duck {
    FlyBehaviour flyStyle;
    QuackBehaviour quackStyle;

    public Duck() {
    }

    public void performFly(){
        flyStyle.fly();
    }

    public void performQuack(){
        quackStyle.quack();
    }

    public void swim(){
        System.out.println("All ducks swim, even the decoys");
    }

    public void setFlyStyle(FlyBehaviour flyStyle) {
        this.flyStyle = flyStyle;
    }

    public void setQuackStyle(QuackBehaviour quackStyle) {
        this.quackStyle = quackStyle;
    }
}
