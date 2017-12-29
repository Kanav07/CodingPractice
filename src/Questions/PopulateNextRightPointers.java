package Questions;

import java.util.*;

/* QUESTION

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 Note 1: that using recursion has memory overhead and does not qualify for constant space.
Note 2: The tree need not be a perfect binary tree.

*/

/*  

Input : 23 6 2 8 1 4 7 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 43 621367 400139 986434 318453 562082 727076 -1 208016 340383 409269 -1 702531 983736 187691 -1 -1 387077 -1 534779 647033 719463 824451 -1 -1 -1 373900 -1 517606 -1 -1 -1 -1 720965 -1 834145 -1 -1 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

*/

public class PopulateNextRightPointers {
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

        //BTreePrint.printNode(root2);

        long start = System.nanoTime();
        //call function here.....
        connect(root);
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

// Definition for binary tree with next pointer.
      public class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
      }

    public static void connect(TreeNode root) {
        if( root == null) return;
        
        root.next=null;
        TreeNode curr,next;
        Queue<TreeNode> st1 = new LinkedList<TreeNode>();
        Queue<TreeNode> st2 = new LinkedList<TreeNode>();
        boolean levelchange = true;
        if( root.right!=null) st1.add(root.right);
        if( root.left!=null) st1.add(root.left);
        while (!st1.isEmpty() || !st2.isEmpty()){
            if( levelchange){
                next = null;
                while (!st1.isEmpty()){
                    curr = st1.remove();
                    curr.next = next;
                    if( curr.right!=null) st2.add(curr.right);
                    if( curr.left!=null) st2.add(curr.left);
                    next = curr;
                }
                levelchange = false;
            } else{
                next =null;
                while (!st2.isEmpty()){
                    curr = st2.remove();
                    curr.next = next;
                    if( curr.right!=null) st1.add(curr.right);
                    if( curr.left!=null) st1.add(curr.left);
                    next = curr;
                }
                levelchange = true;
            }
        }
        return ;
    }
    
    /*
     public static void connect(TreeLinkNode root) {
        if( root == null) return;
        
        root.next=null;
        TreeLinkNode curr,next;
        Queue<TreeLinkNode> st1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> st2 = new LinkedList<TreeLinkNode>();
        boolean levelchange = true;
        if( root.right!=null) st1.add(root.right);
        if( root.left!=null) st1.add(root.left);
        while (!st1.isEmpty() || !st2.isEmpty()){
            if( levelchange){
                next = null;
                while (!st1.isEmpty()){
                    curr = st1.remove();
                    curr.next = next;
                    if( curr.right!=null) st2.add(curr.right);
                    if( curr.left!=null) st2.add(curr.left);
                    next = curr;
                }
                levelchange = false;
            } else{
                next =null;
                while (!st2.isEmpty()){
                    curr = st2.remove();
                    curr.next = next;
                    if( curr.right!=null) st1.add(curr.right);
                    if( curr.left!=null) st1.add(curr.left);
                    next = curr;
                }
                levelchange = true;
            }
        }
        return ;
    }
    */
}

/* SOLUTION APPROACH

*/