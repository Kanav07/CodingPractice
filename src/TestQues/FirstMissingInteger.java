package TestQues;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION


Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

*/

/*  

Input : [3,4,-1,1,-8, -7, -6,1,2,0]
x 1
y 4
c 1
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class FirstMissingInteger {
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
        // Solution ( inputList );
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

}


/* SOLUTION APPROACH

*/