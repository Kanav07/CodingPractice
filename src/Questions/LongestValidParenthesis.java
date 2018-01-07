package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class LongestValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        int inputListSize = sc.nextInt();
//
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
        long start = System.nanoTime();
        //call function here.....
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParenthesesDP(s));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }
/* 

()()()
))())((
(()
()()
(()))(())
(())))()(())

*/
 
    

    // ) ) ( ) ) ( (
    // 0 1 2 3 4 5 6
    // St : 2
    // len = 3-2 +1 = 2


    // ( ( )
    // 0 1 2 3 4 5 6
    // St : 0 1
    // len = 2

    // ( ) ( )
    // 0 1 2 3 4 5 6
    // St : 0 1
    // len = 2

    // ( ( ) ) ( ( )
    // 0 1 2 3 4 5 6
    // St : 2
    // len = 3-2 +1 = 2
    public static int longestValidParentheses(String A) {


        if( A == null ||  A.length() == 0  ) return 0;

        Stack<Integer> st = new Stack<Integer>();

        int len = 0,max = 0,curr=-1;

        for (int i = 0; i < A.length(); i++) {

            if( A.charAt(i) == '('){
                st.push(i);

            } else {

                if( st.isEmpty()){
                    curr = i;

                } else {
                     st.pop();

                    if( st.isEmpty()){

                        len = i - curr ;
                        if ( len > max) max = len;

                    } else {

                        len = i - st.peek();
                        if ( len > max) max = len;
                    }
                }
            }
        }

        return max;
    }


    public static   int longestValidParenthesesDP(String s) {
        if (s.length() <= 1) return 0;
        int curMax = 0;
        int[] longest =  new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                curMax = Math.max(longest[i], curMax);
            }
        }
        return curMax;
    }
}

// ( ( ) ) ) ) ( ) ( (  )  )
// 0 1 2 3 4 5 6 7 8 9 1011
// ( ( ) ) ) ( ( ) )
// 0 1 2 3 4 5 6 7 8


/* SOLUTION APPROACH

*/