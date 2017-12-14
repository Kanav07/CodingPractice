package com.kanav.oopBasics.BasicsPractice;

/*
 * A Test Driver for the Time class
 */
public class TestTime {
    public static void main(String[] args) {
        // Valid inputs
        Time t1 = new Time(1, 2, 3);
        System.out.println(t1);

        // Invalid inputs
        // Time t2 = new Time(60, 59, 12);
        // program terminates abruptly
        // NOT continue to the next statement

        // Invalid inputs Handled gracefully via try-catch
        try {
            Time t3 = new Time(60, 59, 12);  // throw IllegalArgumentException
            // Skip the remaining statements in try, goto catch
            System.out.println("This line will be skipped, if exception occurs");
        } catch (IllegalArgumentException ex) {
            // You have the opportunity to do something to recover from the error.
            ex.printStackTrace();
            System.out.println("Caught the exception");
        }

        // Continue the next statement after "try" or "catch".
        System.out.println("Continue after exception!");
    }
}