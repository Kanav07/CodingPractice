package com.kanav.oopBasics.BasicsPractice;

public class Person {
    private String name;
    private  String address;

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                "{ address='" + address + '\'' +
                '}';
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
