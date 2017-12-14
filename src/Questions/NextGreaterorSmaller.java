package Questions;

import algorithmsBasics.ListNode;

import java.util.*;

/* QUESTION

NEXT GREATER
Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
More formally,

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]
Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]
Output : [-1, -1, -1]






NEAREST SMALLER
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that
    j is maximum possible AND
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10, 8]
Return : [-1, 4, -1, 2, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]
*/

/*  Input :

8 1 3 -1 -3 5 3 6 7
1   3   -1  -3  4   3   6   7
1   4   6   7
3   4   4   4   6   6   7   -1


41 718 622 531 279 442 893 282 875 252 70 402 663 22 69 611 412 302 840 589 668 346 983 227 23 703 818 100 943 728 305 72 772 35 721 550 12 405 454 902 978 579

8 2 1 3 7 4 6 8 10 10

A : [ 8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34 ]
22 8 23 22 16 22 7 7 27 35 27 32 20 5 1 35 28 20 6 16 26 48 34
    23 27 27 22 27 27 27 35 48 32 35 35 35 35 48 48 26 16 26 48 -1 -1
    23 27 22 22 27 27 27 35 35 32 35 35 35 35 48 48 26 16 26 48 -1 -1


    Expected :
    My Code :


    -1 -1 1 3 3 4 6 8

    -1 -1 1 3 3 4 6 8
    -1 1 3 3 4 6 8




    718 622 531 279 442 893 282 875 252 70 402 663 22 69 611 412 302 840 589 668 346 983 227 23 703 818 100 943 728 305 72 772 35 721 550 12 405 454 902 978 579
    -1 -1 -1 -1 279 442 279 282 -1 -1 70 402 -1 22 69 69 69 302 302 589 302 346 69 22 23 703 23 100 100 100 23 72 23 35 35 -1 12 405 454 902 454
    -1 -1 -1 -1 279 442 279 282 -1 -1 70 402 -1 22 69 69 69 302 302 589 302 346 69 22 23 703 23 100 100 100 23 72 23 35 35 -1 12 405 454 902 454
    -1 -1 -1 -1 279 442 279 282 -1 -1 70 402 -1 22 69 69 69 302 302 589 302 346 69 22 23 703 23 100 100 100 23 72 23 35 35 -1 12 405 454 902 454


*/

public class NextGreaterorSmaller {
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
        ArrayList<Integer> output = nextGreater(inputList);
        long end = System.nanoTime();
        for (int x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


        start = System.nanoTime();
        //call function here.....
        output = nextGreaterSTACK(inputList);
        end = System.nanoTime();
        for (int x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        output = prevSmallerBEST(inputList);
         end = System.nanoTime();
        for (int x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        output = prevSmaller(inputList);
        end = System.nanoTime();
        for (int x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));
    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> a) {

        ArrayList<Integer> nextBig = new ArrayList<Integer>();
        ListNode head = null, temp = null;


        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > a.get(i - 1)) {
                if (head == null) {
                    head = new ListNode(i);
                    temp = head;
                } else {
                    temp.next = new ListNode(i);
                    temp = temp.next;
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            temp = head;
            while (temp != null && (temp.val <= i || a.get(temp.val) <= a.get(i))) {
                if ( temp.val <= i ) head = temp;
                temp = temp.next;
            }
            if (temp != null) nextBig.add(a.get(temp.val));
            else nextBig.add(-1);
        }
        return nextBig;
    }


    public static ArrayList<Integer> nextGreaterSTACK(ArrayList<Integer> a) {
//8 2 1 3 7 4 6 8 10 10

        ArrayList<Integer> nextBig = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();

        for (int i = a.size()-1; i >= 0; i--) {
            while (!st.isEmpty() && (a.get(i) >= st.peek() )) st.pop();

            if ( st.isEmpty()) nextBig.add(-1);
            else nextBig.add(st.peek());
            st.push(a.get(i));

        }
        Collections.reverse(nextBig);
        return nextBig;



    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> a){

        ArrayList<Integer> prevSmall = new ArrayList<Integer>();
        ListNode head = null, temp = null,prev;


        for (int i = a.size()-1; i > 0; i--) {
            if (a.get(i) > a.get(i - 1)) {
                if (head == null) {
                    head = new ListNode(i-1);
                    temp = head;
                } else {
                    temp.next = new ListNode(i-1);
                    temp = temp.next;
                }
            }
        }
        for (int i = a.size()-1; i >= 0; i--) {
            temp = head;
            while (temp != null && ( temp.val >= i  || a.get(temp.val) >= a.get(i)) ) {
                if ( temp.val >= i) head = temp;
                temp = temp.next;
            }
            if (temp!= null) prevSmall.add(a.get(temp.val));
            else prevSmall.add(-1);
        }

        Collections.reverse(prevSmall);
        return prevSmall;
    }

    public static ArrayList<Integer> prevSmallerBEST(ArrayList<Integer> arr) {
        ArrayList<Integer> retval=new ArrayList<Integer>();
        Stack<Integer> st=new Stack<Integer>();

        for(int i=0;i<arr.size();++i){
            while(!st.isEmpty() && arr.get(i)<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                retval.add(-1);
            }
            else{
                retval.add(st.peek());
            }
            st.add(arr.get(i));
        }

        return retval;
    }


}

/* SOLUTION APPROACH

*/