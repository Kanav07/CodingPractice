package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION


Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.


*/

/*  Input : 
    Expected :
    My Code : 
*/

public class GenerateAllParenthesesII {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int  input = 10;

//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
        long start = System.nanoTime();
        //call function here.....
        ArrayList<String> output = generateParenthesis(input);
        long end = System.nanoTime();
        for (String s : output) System.out.println(s);
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> output = new ArrayList<String>();
        if ( a == 0) return output;
        if (a == 1){
            output.add("()");
            return output;
        }
        StringBuilder temp = new StringBuilder("(");
        bracketGenerator( a-1, a, output,temp);
        return output;
    }

    private static void bracketGenerator(int left, int right, ArrayList<String> output, StringBuilder temp) {

        if ( left == 0 && right == 0) {
            output.add(new String(temp.toString()));
            return;
        }
            if ( left > 0 && left <=right) {
                temp.append('(');
                bracketGenerator(left - 1, right, output, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
            if ( right > 0 && left <right) {
                temp.append(')');
                bracketGenerator(left, right - 1, output, temp);
                temp.deleteCharAt(temp.length() - 1);

            }

    }

}

/* SOLUTION APPROACH

*/