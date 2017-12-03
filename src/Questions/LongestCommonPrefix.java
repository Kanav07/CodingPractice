package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
*/

//Input :
/* 3
abcdefgh
aefghijk
abcefgh*/
// Expected :
// My Code : 
/*
A : [ 12 aaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ]*/


public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            String input = sc.next();
            inputList.add(input);
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(longestCommonPrefix(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static String longestCommonPrefix(ArrayList<String> a) {
        StringBuffer prefix = new StringBuffer();
        int arraySize = a.size(), flag=1,index=0;
        if ( arraySize < 1) return "";
        if ( arraySize == 1) return a.get(0);
        char c;
        int cursor = -1;
        for (String str : a) {
            if ( str.length() ==0 ) return "";
        }
       while (flag==1){
           cursor++;
           if ( cursor == a.get(0).length()) break ;
           else c = a.get(0).charAt(cursor);
           for (int i = 1; i < arraySize ; i++) {
               if (cursor == a.get(i).length() || a.get(i).charAt(cursor) != c ) {
                   flag = 0;
                   return prefix.toString();
               }
           }
           prefix.append(c);
       }
       return prefix.toString();
    }
}

/* SOLUTION APPROACH

*/