package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :

   1       1
  / \     / \
 2   3   2   3

Output :
  1 or True

*/

/*  

Input : 11 4 2 5 1 3 -1 -1 -1 -1 -1 -1
11 4 2 5 1 3 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 11 4 2 5 1 3 -1 -1 -1 -1 -1 -1
11 4 2 5 1 6 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input :
Expected :
My Code :

Input :
Expected :
My Code :
*/

public class IdenticalBST {
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
        TreeNode root1 = TreeNode.InsertIntoTree(inputList1);
        TreeNode root2 = TreeNode.InsertIntoTree(inputList2);

        Node rootA = BTreePrint.InsertIntoTree(inputList1);
        Node rootB = BTreePrint.InsertIntoTree(inputList2);

        BTreePrint.printNode(rootA);
        BTreePrint.printNode(rootB);

        long start = System.nanoTime();
        //call function here.....
        System.out.println(isSameTree(root1,root2));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int isSameTree(TreeNode a, TreeNode b) {
        if( a == null && b==null) return 1;
        TreeNode t1= a;
        TreeNode t2 = b;
        if ((t1==null && t2!=null) || (t1!=null && t2==null)) return 0;
        if ( (t1!=null && t2!=null && t1.val == t2.val)){
            if (isSameTree(a.left,b.left)==1 &&  isSameTree(a.right,b.right)==1) return 1;
            else return 0;
        } else return 0;
    }
}

/* SOLUTION APPROACH

*/