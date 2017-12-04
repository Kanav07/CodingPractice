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
//        String needle = "aabaabaaa";
        String haystack = "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb";
        String needle = "bba";
//        String haystack = "baabaaabbbababbbbbbaababbbaabbbbaabababababbaa";
//        String needle = "babbabaabababbbababaababbaabbbaaaabaaabbab";

        /*int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }*/
        long start = System.nanoTime();
        //call function here.....
        System.out.println(strStr(haystack, needle));

        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        System.out.println(strStrKMPAlgorithm(haystack, needle));
        end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }


    public static int strStr(final String haystack, final String needle) {
        int haystackSize = haystack.length(), needleSize = needle.length();
        if (needleSize == 0 || haystackSize == 0) return 0;
        if (haystackSize < needleSize) return -1;

        int haystackCursor = 0, needleCursor = 0;

        while (haystackCursor < haystackSize && needleCursor < needleSize) {
            if (needle.charAt(needleCursor) == haystack.charAt(haystackCursor)) {
                needleCursor++;
                haystackCursor++;
            } else {
                if (needleCursor > 0 && needleCursor < needleSize) {
                    haystackCursor = haystackCursor - needleCursor + 1;
                    needleCursor = 0;
                }
                if (haystackCursor < haystackSize && needle.charAt(needleCursor) == haystack.charAt(haystackCursor)) {
                    needleCursor++;
                    haystackCursor++;
                } else
                    haystackCursor++;
            }
        }
        if (needleCursor == needleSize) return haystackCursor - needleCursor;
        else if (haystackCursor == haystackSize && needleCursor < needleSize) return -1;

        return -1;
    }

//https://www.youtube.com/watch?v=GTJr8OvyEVQ

    public static int strStrKMPAlgorithm(final String haystack, final String needle) {

        int haystackSize = haystack.length(), needleSize = needle.length();
        if (needleSize == 0 || haystackSize == 0) return 0;
        if (haystackSize < needleSize) return -1;

        //preparing the LPS array
        int[] LPS = new int[needleSize];
        LPS[0] = 0;
        for (int i = 0, j = 1; j < needleSize && i < needleSize; ) {
            if (needle.charAt(i) != needle.charAt(j)) {
                if (i > 0) {
                    while (i > 0) {
                        if (needle.charAt(i) == needle.charAt(j)) {
                            LPS[j] = LPS[i] + 1;
                            i++;
                            j++;
                            break;
                        } else {
                            i = LPS[i - 1];
                        }
                    }
                } else {
                    LPS[j] = 0;
                    j++;
                }
            } else {
                LPS[j] = i + 1;
                i++;
                j++;
            }
        }

        for (int i = 0, j = 0; i < haystackSize && j < needleSize; ) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
                if (j == needleSize) return i - j;
            } else {
                if (j > 0) j = LPS[j - 1];
                else i++;
            }
        }
        return -1;


    }
}

/* SOLUTION APPROACH

*/