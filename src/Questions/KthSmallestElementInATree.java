package Questions;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION

Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input :
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST

*/

/*  
Input : 11 4 2 5 1 5 -1 -1 -1 -1 -1 -1

Expected : 0
My Code :

Input : 7 4 -1 5 3 -1 -1 -1
Expected : 0
My Code :


Input :11 3 2 4 1 3 -1 -1 -1 -1 -1 -1
Expected : 0
My Code :

Input : 95 52 38 65 36 40 64 70 35 37 39 47 58 -1 67 78 33 -1 -1 -1 -1 -1 44 49 56 59 66 69 77 79 -1 34 42 45 48 53 54 57 -1 61 -1 -1 68 -1 71 -1 -1 -1 -1 -1 41 43 -1 46 -1 -1 50 -1 -1 55 -1 -1 60 62 -1 -1 -1 75 -1 -1 -1 -1 -1 -1 -1 51 -1 -1 -1 -1 -1 63 73 76 -1 -1 -1 -1 72 74 -1 -1 -1 -1 -1 -1
Expected : 0
My Code :


Input : 11 4 2 5 1 3 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class KthSmallestElementInATree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }

        int k = sc.nextInt();
        TreeNode root = TreeNode.InsertIntoTree(inputList);
        Node root2 = BTreePrint.InsertIntoTree(inputList);

        BTreePrint.printNode(root2);

        long start = System.nanoTime();
        //call function here.....
         System.out.println (kthsmallest( root, k));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println (kthsmallestIterative( root, k));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int kthsmallest(TreeNode root, int k) {
        if( root == null ) return -1;

        ArrayList<Integer> inorder = new ArrayList<Integer>();
        inOrderTraversal(root,inorder);

        return inorder.get(k-1);
    }
    public static void inOrderTraversal(TreeNode a,ArrayList<Integer> result ){
        if ( a==null) return ;
        inOrderTraversal(a.left,result);
        result.add(a.val);
        inOrderTraversal(a.right,result);

    }

    public static int kthsmallestIterative (TreeNode root, int k){
        if ( root == null ) return -1;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr!=null){
            st.push(curr);
            curr= curr.left;
        }
        while (!st.isEmpty()){
            curr = st.pop();
            k--;
            if( k ==0) return curr.val;

            if( curr.right!=null){
                TreeNode temp = curr.right;
                while (temp!=null) {
                    st.push(temp);
                    temp=temp.left;
                }
            }
        }
        return -2;
    }
}

/* SOLUTION APPROACH

*/