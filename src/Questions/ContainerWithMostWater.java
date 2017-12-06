package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Math.abs;

/* QUESTION

Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

 Note: You may not slant the container.
Example :

Input : [1, 5, 4, 3]
Output : 6

Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6

*/

/*  Input :

4 1  5 4 3
10 1 1 1 1 3 1 1 2 2 1
    Expected :
    My Code : 
*/

public class ContainerWithMostWater {
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
        System.out.println(maxArea(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int maxArea(ArrayList<Integer> a) {

        if ( a == null || a.size() < 2) return 0;

        int left = 0,right= a.size()-1,maxarea = 0,temp;
        while (left < right){
            temp = Math.min(a.get(left),a.get(right)) * (right- left);
            if ( temp > maxarea ) maxarea = temp;
            if ( a.get(left).intValue() < a.get(right).intValue() ) left++;
            else right--;
        }
        return maxarea;
    }
}

/* SOLUTION APPROACH

*/