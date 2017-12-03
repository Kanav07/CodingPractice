package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

//Input : 
// Expected :
// My Code : 

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = "A man, a plan, a canal: Panama";
        String input = "race a car";
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
        System.out.println(isPalindrome(input));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }

    public static int isPalindrome(String a) {
        int left = 0, right = a.length() - 1, isPalindrome = 1;
        if ( a.length() < 2) return 1;
        a = a.toLowerCase();
        while (left <= right) {
            if (((a.charAt(left) <= 'z' && a.charAt(left) >= 'a') || (a.charAt(left) <= '9' && a.charAt(left) >= '0')) && ( (a.charAt(right) <= 'z' && a.charAt(right) >= 'a') || (a.charAt(right) <= '9' && a.charAt(right) >= '0'))) {
                if ( a.charAt(left)!=a.charAt(right)) {
                    isPalindrome =0;
                    break;
                }else{
                    left++;
                    right--;
                }

            } else {
                if ((a.charAt(left) > 'z' || a.charAt(left) < 'a') && (a.charAt(left) > '9' || a.charAt(left) < '0'))
                    left++;
                if ((a.charAt(right) > 'z' || a.charAt(right) < 'a') && (a.charAt(right) > '9' || a.charAt(right) < '0'))
                    right--;
            }
        }
        return isPalindrome;
    }
}

/* SOLUTION APPROACH

*/