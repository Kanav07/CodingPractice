package Questions;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* QUESTION

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example :


Given A : [1, 2, 3]
A height balanced BST  :

      2
    /   \
   1     3


*/

/*  

Input : 5 1 2 3 4 5
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class sortedArraytoBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
        TreeNode root = sortedArrayToBST(inputList);
        System.out.println(InOrderTraversal.inOrderTraversal(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static TreeNode sortedArrayToBST(final List<Integer> a) {
        if( a.size() == 0) return null;

        TreeNode root=null,temp=null;
        root = sortedArrayToBSTRec(a,0,a.size()-1);
        return root;
    }

    private static TreeNode sortedArrayToBSTRec(List<Integer> a, int start,int end) {
        if( start > end){
            return null;
        }
        int mid = start + ( end - start)/2;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = sortedArrayToBSTRec(a,start,mid-1);
        root.right = sortedArrayToBSTRec(a,mid+1,end);
        return root;
    }
}

/* SOLUTION APPROACH

*/