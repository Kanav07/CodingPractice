package Questions;

import com.kanav.oopBasics.BasicsPractice.A;

import java.util.ArrayList;
import java.util.Collections;
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

3 1 2 3
 PERMUTATION 1 : 1 2 3
 PERMUTATION 2 : 1 3 2
 PERMUTATION 3 : 2 1 3
 PERMUTATION 4 : 2 3 1
 PERMUTATION 5 : 3 2 1
 PERMUTATION 6 : 3 1 2

Time taken : 95000
 PERMUTATION 1 : 1 2 3
 PERMUTATION 2 : 1 3 2
 PERMUTATION 3 : 2 1 3
 PERMUTATION 4 : 2 3 1
 PERMUTATION 5 : 3 2 1
 PERMUTATION 6 : 3 1 2

Time taken : 91000


4 1 2 3 4
 PERMUTATION 1 : 1 2 3 4
 PERMUTATION 2 : 1 2 4 3
 PERMUTATION 3 : 1 3 2 4
 PERMUTATION 4 : 1 3 4 2
 PERMUTATION 5 : 1 4 3 2
 PERMUTATION 6 : 1 4 2 3
 PERMUTATION 7 : 2 1 3 4
 PERMUTATION 8 : 2 1 4 3
 PERMUTATION 9 : 2 3 1 4
 PERMUTATION 10 : 2 3 4 1
 PERMUTATION 11 : 2 4 3 1
 PERMUTATION 12 : 2 4 1 3
 PERMUTATION 13 : 3 2 1 4
 PERMUTATION 14 : 3 2 4 1
 PERMUTATION 15 : 3 1 2 4
 PERMUTATION 16 : 3 1 4 2
 PERMUTATION 17 : 3 4 1 2
 PERMUTATION 18 : 3 4 2 1
 PERMUTATION 19 : 4 2 3 1
 PERMUTATION 20 : 4 2 1 3
 PERMUTATION 21 : 4 3 2 1
 PERMUTATION 22 : 4 3 1 2
 PERMUTATION 23 : 4 1 3 2
 PERMUTATION 24 : 4 1 2 3

Time taken : 656000
 PERMUTATION 1 : 1 2 3 4
 PERMUTATION 2 : 1 2 4 3
 PERMUTATION 3 : 1 3 2 4
 PERMUTATION 4 : 1 3 4 2
 PERMUTATION 5 : 1 4 3 2
 PERMUTATION 6 : 1 4 2 3
 PERMUTATION 7 : 2 1 3 4
 PERMUTATION 8 : 2 1 4 3
 PERMUTATION 9 : 2 3 1 4
 PERMUTATION 10 : 2 3 4 1
 PERMUTATION 11 : 2 4 3 1
 PERMUTATION 12 : 2 4 1 3
 PERMUTATION 13 : 3 2 1 4
 PERMUTATION 14 : 3 2 4 1
 PERMUTATION 15 : 3 1 2 4
 PERMUTATION 16 : 3 1 4 2
 PERMUTATION 17 : 3 4 1 2
 PERMUTATION 18 : 3 4 2 1
 PERMUTATION 19 : 4 2 3 1
 PERMUTATION 20 : 4 2 1 3
 PERMUTATION 21 : 4 3 2 1
 PERMUTATION 22 : 4 3 1 2
 PERMUTATION 23 : 4 1 3 2
 PERMUTATION 24 : 4 1 2 3

Time taken : 208000

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
            System.out.print(" PERMUTATION "+ i++ +" : ");
            for (Integer x: subset) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
         output = permuteBEST(inputList);
         end = System.nanoTime();
         i = 1;
        for (ArrayList<Integer> subset : output) {
            System.out.print(" PERMUTATION "+ i++ +" : ");
            for (Integer x: subset) System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nTime taken : " + (end - start));
    }

    public static ArrayList<ArrayList<Integer>> permuteFAIL(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if ( a.size() <= 1) {
            output.add(a);
            return output;
        }
        int[] count = new int[a.size()];
        for (int i = 0; i < a.size() ; i++) count[i] = 1;
        ArrayList<ArrayList<Integer>> result = findPermutationsFAIL(a,count,0);
        return result;
    }
