package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
: dhruvi
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/

/*Input : 
 5      1 4 5 8 10
 3      6 9 15
 4      2 3 6 6

 Expected :
 My Code : */

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize1 = sc.nextInt();
        ArrayList<Integer> inputListA = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize1; i++) {
            int inputNumber = sc.nextInt();
            inputListA.add(inputNumber);
        }
        int inputListSize2 = sc.nextInt();
        ArrayList<Integer> inputListB = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize2; i++) {
            int inputNumber = sc.nextInt();
            inputListB.add(inputNumber);
        }

        int inputListSize3 = sc.nextInt();
        ArrayList<Integer> inputListC = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize3; i++) {
            int inputNumber = sc.nextInt();
            inputListC.add(inputNumber);
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(inputListA,inputListB,inputListC));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }


    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int diff = Integer.MAX_VALUE, i=0,j=0,k=0,Asize = A.size(), Bsize = B.size(), Csize = C.size(),max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        if ( Asize == 0 && Bsize == 0 && Csize==0) return Integer.MAX_VALUE;
        while (i < Asize && j < Bsize && k < Csize){
            
            max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

            if ( max - min < diff) diff = max - min;

            if ( A.get(i) == min ) i++;
            else if ( B.get(j) == min ) j++;
            else k++;

        }
        return diff;


    }
}

/* SOLUTION APPROACH

*/