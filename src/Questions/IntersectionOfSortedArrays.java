package Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* QUESTION

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input :
    A : [ 1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that

*/

/*  Input :

7  1 2 3 3 4 5 6
3  3 3 5
    Expected :
    My Code : 
*/

public class IntersectionOfSortedArrays {
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

        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> intersection = intersect(inputListA,inputListB);
        for (int a : intersection) System.out.print(a + " ");
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        ArrayList<Integer> intersection = new ArrayList<Integer>();
        if ( a== null || b == null || a.size()==0 || b.size()==0 ) return intersection;

        int aIndex=0,bIndex=0;

        while (aIndex <a.size() && bIndex < b.size()){

            if (a.get(aIndex).intValue() == b.get(bIndex).intValue()) {
                intersection.add(a.get(aIndex));
                aIndex++;
                bIndex++;
            } else if (a.get(aIndex).intValue() < b.get(bIndex).intValue()) aIndex++;
            else bIndex++;
        }
        return intersection;

    }

}

/* SOLUTION APPROACH

*/