package com.kanav.oopBasics.OOPQuestions.Ques.Chapter2;

import java.util.ArrayList;

public class WeatherData implements Subject{

    ArrayList<Observer> observers;

    private float temp;
    private float hum;
    private float pres;


    @Override
    public void registerObserver(Observer o) {
        if(this.observers.indexOf(o) < 0) {
            this.observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        int index = this.observers.indexOf(o);
        if( index >= 0){
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers ){
            o.update(temp,hum,pres);
        }

    }

    public void measurementsUpdated(){
        notifyObservers();
    }

    public void setMeasurements(float t, float h, float p){
        this.temp = t;
        this.hum = h;
        this.pres= p;
        measurementsUpdated();
    }
}
