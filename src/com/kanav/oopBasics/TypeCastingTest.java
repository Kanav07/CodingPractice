package com.kanav.oopBasics;

/*
 * Find the sum and average from a lowerbound to an upperbound
 */
public class TypeCastingTest {   // Save as "TypeCastingTest.java"
    public static void main(String[] args) {
        int lowerbound = 1, upperbound = 1000;
        int sum = 0;      // sum is "int"
        double average;   // average is "double"

        // Compute the sum (in "int")
        int number = lowerbound;
        while (number <= upperbound) {
            sum = sum + number;
            ++number;
        }
        System.out.println("The sum from " + lowerbound + " to " + upperbound + " is " + sum);

        // Compute the average (in "double")
        average = sum / (upperbound - lowerbound + 1);
        System.out.println("Average 1 is " + average);
        average = (double)sum / (upperbound - lowerbound + 1);
        System.out.println("Average 2 is " + average);
        average = sum / 1000;
        System.out.println("Average 3 is " + average);
        average = sum / 1000.0;
        System.out.println("Average 4 is " + average);
        average = (double)(sum / 1000);
        System.out.println("Average 5 is " + average);
    }
}
