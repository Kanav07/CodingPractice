package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }


        TreeNode root = TreeNode.InsertIntoTree(inputList);
        Node root2 = BTreePrint.InsertIntoTree(inputList);

        BTreePrint.printNode(root2);

        long start = System.nanoTime();
        //call function here.....
        //System.out.println(sumNumbers(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }
     int result = 0;

    public int sumNumbers(TreeNode A) {
        if ( A == null) return 0;
        calculateSum( A, 0);
        return this.result;
    }
    private  void calculateSum(TreeNode a, int sum) {
        sum = (sum* 10 + a.val)%1003;
        if ( a.left == null && a.right== null){
            this.result = this.result + sum;
            return;
        }

        if( a.left!=null )calculateSum(a.left,sum);
        if( a.right!=null)calculateSum(a.right,sum);

    }
}

/* SOLUTION APPROACH

*/