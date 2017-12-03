package Questions.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

/*Count Element Occurence
        Given a sorted array of integers, find the number of occurrences of a given target value.
        Your algorithm’s runtime complexity must be in the order of O(log n).
        If the target is not found in the array, return 0

        **Example : **
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return 2.*/


//Input : 10 2 2 3 3 4 6 7 8 9 17
// Expected :
// My Code : A : [ 34 1 1 2 2 2 2 3 3 3 3 3 3 3 4 4 5 5 5 5 5 6 6 6 7 7 8 8 8 8 9 9 10 10 10 ]


//Input : A : [ 33 1 1 2 2 2 2 3 3 3 3 3 3 3 4 4 5 5 5 5 5 6 6 6 7 7 8 8 8 8 9 9 10  10 ]
// Expected :
// My Code : 

// [7  4 7 7 7 8 10 10 ]

//5 1 2 6 9 9

// A : [493 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 ]



//Input : A : [ 370  1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 ]
// 2
// Expected : 37
// My Code : 31


//A : [ 514 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 ]
// 54
public class CountElementsOlognONLY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int find = sc.nextInt();

        long start = System.nanoTime();
        //call function here.....
        int countFind = findCount(inputList, find);
        long end = System.nanoTime();
        System.out.println(countFind);
        System.out.println("\nTime taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        countFind = findCountModified(inputList, find);
        end = System.nanoTime();
        System.out.println(countFind);
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int findCount(final List<Integer> a, int b) {
        int size = a.size(), index = BinarySearch(a, b, 0, size - 1), highindex = index;
        if (index == -1) return -1;
        else {
            while (index >= 0) {
                if (BinarySearch(a, b, 0, index) == -1) break;
                else index--;
            }
            while (highindex < size) {
                if (BinarySearch(a, b, highindex, size - 1) == -1) break;
                else highindex++;
            }
            return highindex - index - 1;
        }
    }

    public static int BinarySearch(List<Integer> list, int find, int start, int end) {
        int mid = start + (end - start) / 2;
        if (list.get(start) > find || list.get(end) < find) return -1;
        if (list.get(mid) == find) return mid;
        else {
            if (end - start == 0) return -1;
            if (list.get(mid) < find) return BinarySearch(list, find, mid + 1, end);
            else return BinarySearch(list, find, start, mid - 1);
        }
    }


    public static int findCountModified(final List<Integer> a, int b) {
        int low = 0, high = a.size() - 1, size = high + 1, mid = -1, first, last;
        boolean found = false;
// Find instance of b by normal Binary Search
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a.get(mid) == b) {
                found = true;
                break;
            }
            if (a.get(mid) > b) high = mid - 1;
            else low = mid + 1;
        }
// Variable mid has the index of an occurence of the number b.
// This Index could be :
        // - first occurence     => first occurence can be directly stored +  Binary search for the last occurence
        // - last occurence      => last occurence can be directly stored +  Binary search for the first occurence
        // - only occurence      => return from function
        //- one of the occurence, but not the first or last   ==> Binary search for both first & last occurence

        if (mid == -1  || !found) {
            return 0; // return if element is not found
        } else {
            // First we will search for the first occurence of the number b, which will be present in the subarray [ 0,mid]. Hence low & high initialised accordingly
            low = 0;
            high = mid;
            if (mid == low) {                    // first occurence check - if start of array then obviously it is first occurence
                first = mid;
            } else if (a.get(mid - 1) != b) {   // first occurence check - if previous element not 'b' then this is the start
                first = mid;
            } else {                            // this is not the start. Set first to the middle of the low & mid
                first = low + (mid - low) / 2;

                //    low------------first--------------------high
                while (low <= high) {             //first occurence will be found by Binary search


                    if (a.get(first) < b) {                     // if 'first' points to an element lower than 'b', then we have come before the first occurence of b [ because array is sorted ], we need to increase 'first'
                        //   low------------first--------***************high
                        low = first;                            // now search space can be reduced to the present element & high
                        first = first + abs(high - first) / 2;  // first will be in the other half of the search space
                    } else {
                        if (abs(low - first) <= 1) {
                            if (low == 0 && low < first)
                                first--;                        // for extreme end elements the loop will be stuck since first will never be increased to low, Hence this special check is needed
                            break;
                        } else if (a.get(first - 1) != b) break;       //check if current index is the first
                        else {
                            //low--------------------*****first**********high
                            high = first;                       // now search space can be reduced to the present element & low
                            first = first - abs(low - first) / 2; // first will be in the other half of the search space
                        }
                    }
                }
            }
            low = mid;
            high = a.size() - 1;
            if (mid == high) {
                last = mid;
            } else if (a.get(mid + 1) != b) {
                last = mid;
            } else {
                last = mid + (high - mid) / 2;

                while ( low <= high) {
                    if (a.get(last) > b) {
                        high = last;
                        last = last - abs(last - low) / 2;
                    } else {
                        if (abs(high - last) <= 1) {
                            if (high == a.size() - 1 && high > last) last++;
                            break;
                        } else if (a.get(last + 1) != b) break;
                        else {
                            low = last;
                            last = last + abs(high - last) / 2 ;
                        }
                    }
                }
            }
            return last - first + 1;
        }
    }

}




