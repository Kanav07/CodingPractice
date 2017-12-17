package Questions;

import java.util.*;

/* QUESTION
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
 NOTE : No 2 entries in the permutation sequence should be the same.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class AllUniquePermutations {
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
        for (ArrayList<Integer> l : output) {
            for (Integer x : l) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if (a.size() < 2) {
            output.add(a);
            return output;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (!map.containsKey(a.get(i))) map.put(a.get(i), 1);
            else map.put(a.get(i), map.get(a.get(i)) + 1);
        }

        Set<Map.Entry<Integer, Integer>> d = map.entrySet();
        int[][] digitCounts = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : d) {
            digitCounts[i][0] = e.getKey();
            digitCounts[i++][1] = e.getValue();
        }
        generatePermutations(digitCounts, output, new ArrayList<Integer>(a), 0);

        return output;
    }

    public static void generatePermutations(int[][] digitsCounts, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> permutation, int index) {

        if ( index == permutation.size()){
            output.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < digitsCounts.length  ; i = (i + 1) ) {
            if (digitsCounts[i][1] != 0) {
                permutation.set(index,digitsCounts[i][0]);
                digitsCounts[i][1]--;
                generatePermutations(digitsCounts, output, permutation, (index + 1) );
                digitsCounts[i][1]++;
            }
        }
    }
}





/* SOLUTION APPROACH

*/