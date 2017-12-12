package Questions;

import algorithmsBasics.ListNode;

import java.util.*;

/* QUESTION
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max

[1 3 -1] -3 5 3 6 7	    3
1 [3 -1 -3] 5 3 6 7	    3
1 3 [-1 -3 5] 3 6 7	    5
1 3 -1 [-3 5 3] 6 7	    5
1 3 -1 -3 [5 3 6] 7	    6
1 3 -1 -3 5 [3 6 7]	    7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array.
*/

/*  Input :
8 1 3 -1 -3 5 3 6 7
3

10 10 9 8 7 6 5 4 3 2 1
2

A : [ 718, 622, 531, 279, 442, 893, 282, 875, 252, 70, 402, 663, 22, 69, 611, 412, 302, 840, 589, 668, 346, 983, 227, 23, 703, 818, 100, 943, 728, 305, 72, 772, 35, 721, 550, 12, 405, 454, 902, 978, 579 ]
B : 9

41 718 622 531 279 442 893 282 875 252 70 402 663 22 69 611 412 302 840 589 668 346 983 227 23 703 818 100 943 728 305 72 772 35 721 550 12 405 454 902 978 579
9

    Expected : 893 893 893 893 893 893 875 875 663 840 840 840 840 983 983 983 983 983 983 983 983 983 943 943 943 943 943 943 772 772 902 978 978

    My Code : 893 893 893 893 893 893 622 622 622 622 622 622 622 983 983 983 983 983 983 983 983 983 943 943 943 943 943 943 772 772 902 978 978
    893 893 893 893 893 893 875 875 663 840 840 840 840 983 983 983 983 983 983 983 983 983 943 943 943 943 943 943 772 772 902 978 978


A : [ 268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592, 571, 559, 374, 910, 610, 561, 489, 647, 246, 355, 313, 158, 922, 557, 36, 430, 983, 913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129, 952, 159, 250, 546, 508, 540, 948, 429, 174 ]
B : 6

62 268 202 139 744 502 582 94 81 117 258 506 461 531 768 827 128 592 571 559 374 910 610 561 489 647 246 355 313 158 922 557 36 430 983 913 303 765 945 167 340 869 869 609 809 529 715 34 13 657 407 684 801 129 952 159 250 546 508 540 948 429 174
6

744 744 744 744 582 582 506 531 768 827 827 827 827 827 827 910 910 910 910 910 910 647 647 647 922 922 922 922 983 983 983 983 983 983 945 945 945 945 869 869 869 869 809 809 715 715 801 801 952 952 952 952 952 952 948 948 948
 Run as custom input

744 744 744 744 582 582 506 531 768 827 827 827 827 827 827 910 910 910 910 910 910 647 647 647 922 922 922 922 983 983 983 983 983 983 945 945 945 945 869 869 869 869 809 809 715 715 801 801 952 952 952 952 952 952 948 948 948



*/

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int window = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> output = slidingMaximum(inputList, window);
        long end = System.nanoTime();
        for (int x : output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

    }

    static class MaxStack {
        private Stack<Integer> normalStack;
        private Stack<Integer> maxChangesStack;

        public void push(int x) {
            if (normalStack == null) normalStack = new Stack<Integer>();
            if (maxChangesStack == null) maxChangesStack = new Stack<Integer>();
            if (maxChangesStack.empty()) maxChangesStack.push(x);
            else {
                if (x > maxChangesStack.peek()) maxChangesStack.push(x);
            }
            normalStack.push(x);
        }

        public void pop() {
            if (normalStack == null) return;
            if (normalStack.empty()) return;
            if (normalStack.peek().intValue() == maxChangesStack.peek().intValue()) {
                normalStack.pop();
                maxChangesStack.pop();
            } else normalStack.pop();
        }

        public int top() {
            if (normalStack == null) return -1;
            if (normalStack.empty()) return -1;
            return normalStack.peek();
        }

        public int getMax() {
            if (normalStack == null) return -1;
            if (maxChangesStack.empty() || normalStack.empty()) return -1;
            return maxChangesStack.peek();
        }


    }

    // DO NOT MODIFY THE LIST
    public static ArrayList<Integer> slidingMaximumfail(final List<Integer> a, int b) {

        Queue<Integer> window = new LinkedList<Integer>();

        MaxStack max = new MaxStack();

        ArrayList<Integer> maxOfWindow = new ArrayList<Integer>();

        for (int i = 0; i < a.size() - b + 1; i++) {
            if (window.isEmpty()) {
                for (int j = i; j < b; j++) {
                    window.add(a.get(j));
                    max.push(a.get(j).intValue());
                }
            } else {
                window.remove();
                if (max.getMax() == a.get(i - 1).intValue()) {
                    while (max.top() != a.get(i - 1).intValue()) max.pop();
                    max.pop();
                }
                window.add(a.get(i + b - 1));
                max.push(a.get(i + b - 1));
            }
            maxOfWindow.add(max.getMax());
        }
        return maxOfWindow;
    }


    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {


        Deque<Integer> deque = new LinkedList<Integer>();


        ArrayList<Integer> maxOfWindow = new ArrayList<Integer>();

        for (int j = 0; j < b; j++) {
            while (!deque.isEmpty() && a.get(deque.peekLast()) <= a.get(j).intValue()) deque.removeLast();
            if (deque.isEmpty() || a.get(deque.peekLast()) > a.get(j).intValue()) deque.addLast(j);
        }
        maxOfWindow.add(a.get(deque.getFirst()));
        for (int i = b; i < a.size(); i++) {

            if (!deque.isEmpty() && deque.getFirst() <= i - b) deque.removeFirst();
            while (!deque.isEmpty() && a.get(deque.peekLast()) <= a.get(i) ) deque.removeLast();
            if (deque.isEmpty() ||a.get(deque.peekLast()) > a.get(i) )
                deque.addLast(i);

            maxOfWindow.add(a.get(deque.getFirst()));

        }
        return maxOfWindow;
    }


}

