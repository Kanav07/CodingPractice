package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :
          1
         / \
        2   3

Return : True or 1

Input 2 :
         3
        /
       2
      /
     1

Return : False or 0
         Because for the root node, left subtree has depth 2 and right subtree has depth 0.
         Difference = 2 > 1.

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class IsBalancedBST {
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
        System.out.println(isBalanced(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println(isBalancedBEST(root));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int isBalanced(TreeNode a) {

        if ( a == null) return 1;

        if ( Math.abs(getDepth(a.left) - getDepth(a.right)) > 1) return 0;
        else if( isBalanced(a.left) == 0 || isBalanced(a.right) == 0) return 0;
        else return 1;

    }
    public  static int getDepth( TreeNode a){

        if ( a == null) return 0;

        int left = getDepth(a.left) +1;
        int right = getDepth(a.right) +1;
        return left > right? left : right;
    }


    public static Integer depth(TreeNode a) {
        if (a == null) return 0;

        Integer left = depth(a.left);
        Integer right = depth(a.right);

        if (left == null || right == null) return null;

        if (Math.abs(left - right) > 1) return null;

        return Math.max(left, right) + 1;
    }

    public static int isBalancedBEST(TreeNode a) {
        return depth(a) == null ? 0 : 1;
    }
}

/* SOLUTION APPROACH

*/