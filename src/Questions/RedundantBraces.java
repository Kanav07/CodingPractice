package Questions;


/*Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0*/


import java.util.Stack;

/**/
public class RedundantBraces {
    public static void main(String[] args) {


        String input = "[[1+2]+2]";

        System.out.print(braces(input));
    }
    public static int braces(String a) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < a.length(); i++) {
            if ( !st.isEmpty() && (a.charAt(i) == '/' || a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' ) ) st.pop();
            else if (a.charAt(i) == '(' || a.charAt(i) == '{' || a.charAt(i) == '['  ) st.push('(');
        }
        return st.isEmpty() ? 0 : 1;

    }
}
