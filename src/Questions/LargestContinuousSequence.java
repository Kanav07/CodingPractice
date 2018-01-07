package Questions;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/* QUESTION

*/

/*  

Input : 7 1 -2  2  3  4 -4  6
Expected :
My Code : 

Input : 8 -2 -3 4 -1 -2 1 5 -3
Expected :
My Code : 

*/

public class LargestContinuousSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
        System.out.println(largestSubArraySumSequence(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }


    public static ArrayList<Integer> largestSubArraySumSequence( ArrayList<Integer> input ){
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 1 -2  2  3  4 -4  6
        // 0  1  2  3  4  5  6
        int max_till = 0, overall_max = Integer.MIN_VALUE, start = 0, end = 0;
        for (int i = 0; i < input.size(); i++) {

            max_till = max_till + input.get(i);
            if( max_till > overall_max) {
                overall_max = max_till;
                end = i;
            }
            if ( max_till  < 0) {
                max_till = 0;
                if( i +1 < input.size()) start = i+1;
            }
        }
        System.out.println(overall_max);
        for (int i = start; i <= end; i++) {
            result.add(input.get(i));
        }

        return result;
    }
}

/* SOLUTION APPROACH

*/