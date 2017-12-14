package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty point
*/

/*  Input : 
    Expected :
    My Code : 
*/

public class Permutations {
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
        ArrayList<ArrayList<Integer>> output = permute(inputList);
        long end = System.nanoTime();
        int i = 1;
        for (ArrayList<Integer> subset : output) {
            System.out.print(" SUBSET "+ i++ +" : ");
            for (Integer x: subset) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if ( a.size() == 0) {
            output.add(a);
            return output;
        }
        return findPermutations(output,new ArrayList<Integer>(),a,0);
    }

    public static
    ArrayList<ArrayList<Integer>> findPermutations(ArrayList<ArrayList<Integer>> output,ArrayList<Integer> curr, ArrayList<Integer> input_array, int index ){


        for ( int i = (index +1)%input_array.size(); i != index; i++ ){
            curr.add(input_array.get(i));

        }

    }
}

/* SOLUTION APPROACH

*/