/* SOLUTION APPROACH

Approach 1 :

The obvious brute force solution with run time complexity of O(nw) is definitely not efficient enough. Every time the window is moved, you have to search for a total of w elements in the window.

Approach 2:

A heap data structure quickly comes to mind. We could boost the run time to approximately O(n lg w) (Note that I said approximately because the size of the heap changes constantly and averages about w). Insert operation takes O(lg w) time, where w is the size of the heap. However, getting the maximum value is cheap, it merely takes constant time as the maximum value is always kept in the root (head) of the heap.

As the window slides to the right, some elements in the heap might not be valid anymore (range is outside of the current window). How should you remove them? You would need to be somewhat careful here. Since you only remove elements that are out of the window’s range, you would need to keep track of the elements’ indices too.

TIme complexity : O ( n log n ). Not good enough.

Approach 3 :

A double-ended queue should do the trick here.
The double-ended queue is the perfect data structure for this problem. It supports insertion/deletion from the front and back. The trick is to find a way such that the largest element in the window would always appear in the front of the queue. How would you maintain this requirement as you push and pop elements in and out of the queue?

The double-ended queue is the perfect data structure for this problem. It supports insertion/deletion from the front and back. The trick is to find a way such that the largest element in the window would always appear in the front of the queue. How would you maintain this requirement as you push and pop elements in and out of the queue?

You might notice that there are some redundant elements in the queue that we shouldn’t even consider about. For example, if the current queue has the elements: [10 5 3], and a new element in the window has the element 11. Now, we could have emptied the queue without considering elements 10, 5, and 3, and insert only element 11 into the queue.

A natural way most people would think is to try to maintain the queue size the same as the window’s size. Try to break away from this thought and try to think outside of the box. Removing redundant elements and storing only elements that need to be considered in the queue is the key to achieve the efficient O(n) solution.

Method 3 (A O(n) method: use Dequeue)
We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements. An element is useful if it is in current window and is greater than all other elements on left side of it in current window. We process all array elements one by one and maintain Qi to contain useful elements of current window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at rear of Qi is the smallest of current window. Thanks to Aashish for suggesting this method.

Following is the implementation of this method.



*/