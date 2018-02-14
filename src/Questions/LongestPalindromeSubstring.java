package Questions;

import java.util.ArrayList;
import java.util.Scanner; 



/* QUESTION
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
*/

//Input : 
// Expected :
// My Code : 

//Input :
// Expected :
// My Code :


public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = "A man, a plan, a canal: Panama";
        //String input = "abacc";
//        String input = "aaaabaaa";
//        String input = "asuuidaieduilababakskssskwjw";
        String input = "cccb";
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
        System.out.println(longestPalindrome(input));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }
    private static class PalindromIndex{
        private int start;
        private int end;

        public PalindromIndex(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static String longestPalindrome(String a) {
        int size = a.length(), palStartOdd=0, palEndOdd=0,palStartEven=0,palEndEven=0, maxLengthPalindrome=0,maxPalStart=0,maxPalEnd=0;
        if (size < 2 ) return a;
        //ArrayList<PalindromIndex> palindromIndices = new ArrayList<PalindromIndex>();

        for (int i = 0; i < size ; i++) {
            // Assume the middle of the palindrome to be i
            // find longest odd length palindrome with a[i] as middle element
            //find longest even length palindrome with a[i] as middle element


            //odd-length palindrome
            if (i > 0 && i < size-1 && a.charAt(i - 1) == a.charAt(i + 1)) {
                palStartOdd = i - 1;
                palEndOdd = i + 1;
                while (palStartOdd >= 0 && palEndOdd < size && a.charAt(palStartOdd) == a.charAt(palEndOdd)) {
                    palStartOdd--;
                    palEndOdd++;
                }
                palStartOdd++;
                palEndOdd--;
            } else {
                palStartOdd = i;
                palEndOdd = i;
            }
            //even length palindrome
            if (i > 0  && a.charAt(i - 1) == a.charAt(i)) {
                palStartEven = i - 1;
                palEndEven = i ;
                while (palStartEven >= 0 && palEndEven < size && a.charAt(palStartEven) == a.charAt(palEndEven)) {
                    palStartEven--;
                    palEndEven++;
                }
                palStartEven++;
                palEndEven--;
            } else {
                palStartEven = i;
                palEndEven = i;
            }
            // check if the longer of the above palindrome is longer than the longest palindrome substring found yet
            if ( palEndEven-palStartEven+1 > maxLengthPalindrome ){
                maxPalStart = palStartEven;
                maxPalEnd = palEndEven;
                maxLengthPalindrome = maxPalEnd - maxPalStart+1;
            }
            if ( palEndOdd - palStartOdd +1 > maxLengthPalindrome){
                maxPalStart = palStartOdd;
                maxPalEnd = palEndOdd;
                maxLengthPalindrome = maxPalEnd - maxPalStart +1;
            }

        }

        return a.substring(maxPalStart,maxPalEnd+1);

    }
}

/* SOLUTION APPROACH



Method 2 ( Dynamic Programming )
        The time complexity can be reduced by storing results of subproblems. The idea is similar to this post. We maintain a boolean table[n][n] that is filled in bottom up manner. The value of table[i][j] is true, if the substring is palindrome, otherwise false. To calculate table[i][j], we first check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false


        Time complexity: O ( n^2 )
        Auxiliary Space: O ( n^2 )

Method 3 ( Constant Space )

    We can find the longest palindrome substring in (n^2) time with O(1) extra space. The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.

    Step to generate odd length palindrome:
    Fix a centre and expand in both directions for longer palindromes.

    Step to generate even length palindrome
    Fix two centre ( low and high ) and expand in both directions for longer palindromes.

    Time complexity: O ( n^2 ) where n is the length of input string.
    Auxiliary Space: O ( 1 )
*/


// This is a test comment. I'm practicing with Git!
