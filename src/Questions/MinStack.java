package Questions;

import java.util.Scanner;
import java.util.Stack;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack?
A: In this case, return -1.

Q: What should pop do on empty stack?
A: In this case, nothing.

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor. */




//19 P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g



public class MinStack {


    private Stack<Integer> normalStack;
    private Stack<Integer> minChangesStack;

    public void push(int x) {
        if ( normalStack== null )normalStack= new Stack<Integer>();
        if ( minChangesStack== null ) minChangesStack= new Stack<Integer>();
        if ( minChangesStack.empty()) minChangesStack.push(x);
        else {
            if ( x < minChangesStack.peek()) minChangesStack.push(x);
        }
        normalStack.push(x);

    }

    public void pop() {
        if ( normalStack == null) return;
        if(normalStack.empty()) return;
        if ( normalStack.peek().intValue() == minChangesStack.peek().intValue()){
            normalStack.pop();
            minChangesStack.pop();
        } else  normalStack.pop();



    }

    public int top() {
        if ( normalStack == null) return -1;
        if ( normalStack.empty()) return -1;
        return normalStack.peek();

    }

    public int getMin() {
        if ( normalStack == null) return -1;
        if ( minChangesStack.empty() || normalStack.empty()) return -1;
        return minChangesStack.peek();


    }



    public static void main ( String[] args){
        MinStack test = new MinStack();
/*There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a number numOperations, corresponding to the number of operations.
Then "numOperation" operations follow.
Each operation is either :
 * P <number> : Corresponds to push(<number>) in stack
 * p : Corresponds to pop()
 * t : Corresponds to top()
 * g : Corresponds to getMin() call.
Note that the function calls are made in order.  */
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        for (int i = 0; i < op ; i++) {
            String command = sc.next();
            if ( command.equals("P")){
                int push = Integer.parseInt(sc.next());
                test.push(push);
            } else if ( command.equals("p")) {
                test.pop();
            } else if ( command.equals("g")){
                System.out.print(test.getMin() + " ");
            } else if ( command.equals("t")){
                System.out.print(test.top() + " ");
            }
        }
    }
}
