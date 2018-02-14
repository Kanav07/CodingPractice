package Questions;

import apple.laf.JRSUIUtils;

import java.util.*;

/* QUESTION

Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 or a combination of them as their prime factors.

Example:

Input :
Prime numbers : [2,3,5]
k : 5

If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be:

Output:
{2,3,4,5,6}

Explanation :
4 = p1 * p1 ( 2 * 2 )
6 = p1 * p2 ( 2 * 3 )

Note: The sequence should be sorted in ascending order

*/

/*  

Input : 
Expected :
My Code : 

Input : 2 5 11 3
Expected :
My Code : 


3
11
7
50

3 7 9 11 21 27 33 49 63 77 81 99 121 147 189 231 243 297 343 363 441 539 567 693 729 847 891 1029 1089 1323 1331 1617 1701 2079 2187 2401 2541 2673 3087 3267 3773 3969 3993 4851 5103 5929 6237 6561 7203 7623

[3, 7, 9, 11, 21, 27, 33, 49, 63, 77, 81, 99, 121, 147, 189, 231, 243, 297, 343, 363, 441, 539, 567, 693, 729, 847, 891, 1029, 1089, 1323, 1331, 1617, 1701, 2079, 2187, 2401, 2541, 2673, 3087, 3267, 3773, 3969, 3993, 4851, 5103, 5929, 6237, 6561, 7203, 7623]

*/

public class SmallestSequenceWithGivenPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int inputListSize = sc.nextInt();
//
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(A,B,C,D));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }


    public static ArrayList<Integer> solve(int A, int B, int C, int D) {
        TreeSet<Integer> res = new TreeSet<Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(A);
        list.add(B);
        list.add(C);
        Collections.sort(list);

        TreeSet<Integer> queue = new TreeSet<Integer>();
        queue.addAll(list);
        while (res.size() < D || (res.size()!=0 && queue.first() < res.last())){
            int x = queue.first();
            queue.remove(x);
            res.add(x);
            for (int y : list) queue.add(x*y);
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        Iterator itr = res.iterator();
        while (itr.hasNext() && output.size()!=D) output.add((Integer) itr.next());
        return output;
    }




}

/* SOLUTION APPROACH

            1
         /  |   \
       /    |    \
    a       b       c
   /|\     /|\     /|\
  a b c   a b c   a b c
/|\/|\/|\/|\/|\/|\/|\/|\/|\

Do a BFS on the above graph
Maintain a TreeSet of numbers. Exit when size reaches target size
*/