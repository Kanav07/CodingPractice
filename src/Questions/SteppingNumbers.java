package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/* QUESTION

Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12
Return the numbers in sorted order.


*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class SteppingNumbers {
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


    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeSet<Integer> output = new TreeSet<Integer>();
        int temp = B;

        for( int i =0; i < 10; i++){
            dfs(output,i,0,A,B);
        }
        res.addAll(output);
        return res;
    }

    public void dfs(TreeSet<Integer> res, int dig, int num, int A, int B){
        num = num*10 + dig;

        if( num > B ) return;
        if ( num >= A) res.add(num);

        if( dig > 0) dfs(res,dig -1,num,A,B);

        if( dig < 9) dfs ( res, dig + 1, num, A, B);
    }
}

/* SOLUTION APPROACH

N = 10 M = 20
start node = 0
From 0, we can move to 1 2 3 4 5 6 7 8 9 [ these are not in our range so we don't add it ]
now from 1, we can move to 12 and 10
from 2, 23 and 21
from 3, 34 and 32
.
.
.
.
.
.
and so on

10 and 12 are in our range, so the answer = 2.


*/