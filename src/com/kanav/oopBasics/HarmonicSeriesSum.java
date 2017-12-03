package com.kanav.oopBasics;

import static java.lang.Math.pow;

public class HarmonicSeriesSum {
    public static void main (String[] args) {
        int numTerms = 4;
        double sum = 0.0;      // For accumulating sum in double
        int denominator = 1;
        /*for (int i = 0; i < 1000 ; i++) {
            // Beware that int/int gives int
          sum = sum + (double)1/denominator;
            denominator*=2;  // next
            System.out.println(denominator);

        }*/
        sum = (1 * (1 - pow(0.5, 1000))) / (1 - 0.5);
        // Print the sum
        System.out.println("The sum is " + sum);

    }
}
