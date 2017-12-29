package Questions;

import java.util.*;

/* QUESTION

You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input :
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output :
actual order is: 5 3 2 1 6 4
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.

*/

/*  

Input : 
Expected :
My Code : 

Input : 2 8 7
2 0 1
Expected :
My Code : 


Your Input: 6 5 3 2 6 1 4
6 1 1 2 0 3 2
Expected output is 6 3 2 1 5 4
*/

public class OrderofPeoplesHeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputList1Size = sc.nextInt();
        ArrayList<Integer> inputList1 = new ArrayList<Integer>();
        for (int i = 0; i < inputList1Size; i++) {
            int inputNumber = sc.nextInt();
            inputList1.add(inputNumber);
        }

        int inputList2Size = sc.nextInt();
        ArrayList<Integer> inputList2 = new ArrayList<Integer>();
        for (int i = 0; i < inputList2Size; i++) {
            int inputNumber = sc.nextInt();
            inputList2.add(inputNumber);
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(orderNEW(inputList1, inputList2));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        System.out.println(orderSEGTREE(inputList1, inputList2));
        end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println(order(inputList1, inputList2));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));




    }

    public static ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), B.get(i));
            result.add(-1);
        }
        Collections.sort(A);
        int result_cursor = 0, index = 0;
        for (int i = 0; i < A.size(); i++) {
            result_cursor = 0;
            ;
            index = 0;
            while (result_cursor != map.get(A.get(i)) && index < A.size()) {
                if (result.get(index) == -1) result_cursor++;
                index++;
            }
            while (result.get(index) != -1 && index < A.size()) index++;
            result.set(index, A.get(i));
        }
        return result;
    }

    public static ArrayList<Integer> orderNEW(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            map.put(A.get(i), B.get(i));
            result.add(-1);
        }
        int result_cursor = 0, index = 0;

        while (map.size() != 0) {
            int key = map.firstKey();
            int value = map.get(key);
            result_cursor = 0;
            ;
            index = 0;
            while (result_cursor != value && index < A.size()) {
                if (result.get(index) == -1) result_cursor++;
                index++;
            }
            while (index < A.size() && result.get(index) != -1) index++;
            result.set(index, key);
            map.remove(key);
        }
        return result;
    }


    public static ArrayList<Integer> orderSEGTREE(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

        quicksort(heights, 0, heights.size() - 1, infronts);
        SegmentTree root = new SegmentTree(heights.get(0));

        for (int i = 1; i < heights.size(); i++) {
            root.insert(heights.get(i), infronts.get(i));
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        root.inorder(output);
        return output;
    }

    public static void quicksort(ArrayList<Integer> ar, int start, int end, ArrayList<Integer> infronts) {
        if (start < end) {
            int middle = partition(ar, start, end, infronts);
            quicksort(ar, start, middle - 1, infronts);
            quicksort(ar, middle + 1, end, infronts);
        }
    }

    public static int partition(ArrayList<Integer> ar, int start, int end, ArrayList<Integer> infronts) {
        int index = start - 1;
        int pivot = ar.get(end);
        int traverse = start;
        while (traverse < end) {
            if (ar.get(traverse) > pivot) {
                index++;
                swap(ar, infronts, traverse, index);
            }
            traverse++;
        }
        index++;
        swap(ar, infronts, traverse, index);
        return index;
    }

    public static void swap(ArrayList<Integer> ar, ArrayList<Integer> offset, int traverse, int index) {
        int temp = ar.get(traverse);
        ar.set(traverse, ar.get(index));
        ar.set(index, temp);

        temp = offset.get(traverse);
        offset.set(traverse, offset.get(index));
        offset.set(index, temp);
    }


    static class SegmentTree {
        SegmentTree left, right;
        int data, value;

        public SegmentTree(int data) {
            this.data = data;
            this.value = 1;
        }

        public  void inorder(ArrayList<Integer> output) {
            if (this.left != null) {
                this.left.inorder(output);
            }
            output.add(this.data);
            if (this.right != null) {
                this.right.inorder(output);
            }
        }

        public  void insert(int data, int value) {
//			SegmentTree newNode = new SegmentTree(data);
            if (value < this.value) {
                this.value += 1;
                if (this.left != null) {
                    this.left.insert(data, value);
                } else {
                    SegmentTree newNode = new SegmentTree(data);
                    this.left = newNode;
                }
            } else {
                if (this.right != null) {
                    this.right.insert(data, value - this.value);
                } else {
                    SegmentTree newNode = new SegmentTree(data);
                    this.right = newNode;
                }
            }
        }
    }
}

/* SOLUTION APPROACH

*/