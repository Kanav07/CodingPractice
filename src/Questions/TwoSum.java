package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/* QUESTION
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
*/

/*  Input :
4 3 6 2 7
9
10 2 2 3 3 1 4 6 7 8 9 17
10

A : [ 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 ]
B : -3
31 4 7 -4 2 2 2 3 -5 -3 9 -4 9 -7 7 -1 9 9 4 1 -4 -2 3 -3 -5 4 -7 7 9 -4 4 -8
-3
4 1 1 1 3
2
    Expected : 4 8
    My Code : 
*/

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }

        int target = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> output = twoSum(inputList,target);
        long end = System.nanoTime();
        for (Integer x : output ) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if ( a.size() < 2) return result;
        int index1 = Integer.MAX_VALUE, index2= Integer.MAX_VALUE;

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> repeat = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size() ; i++) {
            int temp = a.get(i);
            if ( !map.containsKey(temp)) {
                map.put(temp,i+1);
            } else {
                if ( !repeat.containsKey(temp)) repeat.put(temp,i+1);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            int num1 = map.get(temp);

            if( map.containsKey(b - temp)){
                int num2 = map.get(b-temp);
                if ( num1 < num2) {
                    if (num2 < index2) {
                        index2 = num2;
                        index1 = num1;
                    } else if (num2 == index2) {
                        if (num1 < index1) {
                            index1 = num1;
                            index2 = num2;
                        }
                    }
                }
            }

            if( repeat.containsKey(b - temp) ){
                int num3 = repeat.get(b-temp);
                if ( num1 < num3) {
                    if (num3 < index2) {
                        index2 = num3;
                        index1 = num1;
                    } else if (num3 == index2) {
                        if (num1 < index1) {
                            index1 = num1;
                            index2 = num3;
                        }
                    }
                }
            }
        }
        if ( index1 == Integer.MAX_VALUE)  return result;

        result.add(index1);
        result.add(index2);
        return  result;
    }
}

/* SOLUTION APPROACH

*/