package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Please Note:

Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
*/

//Input : 
// Expected :
// My Code : 

public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*String haystack = "babbaaabaaaabbababaaabaabbbbabaaaabbabbabaaaababbabbbaaabbbaaabbbaabaabaaaaababbaaaaaabababbbbba";
        String needle = "bababbbbbbabbbaabbaaabbbaababa";*/
        /*String haystack = "kansjsjsjjsav";
        String needle = "kanav";*/
//        String haystack = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
//        String needle = "babaaa";
        String haystack = "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb";
        String needle = "bba";
//        String input = "cccb";
        //String input = "";

        /*int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }*/
        long start = System.nanoTime();
        //call function here.....
        System.out.println(strStr(haystack,needle));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }



    public static  int strStr(final String haystack, final String needle) {
        int haystackSize = haystack.length(), needleSize = needle.length();
        if ( needleSize == 0 || haystackSize==0) return 0;
        if ( haystackSize < needleSize) return -1;

        int haystackCursor=0, needleCursor=0;

        while (haystackCursor < haystackSize && needleCursor < needleSize){
            if ( needle.charAt(needleCursor) == haystack.charAt(haystackCursor)) {
                needleCursor++;
                haystackCursor++;
            }else {
                if ( needleCursor < needleSize )  needleCursor=0;
                if ( needle.charAt(needleCursor) == haystack.charAt(haystackCursor)){
                    needleCursor++;
                    haystackCursor++;
                }else
                    haystackCursor++;
            }
        }
        if ( needleCursor == needleSize) return haystackCursor - needleCursor;
        else if ( haystackCursor == haystackSize && needleCursor < needleSize) return -1;

        return 2;
    }
}

/* SOLUTION APPROACH

*/