/*First, let us find the left boundary of the range.
We initialize the range to [low=0, high=n-1]. In each step, calculate the middle element [mid = (low+j)/2].

Now according to the relative value of A[mid] to target, there are three possibilities:

If A[mid] < target, then the range must begin on the right of mid (hence low= mid+1 for the next iteration)

If A[mid] > target, it means the range must begin on the left of mid (high = mid-1)

If A[mid] = target, then the range must begins on the left of or at mid (high= mid)

Since we would move the search range to the same side for case 2) and 3), we might as well merge them as one single case so that less code is needed:

2*. If A[mid] >= target, high = mid;

Surprisingly, 1 and 2* are the only logic you need to put in loop while (low < high). When the while loop terminates, the value of low/high is where the start of the range is. Why?

No matter what the sequence originally is, as we narrow down the search range, eventually we will be at a situation where there are only two elements in the search range.

Suppose our target is 5, then we have only 7 possible cases:

Case 1: [5 7] (A[low] = target < A[high])

Case 2: [5 3] (A[low] = target > A[high])

Case 3: [5 5] (A[low] = target = A[high])

Case 4: [3 5] (A[high] = target > A[low])

Case 5: [3 7] (A[low] < target < A[high])

Case 6: [3 4] (A[low] < A[high] < target)

Case 7: [6 7] (target < A[low] < A[high])

For case 1, 2 and 3, if we follow the above rule, since mid = low => A[mid] = target in these cases, then we would set high = mid.

Now the loop terminates and i and high both point to the first 5.

For case 4, since A[mid] < target, then set low= mid+1. The loop terminates and both i and high point to 5.

For all other cases, by the time the loop terminates, A[low] is not equal to 5. So we can easily know 5 is not in the sequence if the comparison fails.

In conclusion, when the loop terminates, if A[low]==target, then i is the left boundary of the range; otherwise, just return -1;

For the right of the range, we can use a similar idea. Again we can come up with several rules:

If A[mid] > target, then the range must begin on the left of mid (high = mid-1)

If A[mid] < target, then the range must begin on the right of mid (hence low= mid+1 for the next iteration)

If A[mid] = target, then the range must begins on the right of or at mid (low= mid)

Again, we can merge conditions 2 and 3 into:

2*. If A[mid] <= target, then low= mid;

However, the terminate condition on longer works this time.

Consider the following case:

[5 7], target = 5
Now A[mid] = 5, then according to rule 2), we set low= mid.

This practically does nothing because i is already equal to mid.

As a result, the search range is not moved at all!

The solution is in using a small trick:

Instead of calculating mid as mid = (low=high)/2, we now do:

mid = (low=high)/2+1

Why does this trick work?

When we use mid = (low=high)/2, the mid is rounded to the lowest integer.

In other words, mid is always biased towards the left. This means we could have low== mid when high - low== mid,

but we NEVER have high == mid. So in order to keep the search range moving, we must make sure that the new i is set to something different than mid, otherwise we are at the risk that i gets stuck.

But for the new high, it is okay if we set it to mid, since it was not equal to mid anyway.

Our two rules in search for the left boundary happen to satisfy these requirements, so it works perfectly in that situation.

Similarly, when we search for the right boundary, we must make sure i does not get stuck when we set the new i to low= mid.

The easiest way to achieve this is by making mid biased to the right, i.e. mid = (low=high)/2+1.*/
