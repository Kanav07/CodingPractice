package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
Example :

Input :
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return :
            1
           / \
          2   3


*/

/*
43 460 3871 4698 8399 504 4421 7515 -1 4167 5727 -1 -1 3096 434 7389 2667 5661 1969 7815 4292 3006 9750 6693 -1 6906 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

8399 2667 4167 5661 3871 1969 5727 7815 504 460 4421 4292 3096 3006 4698 9750 434 6693 7515 7389 6906
2667 5661 4167 8399 1969 7815 5727 504 3871 4292 3006 3096 4421 9750 6693 434 6906 7389 7515 4698 460

Input : 8399 2667 4167 5661 3871 1969 5727 7815 504 460 4421 4292 3096 3006 4698 9750 434 6693 7515 7389 6906
2667 5661 4167 8399 1969 7815 5727 504 3871 4292 3006 3096 4421 9750 6693 434 6906 7389 7515 4698 460
Expected :
My Code : 

Input : 8 1 2 3 4  5 6 7 8
8 1 2 4 3 6 8 7 5
[5, 3, 2, 1, 4, 7, 6, 8]
Expected :
My Code : 

*/

public class BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize1 = sc.nextInt();

        ArrayList<Integer> inputList1 = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize1; i++) {
            int inputNumber = sc.nextInt();
            inputList1.add(inputNumber);
        }

        int inputListSize2 = sc.nextInt();

        ArrayList<Integer> inputList2 = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize2; i++) {
            int inputNumber = sc.nextInt();
            inputList2.add(inputNumber);
        }

        long start = System.nanoTime();
        //call function here.....
        TreeNode root = buildTree(inputList1,inputList2);
        System.out.println(PreOrderTraversal.PreOrderTraversal(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if( inorder.size() == 0 || postorder.size() == 0) return null;

        int rootVal = postorder.get(postorder.size()-1);
        int i = 0;
        while (inorder.get(i).intValue() != rootVal ) i++;


        TreeNode curr = new TreeNode(rootVal);
        curr.left = buildTree(new ArrayList<Integer>(inorder.subList(0,i)),
                new ArrayList<Integer>(postorder.subList(0,i)));
        curr.right = buildTree(new ArrayList<Integer>(inorder.subList(i+1,inorder.size())),
                new ArrayList<Integer>(postorder.subList(i,postorder.size()-1)));
        return curr;
    }


}

/* SOLUTION APPROACH

*/