package Questions;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* QUESTION

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric.
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

/*  

Input : 11 4 2 5 1 3 -1 -1 -1 -1 -1 -1
Expected :
My Code : 

Input : 15 4 2 2 3 3 3 3 -1 -1 -1 -1 -1 -1 -1 -1
Expected :
My Code : 


Input :
Expected :
My Code :

Input :
Expected :
My Code :
*/

public class IsSymmetricTree {
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
        System.out.println(isSymmetric(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

         start = System.nanoTime();
        //call function here.....
        System.out.println(isSymmetricRecursive(root));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));
    }

    public static int isSymmetric(TreeNode a) {

        if ( a == null) return 1;
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        left.add(a.left);
        right.add(a.right);
        while (!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.remove();
            TreeNode r = right.remove();

            if ( (l== null && r!=null) || (l!=null && r==null)) return 0;
            if (l!=null && r!=null && l.val!=r.val) return 0;

            if(l!=null) {
                left.add(l.left);
                left.add(l.right);
            }
            if ( r!=null){
                right.add(r.right);
                right.add(r.left);
            }
        }
        return 1;

    }

    public static int isSymmetricRecursive( TreeNode a){
        if( a == null) return 1;
        return compareTrees(a.left,a.right);
    }

    public static int compareTrees(TreeNode a, TreeNode b){
        if( a==null && b==null) return 1;

        if ( (a==null && b!=null) || ( a!=null && b==null) || ( a!=null && b!=null && a.val!=b.val)) return 0;

        if ( compareTrees(a.left,b.right)==0 || compareTrees(a.right,b.left)==0) return 0;

        return 1;
    }
}

/* SOLUTION APPROACH

*/