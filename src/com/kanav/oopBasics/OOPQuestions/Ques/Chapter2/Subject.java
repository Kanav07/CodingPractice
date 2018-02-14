package com.kanav.oopBasics.OOPQuestions.Ques.Chapter2;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver( Observer o);
    void notifyObservers();
}
