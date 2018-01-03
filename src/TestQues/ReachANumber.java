package TestQues;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Print the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].
*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class ReachANumber {
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
        System.out.println(reachNumber(inputListSize));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int reachNumber(int target) {
        int s = 0;
        for(int i = 1;;i++){
            s += i;
            if(Math.abs(target) <= s && Math.abs(target) % 2 == s % 2){
                return i;
            }
        }
    }
}

/* SOLUTION APPROACH

*/