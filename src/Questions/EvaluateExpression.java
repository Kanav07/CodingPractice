package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

/*  Input :
5 2 1 + 3 *
5 4 13 5 / +
    Expected :
    My Code : 
*/

public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        String[] inputList = new String[inputListSize];
        for (int i = 0; i < inputListSize; i++) {
            inputList[i] = sc.next();
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(evalRPN(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int evalRPN(String[] A) {

        Stack<String> expression = new Stack<String>();

        for (int i = 0; i < A.length ; i++) {
            if ( A[i].matches("[\\*\\+\\-/]")) {
                int x = Integer.parseInt(expression.pop());
                int y = Integer.parseInt(expression.pop());
                int result = -1;
                if ( A[i].equals("+"))  result = x + y;
                else if ( A[i].equals("-"))  result = y - x;
                else if ( A[i].equals("*"))  result = x*y;
                else if ( A[i].equals("/")) result = y / x;

                if ( i == A.length-1) return result;
                else expression.push(String.valueOf(result));


            } else {
                expression.push(A[i]);
            }
        }

        return Integer.parseInt(expression.pop());
    }
}

/* SOLUTION APPROACH

*/