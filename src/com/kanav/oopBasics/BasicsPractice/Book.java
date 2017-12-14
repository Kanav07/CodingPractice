package com.kanav.oopBasics.BasicsPractice;

public class Book {
    private String name;
    private Author[] author;
    private double price;
    private  int qty;

    public Book(String name, Author[] author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    @Override
    public String toString() {

        String temp = "Book{ name =" + this.name + ", authors=(";
        for (Author a: author) {
            temp += (a.toString() + ",");
        }
        temp += ("), price="+ this.price +",qty="+ this.qty + "]");
        return temp;

    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return author;
    }

    public String getAuthornames(){
        String temp = "";
        for (int i = 0; i< author.length ; i++) {
            temp += (author[i].getName());
            if( i!= author.length -1) temp += (",");
        }
        return temp;
    }
    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Book(String name, Author[] author, double price) {

        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = 0;

    }
}
