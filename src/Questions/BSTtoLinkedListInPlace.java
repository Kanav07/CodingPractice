package Questions;

import apple.laf.JRSUIUtils;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.

*/

/*  

Input :  23 6 2 8 1 4 7 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class BSTtoLinkedListInPlace {
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
        System.out.println(PreOrderTraversal.PreOrderTraversal(flattenBEST(root)));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println(PreOrderTraversal.PreOrderTraversal(flatten(root)));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


    }
    public static TreeNode flatten(TreeNode a) {
        if ( a==null )return a;
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        preOrder(a,temp);
        TreeNode root = a;
        for (int i = 1; i < temp.size(); i++) {
            a.right = temp.get(i);
            a= a.right;
        }
        return root;

    }
    public static void preOrder(TreeNode root, ArrayList<TreeNode> result){
        if(root == null) return;

        result.add(root);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }

    public static TreeNode flattenBEST(TreeNode a) {
        if ( a==null )return a;
        TreeNode root= a;
        while (a!=null){
            TreeNode next = a.left;
            if(next!=null) {
                while (next != null && next.right != null) next = next.right;
                next.right = a.right;
                a.right = a.left;
                a.left = null;
            }
            a=a.right;
        }
        return root;
    }
}

/* SOLUTION APPROACH

*/