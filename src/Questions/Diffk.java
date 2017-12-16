package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/* QUESTION

Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class Diffk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int k = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(diffPossible(inputList,k));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int diffPossible(final List<Integer> a, int b) {


        if ( a.size() < 2) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.size(); i++) {
            if (!map.containsKey(a.get(i)))map.put(a.get(i),i);
        }
        for (int i = 0; i < a.size(); i++) {
            int numI = a.get(i);
            if ( map.containsKey(numI - b) && map.get(numI-b)!=i) return 1;
        }
        return 0;
    }
}

/* SOLUTION APPROACH

*/