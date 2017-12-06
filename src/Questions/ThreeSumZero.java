package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* QUESTION

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)

*/

/*
    Input : 6  -1 0 1 2 -1 -4
    Expected :
    My Code :


     Input : A : [ 19  1 -4 0 0 5 -5 1 0 -2 4 -4 1 -1 -4 3 4 -1 -1 -3 ]
    Expected : [-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2 5 ] [-3 -1 4 ] [-3 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ]
    My Code : [-5 0 5 ] [-4 0 4 ] [-4 0 4 ] [-4 1 3 ] [-2 1 1 ] [-1 0 1 ] [-1 0 1 ] [0 0 0 ]

-5 0 5
-5 1 4
-4 -1 5
-4 0 4
-4 1 3
-3 -2 5
-3 -1 4
-3 0 3
-2 -1 3
-2 1 1
-1 0 1
0 0 0


4 -31013930 -31013930 9784175 21229755
*/

public class ThreeSumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
        ArrayList<ArrayList<Integer>> triplets = threeSum(inputList);
        if (triplets!=null && triplets.size() > 0){
            for (ArrayList<Integer>  set :triplets) {
                for (int x : set) System.out.print(x + " ");
                System.out.println();
            }
        }
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
         triplets = threeSumBEST(inputList);
        if (triplets!=null && triplets.size() > 0){
            for (ArrayList<Integer>  set :triplets) {
                for (int x : set) System.out.print(x + " ");
                System.out.println();
            }
        }
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {

        if ( a==null || a.size()  < 3 ) return null;
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
        int left=0, right = a.size()-1, middle,tripletsIndex =0;

        while (left < right){
            middle = left + (right-left)/2;

            while (middle > 0 && middle < a.size()){

                int sum = a.get(left) + a.get(right) + a.get(middle);
                if ( sum == 0 ){
                    triplets.add(new ArrayList<Integer>());
                    triplets.get(tripletsIndex).add(a.get(left));
                    triplets.get(tripletsIndex).add(a.get(middle));
                    triplets.get(tripletsIndex).add(a.get(right));
                    tripletsIndex++;
                    break;
                } else if ( sum < 0){
                    middle++;
                    if ( middle >= right) {
                        middle++;
                        if (a.get(left) + a.get(right) + a.get(middle) > 0) break;
                    }
                } else {
                    middle--;
                    if ( middle == left){
                        middle--;
                        if (a.get(left) + a.get(right) + a.get(middle) < 0) break;
                    }
                }
            }
            if ( middle <= left) right--;
            else if ( middle >= right) left++;
            else {
                left++;
                right--;
            }

        }

        return triplets;

    }

    public static ArrayList<ArrayList<Integer>> threeSumBEST(ArrayList<Integer> a){

        ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();

        if ( a == null ) return triplets;
        if (a.isEmpty() ||  a.size()  < 3 ) return triplets;
        Collections.sort(a);



        int tripletsIndex=0;
        for (int i = 0; i < a.size()-2; i++) {
            if ( i > 0 )
                if ( a.get(i).intValue() == a.get(i-1).intValue()) i++;
            int left = i+1, right = a.size()-1;
            int temp = - a.get(i),leftNo= Integer.MIN_VALUE, rightNo = Integer.MIN_VALUE;
            while (left < right){
                int sum = a.get(left) + a.get(right);
                if ( sum == temp ){
                    if ( a.get(left) == leftNo && a.get(right) == rightNo ) {
                        left++;
                        right--;
                        continue;
                    }
                    else{
                        triplets.add(new ArrayList<Integer>());
                        triplets.get(tripletsIndex).add(a.get(i));
                        triplets.get(tripletsIndex).add(a.get(left));
                        triplets.get(tripletsIndex).add(a.get(right));
                        tripletsIndex++;
                        leftNo = a.get(left);
                        rightNo = a.get(right);
                        left++;
                        right--;
                    }
                } else if ( sum < temp) left++;
                else right--;
            }
        }
        return triplets;

    }

}

/* SOLUTION APPROACH

*/