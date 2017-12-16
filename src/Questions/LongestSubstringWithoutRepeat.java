package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* QUESTION
Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int inputListSize = sc.nextInt();
//
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
//        String in = "abcabcbb";
        String in = "aabbcabddcbcdabb";
        //String in = "abcabcbb";
        long start = System.nanoTime();
        //call function here.....
        System.out.println(lengthOfLongestSubstring(in));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static  int lengthOfLongestSubstring(String a) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        int left =0,right=0,len=0;
        while (left < a.length() && right < a.length()){

            while (right < a.length() && (!map.containsKey(a.charAt(right)) || (map.containsKey(a.charAt(right)) && map.get(a.charAt(right)) < left)) ) {
                map.put(a.charAt(right),right);
                right++;
            }
            if ( right - left > len ) len = right - left;

            while (left < a.length() && (right < a.length() && a.charAt(left) != a.charAt(right))) left++;

            left++;

        }
        return len;
    }
}

/* SOLUTION APPROACH

*/