/*
    public static
    ArrayList<ArrayList<Integer>> findPermutations(ArrayList<ArrayList<Integer>> output,int[] counts, ArrayList<Integer> input_array, int index ){

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(index == input_array.size()) return result;

        for ( int i = (index +1)%input_array.size(); i != index; i++ ){
            if ( index< input_array.size() && counts[index]!=0) {
                int startElement = input_array.get(index);
                counts[index] = 0;
                ArrayList<ArrayList<Integer>> nextPerms = findPermutations(output,counts,input_array,index +1);
                for (ArrayList<Integer> perm : nextPerms) {
                    ArrayList<Integer> temp2 = new ArrayList<Integer>();
                    temp2.add(startElement);
                    temp2.addAll(perm);
                    result.add(temp2);
                }
                if ( nextPerms.size() == 0){
                    ArrayList<Integer> temp2 = new ArrayList<Integer>();
                    temp2.add(startElement);
                    result.add(temp2);
                    return result;
                }
                counts[index] = 1;
            }
        }

        return output;
    }*/



    public static ArrayList<ArrayList<Integer>> findPermutationsFAIL(ArrayList<Integer> input_array, int[] counts, int index){

        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        counts[index] = 0;
        result.add(input_array.get(index));
        int i= (index + 1)%input_array.size();
        while (counts[i] != 0 )
        {
            if (i == index) {
                temp.add(result);
                return (temp);
            }
            ArrayList<ArrayList<Integer>> subsetPerm = findPermutationsFAIL(input_array, counts, i);
            for (ArrayList<Integer> set : subsetPerm) {
                ArrayList<Integer> temp1 = (ArrayList<Integer>) result.clone();
                temp1.addAll(set);
                temp.add(temp1);
            }
            i = (i + 1)%input_array.size();
        }

        return temp;
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if ( a.size() <= 1) {
            output.add(a);
            return output;
        }
        ArrayList<ArrayList<Integer>> result = findPermutations(a,0,new ArrayList<Integer>(),output);
        return result;
    }

    private static ArrayList<ArrayList<Integer>> findPermutations(ArrayList<Integer> a, int outer_Index, ArrayList<Integer> perm,ArrayList<ArrayList<Integer>> output) {

        if ( outer_Index == a.size()) return output;

        if (outer_Index < a.size()){
            int swap_index = outer_Index + 1;
            ArrayList<Integer> copyOfInput = (ArrayList<Integer>) a.clone();


            while (swap_index <= a.size()){
                if ( perm.size() <= outer_Index ) perm.add(copyOfInput.get(outer_Index));
                else perm.set(outer_Index,copyOfInput.get(outer_Index));
                output = findPermutations(copyOfInput,outer_Index +1,perm,output);

                if ( swap_index < a.size()) {
                    copyOfInput.set(swap_index-1,a.get(swap_index-1));
                    int temp = a.get(outer_Index);
                    copyOfInput.set(outer_Index, a.get(swap_index));
                    copyOfInput.set(swap_index, temp);
                    perm.remove(swap_index);
                    perm.remove(outer_Index);


                }
                swap_index++ ;
            }
            if ( outer_Index == a.size()-1 && swap_index >= a.size()) output.add(new ArrayList<Integer>(perm));
            return output;
        }
        return output;

    }


    public static ArrayList<ArrayList<Integer>> permuteBEST(ArrayList<Integer> a) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if( a.size() <= 1) {
            output.add(a);
            return output;
        }

        generatePermutations( a, output, 0 );
        return output;
    }

    private static void generatePermutations(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, int index) {


        if ( index == a.size()){
            output.add(new ArrayList<Integer>(a));
        } else {
            for (int i = index; i < a.size() ; i++) {
                Collections.swap(a,i,index);
                generatePermutations(a,output,index +1);
                Collections.swap(a,index,i);
            }
        }
    }


}

/* SOLUTION APPROACH

*/



