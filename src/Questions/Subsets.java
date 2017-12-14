package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* QUESTION


Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]


*/

/*  Input :

3 1 2 3

 SUBSET 1 :
 SUBSET 2 : 1
 SUBSET 3 : 1 2
 SUBSET 4 : 1 2 3
 SUBSET 5 : 1 3
 SUBSET 6 : 2
 SUBSET 7 : 2 3
 SUBSET 8 : 3

8 1 4 2 6 3 7 8 9
    Expected :
    My Code : 
*/

public class Subsets {
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
        ArrayList<ArrayList<Integer>> output = subsets(inputList);
        long end = System.nanoTime();
        int i = 1;
        for (ArrayList<Integer> subset : output) {
            System.out.print(" SUBSET "+ i++ +" : ");
            for (Integer x: subset) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));



         start = System.nanoTime();
        //call function here.....
         output = subsetsBEST(inputList);
         end = System.nanoTime();
         i = 1;
        for (ArrayList<Integer> subset : output) {
            System.out.print(" SUBSET "+ i++ +" : ");
            for (Integer x: subset) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        if( a.size() == 0) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            temp.add(a);
            return temp;
        };
        Collections.sort(a);
        return generateSubsets(a,0);

    }

    public  static ArrayList<ArrayList<Integer>> generateSubsets (ArrayList<Integer> a, int index ){

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();

        if ( index == a.size()-1){
             ArrayList<Integer> x = new ArrayList<Integer>();
             x.add(a.get(index));
            result.add(x);
            result.add(new ArrayList<Integer>());
        }else {

            result1.add(new ArrayList<Integer>());
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(a.get(index));
            result1.add(temp);
            ArrayList<ArrayList<Integer>> nextSubsets = generateSubsets(a, index + 1);
            for (ArrayList<Integer> preSet : result1) {
                for (ArrayList set : nextSubsets) {
                    if (preSet.size() != 0 || set.size() != 0) {
                        ArrayList<Integer> temp1 = new ArrayList<Integer>();
                        temp1.addAll(preSet);
                        temp1.addAll(set);
                        result.add(temp1);
                    }
                }
            }
            result.add(new ArrayList<Integer>());
        }
        if ( index == 0 ) {
            Collections.reverse(result);
        }
        return result;
    }



    public static ArrayList<ArrayList<Integer>> subsetsBEST(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0)
            return output;
        Collections.sort(a);
        generate(a, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public static void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++)
        {
            temp.add(a.get(i));
            output.add(new ArrayList<Integer>(temp));
            generate(a, output, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }


}

/* SOLUTION APPROACH


When only 1 element is present or we have reached the last element of the input array - then only two variations are possible
                    - select the last element

                   - dont select the last element
  Hence we return this variation to the parent call.

  In the parent call we create a Subset Array if only the current element of the call was in the set => [ [] , [ curr_element] ]
  Then we merge this array after multifplying it with its nextSubset from the child call => [ [last_element] , [] ]

  with this we get [ [last_element] ,[] , [ curr_element, last element] , [ curr_element] ]
  We rdon't include the [] during this set_merger_multiplication and add it to the last after this process is done.

  [ [last_element] , [ curr_element, last element] , [ curr_element] , [] ]

  This is in reverse lexicographical order. Unless the curr_element is the first_element we return it as it is.


*/