package Questions;

import java.util.*;

/* QUESTION

Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

*/

/*

Input : 20 2 21 1 2 4 3 3 3 1 4 6 7 8 9 17 2 1 4 3 6
Expected : 0 1 10 14
My Code :

Input : 10 2 2 3 3  4 6 7 8 9 17
Expected :  0 2 1 3
My Code :

Input : 24 9 5 4 9 3 6 8 7 1 2 8 7 2 9 7 1 3 9 7 8 1 0 5 5

Expected : 0 1 3 22
My Code :

Input :
Expected :
My Code :

Input :
Expected :
My Code :

*/

public class EqualSum {
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
        ArrayList<Integer> output = equal(inputList);
        long end = System.nanoTime();
        for (Integer x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

    }

    static class Key {

        int first;
        int second;

        public Key(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }


    public static ArrayList<Integer> equal(ArrayList<Integer> a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a.size() < 2) return result;
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE, index3 = Integer.MAX_VALUE, index4 = Integer.MAX_VALUE;

        HashMap<Integer,Key> SumMap = new HashMap<Integer,Key>();
        Key temp = new Key(0, 0);

        for (int i = 0; i < a.size()-1; i++) {
            for (int j = i+1; j < a.size(); j++) {
                int indexC = i;
                int indexD = j;
                int sum = a.get(i) + a.get(j);
                if ( !SumMap.containsKey(sum) )SumMap.put(sum, new Key(indexC,indexD));
                else {
                    int indexA = SumMap.get(sum).first;
                    int indexB = SumMap.get(sum).second;
                    if ( indexA < indexB && indexC < indexD && indexA <indexC && indexB != indexC && indexB != indexD && ((indexA < index1) || (indexA == index1 && indexB < index2)  || (indexA == index1 && indexB == index2 && indexC < index3) || (indexA == index1 && indexB == index2 && indexC == index3 && indexD < index4))) {
                        index1 = indexA;
                        index2 = indexB;
                        index3 = indexC;
                        index4 = indexD;
                    }
                }
            }
        }

        if (index1 == Integer.MAX_VALUE) return result;

        result.add(index1);
        result.add(index2);
        result.add(index3);
        result.add(index4);
        return result;

    }

    public static ArrayList<Integer> equalFAIL(ArrayList<Integer> a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a.size() < 2) return result;
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE, index3 = Integer.MAX_VALUE, index4 = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> repeat = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            if (!map.containsKey(temp)) {
                map.put(temp, i);
            } else {
                if (!repeat.containsKey(temp)) repeat.put(temp, i);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            int numA = a.get(i);
            int indexA = map.get(numA);
            for (int j = i; j < a.size(); j++) {
                int numB = a.get(i);
                int indexB = map.get(numB);
                ArrayList<Integer> temp = twoSum(a.subList(i, a.size() - 1), numA + numB);
                if (temp != null && temp.size() != 0) {
                    int indexC = temp.get(0);
                    int indexD = temp.get(1);
                    if (indexB != indexC && indexB != indexD && ((indexA < index1) || (indexA == index1 && indexB < index2)  || (indexA == index1 && indexB == index2 && indexC < index3) || (indexA == index1 && indexB == index2 && indexC == index3 && indexD < index4))) {
                        index1 = indexA;
                        index2 = indexB;
                        index3 = indexC;
                        index4 = indexD;
                    }
                }
            }
        }

        if (index1 == Integer.MAX_VALUE) return result;

        result.add(index1);
        result.add(index2);
        result.add(index3);
        result.add(index4);
        return result;

    }

    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a.size() < 2) return result;
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> repeat = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            if (!map.containsKey(temp)) {
                map.put(temp, i + 1);
            } else {
                if (!repeat.containsKey(temp)) repeat.put(temp, i + 1);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            int num1 = map.get(temp);

            if (map.containsKey(b - temp)) {
                int num2 = map.get(b - temp);
                if (num1 < num2) {
                    if (num1 < index1) {
                        index2 = num2;
                        index1 = num1;
                    } else if (num1 == index1) {
                        if (num2 < index2) {
                            index1 = num1;
                            index2 = num2;
                        }
                    }
                }
            }

            if (repeat.containsKey(b - temp)) {
                int num2 = repeat.get(b - temp);
                if (num1 < num2) {
                    if (num1 < index1) {
                        index2 = num2;
                        index1 = num1;
                    } else if (num1 == index1) {
                        if (num2 < index2) {
                            index1 = num1;
                            index2 = num2;
                        }
                    }
                }
            }
        }
        if (index1 == Integer.MAX_VALUE) return result;

        result.add(index1);
        result.add(index2);
        return result;
    }

}

/* SOLUTION APPROACH

*/