/*/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=49582:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/charsets.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/classes.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/jsse.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/ui.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/deploy.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/apple_provider.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/javaws.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/jce.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/plugin.jar:/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/sa-jdi.jar:/Users/apple/IdeaProjects/untitled1/out/production/untitled1 Questions.Permutations
6 1 3 4 2 7 8
 PERMUTATION 1 : 1 3 4 2 7 8
 PERMUTATION 2 : 1 3 4 2 8 7
 PERMUTATION 3 : 1 3 4 7 2 8
 PERMUTATION 4 : 1 3 4 7 8 2
 PERMUTATION 5 : 1 3 4 8 7 2
 PERMUTATION 6 : 1 3 4 8 2 7
 PERMUTATION 7 : 1 3 2 4 7 8
 PERMUTATION 8 : 1 3 2 4 8 7
 PERMUTATION 9 : 1 3 2 7 4 8
 PERMUTATION 10 : 1 3 2 7 8 4
 PERMUTATION 11 : 1 3 2 8 7 4
 PERMUTATION 12 : 1 3 2 8 4 7
 PERMUTATION 13 : 1 3 7 2 4 8
 PERMUTATION 14 : 1 3 7 2 8 4
 PERMUTATION 15 : 1 3 7 4 2 8
 PERMUTATION 16 : 1 3 7 4 8 2
 PERMUTATION 17 : 1 3 7 8 4 2
 PERMUTATION 18 : 1 3 7 8 2 4
 PERMUTATION 19 : 1 3 8 2 7 4
 PERMUTATION 20 : 1 3 8 2 4 7
 PERMUTATION 21 : 1 3 8 7 2 4
....
 PERMUTATION 703 : 8 1 2 4 7 3
 PERMUTATION 704 : 8 1 2 4 3 7
 PERMUTATION 705 : 8 1 2 7 4 3
 PERMUTATION 706 : 8 1 2 7 3 4
 PERMUTATION 707 : 8 1 2 3 7 4
 PERMUTATION 708 : 8 1 2 3 4 7
 PERMUTATION 709 : 8 1 7 2 4 3
 PERMUTATION 710 : 8 1 7 2 3 4
 PERMUTATION 711 : 8 1 7 4 2 3
 PERMUTATION 712 : 8 1 7 4 3 2
 PERMUTATION 713 : 8 1 7 3 4 2
 PERMUTATION 714 : 8 1 7 3 2 4
 PERMUTATION 715 : 8 1 3 2 7 4
 PERMUTATION 716 : 8 1 3 2 4 7
 PERMUTATION 717 : 8 1 3 7 2 4
 PERMUTATION 718 : 8 1 3 7 4 2
 PERMUTATION 719 : 8 1 3 4 7 2
 PERMUTATION 720 : 8 1 3 4 2 7

Time taken : 8051000
 PERMUTATION 1 : 1 3 4 2 7 8
 PERMUTATION 2 : 1 3 4 2 8 7
 PERMUTATION 3 : 1 3 4 7 2 8
 PERMUTATION 4 : 1 3 4 7 8 2
 PERMUTATION 5 : 1 3 4 8 7 2
 PERMUTATION 6 : 1 3 4 8 2 7
 PERMUTATION 7 : 1 3 2 4 7 8
 PERMUTATION 8 : 1 3 2 4 8 7
 PERMUTATION 9 : 1 3 2 7 4 8
 PERMUTATION 10 : 1 3 2 7 8 4
 PERMUTATION 11 : 1 3 2 8 7 4
 PERMUTATION 12 : 1 3 2 8 4 7
 PERMUTATION 13 : 1 3 7 2 4 8
 PERMUTATION 14 : 1 3 7 2 8 4
 PERMUTATION 15 : 1 3 7 4 2 8
....
 PERMUTATION 692 : 8 7 1 2 4 3
 PERMUTATION 693 : 8 7 1 3 2 4
 PERMUTATION 694 : 8 7 1 3 4 2
 PERMUTATION 695 : 8 7 1 4 3 2
 PERMUTATION 696 : 8 7 1 4 2 3
 PERMUTATION 697 : 8 1 4 2 7 3
 PERMUTATION 698 : 8 1 4 2 3 7
 PERMUTATION 699 : 8 1 4 7 2 3
 PERMUTATION 700 : 8 1 4 7 3 2
 PERMUTATION 701 : 8 1 4 3 7 2
 PERMUTATION 702 : 8 1 4 3 2 7
 PERMUTATION 703 : 8 1 2 4 7 3
 PERMUTATION 704 : 8 1 2 4 3 7
 PERMUTATION 705 : 8 1 2 7 4 3
 PERMUTATION 706 : 8 1 2 7 3 4
 PERMUTATION 707 : 8 1 2 3 7 4
 PERMUTATION 708 : 8 1 2 3 4 7
 PERMUTATION 709 : 8 1 7 2 4 3
 PERMUTATION 710 : 8 1 7 2 3 4
 PERMUTATION 711 : 8 1 7 4 2 3
 PERMUTATION 712 : 8 1 7 4 3 2
 PERMUTATION 713 : 8 1 7 3 4 2
 PERMUTATION 714 : 8 1 7 3 2 4
 PERMUTATION 715 : 8 1 3 2 7 4
 PERMUTATION 716 : 8 1 3 2 4 7
 PERMUTATION 717 : 8 1 3 7 2 4
 PERMUTATION 718 : 8 1 3 7 4 2
 PERMUTATION 719 : 8 1 3 4 7 2
 PERMUTATION 720 : 8 1 3 4 2 7

Time taken : 3463000

Process finished with exit code 0
*/