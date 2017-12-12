package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

/*  Input :

// 6 2 1 5 6 2 3
// 10 90 58 69 70 82 100 13 57 47 18
// 7  6 2 5 4 5 1 6
// 13 3 2 5 4 8 3 3 1 6 7 5 8 3

// 36 69 47 84 7 70 73 4 73 70 54 2 35 32 53 99 41 90 53 55 6 1 95 63 63 74 12 32 89 69 71 17 49 9 40 10 56
// 94  47 69 67 97 86 34 98 16 65 95 66 69 18 1 99 56 35 9 48 72 49 47 1 72 87 52 13 23 95 55 21 92 36 88 48 39 84 16 15 65 7 58 2 21 54 2 71 92 96 100 28 31 24 10 94 5 81 80 43 35 67 33 39 81 69 12 66 87 86 11 49 94 38 44 72 44 18 97 23 11 30 72 51 61 56 41 30 71 12 44 81 43 43 27
    Expected :
    My Code : 
*/

public class LargestRectangleHistogram {
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
        System.out.println(largestRectangleArea(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


    }


    // 36 69 47 84 7 70 73 4 73 70 54 2 35 32 53 99 41 90 53 55 6 1 95 63 63 74 12 32 89 69 71 17 49 9 40 10 56
// 94  47 69 67 97 86 34 98 16 65 95 66 69 18 1 99 56 35 9 48 72 49 47 1 72 87 52 13 23 95 55 21 92 36 88 48 39 84 16 15 65 7 58 2 21 54 2 71 92 96 100 28 31 24 10 94 5 81 80 43 35 67 33 39 81 69 12 66 87 86 11 49 94 38 44 72 44 18 97 23 11 30 72 51 61 56 41 30 71 12 44 81 43 43 27
    public static int largestRectangleArea(ArrayList<Integer> a) {

        int maxArea = 0,i;

        Stack<Integer> Position = new Stack<Integer>();
        Stack<Integer> Value = new Stack<Integer>();

        for ( i = 0; i < a.size(); i++) {
            if ( Position.empty() && Value.empty()){
                Position.push(i);
                Value.push(a.get(i));
                maxArea = (i + 1)*a.get(i);
            } else {
                if ( a.get(i) < Value.peek()) {

                    maxArea = Math.max(maxArea,Value.peek()*(i - Position.peek()));
                    Value.pop();
                    while ( !Value.empty() && Value.peek() >= a.get(i)){
                        Position.pop();
                        maxArea = Math.max(maxArea,Value.peek()*(i - Position.peek()));
                        Value.pop();

                    }
                    Value.push(a.get(i));
                    maxArea = Math.max(Math.max(maxArea,a.get(i)),Value.peek()*(i - Position.peek() + 1));

                } else  if  ( a.get(i) > Value.peek()) {

                    maxArea = Math.max(Math.max(maxArea,a.get(i)),Value.peek()*(i - Position.peek() + 1));

                    Value.push(a.get(i));
                    Position.push(i);
                }
            }
        }

        while (!Value.empty()){
            maxArea = Math.max(maxArea,Value.peek()*(i - Position.peek()));
            Value.pop();
            Position.pop();

        }
        return maxArea;


    }
}

/* SOLUTION APPROACH

*/