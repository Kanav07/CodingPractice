package Questions.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

/* QUESTION
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
*/

//Input : 6 5 7 7 8 8 10
// Expected :
// My Code :


//Input : 10 2 2 3 3 4 6 7 8 9 17
// Expected :
// My Code :


//Input : 370  1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10
// Expected :
// My Code :

public class SearchforaRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int target = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> range = searchRange(inputList,target);
        long end = System.nanoTime();
        for (int x : range) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


        start = System.nanoTime();
        //call function here.....
         range = searchRangeModified(inputList,target);
         end = System.nanoTime();
        for (int x : range) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


        start = System.nanoTime();
        //call function here.....
        range = searchRangeBest(inputList,target);
        end = System.nanoTime();
        for (int x : range) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


        start = System.nanoTime();
        //call function here.....
        range = searchRangeFastest(inputList,target);
        end = System.nanoTime();
        for (int x : range) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


    }

    public static ArrayList<Integer> searchRangeModified(final List<Integer> a, int b) {
        int low = 0, high = a.size()-1, size = high +1,mid = -1,first,last;
        boolean found = false;
        while ( low <=high){
            mid = low + ( high - low)/2;
            if ( a.get(mid) == b ){
                found = true;
                break;
            }
            if ( a.get(mid ) > b ) high = mid-1;
            else low = mid +1;
        }
        ArrayList<Integer> range = new ArrayList<Integer>();


        // Variable mid has the index of an occurence of the number b.
// This Index could be :
        // - first occurence     => first occurence can be directly stored +  Binary search for the last occurence
        // - last occurence      => last occurence can be directly stored +  Binary search for the first occurence
        // - only occurence      => return from function
        //- one of the occurence, but not the first or last   ==> Binary search for both first & last occurence

        if (mid == -1 || !found) {
            range.add(-1);
            range.add(-1);
            return  range;
        }  else {
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
            range.add(first);
            range.add(last);
            return range;
        }


    }



    public static ArrayList<Integer> searchRange(final List<Integer> a, int b)
    {
        ArrayList<Integer> range = new ArrayList<Integer>();
        int first=binarySearch(a,b,true),last = -1;
        if(first==-1){
            range.add(-1);
            range.add(-1);
            return range;
            
        } else
            last = binarySearch(a,b,false);
            range.add(first);
            range.add(last);
            return range;

    }

    public static int binarySearch(List<Integer> a, int b, Boolean first)
    {
        int low=0,high=a.size()-1,result =-1;
	    /*if(high==0 &&  a.get(high)==b)
	        return 1;*/
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a.get(mid)==b)
            {
                result=mid;
                if(first)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if(a.get(mid)>b)
                high=mid-1;
            else
                low=mid+1;
        }
        return result;
    }


    public static ArrayList<Integer> searchRangeBest(final List<Integer> A, int B) {

        int low, up;
        ArrayList<Integer> res = new ArrayList<Integer>();

        low = lowerBound(A, 0, A.size() - 1, B);

        if (low == -1) {
            res.add(-1);
            res.add(-1);
            return res;
        }

        up = upperBound(A, 0, A.size() - 1, B);

        res.add(low);
        res.add(up);

        return res;


    }

    public static int lowerBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int low = -1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                low = mid;
                end = mid - 1;
            }

            steps /= 2;
        }

        return low;

    }

    public static int upperBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int up = end + 1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                up = mid;
                start = mid + 1;
            }

            steps /= 2;
        }

        return up;

    }


    public static ArrayList<Integer> searchRangeFastest(final List<Integer> a, int b) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(getFirstOccurrence(a,0,a.size()-1,b));
        ans.add(getLastOccurrence(a,0,a.size()-1,b));
        return ans;
    }
    private static int getFirstOccurrence(final List<Integer>a, int l, int r, int b) {
        if(l<=r) {
            int m = (l+r)/2;
            if((m==0 || b>a.get(m-1)) && a.get(m)==b) {

                return m;
            }
            if(b>a.get(m)){
                return getFirstOccurrence(a, m+1, r, b);
            }
            else {
                return getFirstOccurrence(a, l, m-1, b);
            }
        }
        return -1;
    }
    private static int getLastOccurrence(final List<Integer>a, int l, int r, int b) {
        if(l<=r) {
            int m = (l+r)/2;
            if((m==a.size()-1 || b<a.get(m+1)) && a.get(m)==b) {
                return m;
            }
            if(b<a.get(m)){
                return getLastOccurrence(a, l, m-1, b);
            }
            else {
                return getLastOccurrence(a, m+1, r, b);
            }
        }
        return -1;
    }
}


/* SOLUTION APPROACH

*/