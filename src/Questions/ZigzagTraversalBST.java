package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION

Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]

*/

/*  

Input : 23 6 2 8 1 4 7 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class ZigzagTraversalBST {
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
        ArrayList<ArrayList<Integer>> output = zigzagLevelOrder(root);
        long end = System.nanoTime();
        System.out.println(output);
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if ( A == null) return result;
        Stack<TreeNode> st1RtoL = new Stack<TreeNode>();
        Stack<TreeNode> st2LtoR = new Stack<TreeNode>();
        st1RtoL.push(A);
        while (!st1RtoL.isEmpty() || !st2LtoR.isEmpty()){
            if(st2LtoR.isEmpty()){
                ArrayList<Integer> level = new ArrayList<Integer>();
                while (!st1RtoL.isEmpty()) {
                    TreeNode temp = st1RtoL.pop();
                    if (temp.left != null) st2LtoR.push(temp.left);
                    if (temp.right != null) st2LtoR.push(temp.right);
                    level.add(temp.val);
                }
                result.add(new ArrayList<Integer>(level));
            } else {
                ArrayList<Integer> level = new ArrayList<Integer>();
                while (!st2LtoR.isEmpty()) {
                    TreeNode temp = st2LtoR.pop();
                    if (temp.right != null) st1RtoL.push(temp.right);
                    if (temp.left != null) st1RtoL.push(temp.left);
                    level.add(temp.val);
                }
                result.add(new ArrayList<Integer>(level));
            }
        }
        return result;
    }




}

/* SOLUTION APPROACH

*/