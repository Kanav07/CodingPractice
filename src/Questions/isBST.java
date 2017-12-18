package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

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
*/

public class isBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }

        TreeNode root = TreeNode.InsertIntoTree(inputList);
        //TreeNode.prettyPrintTree(root);
        TreeNode.print2DUtil(root,0);
        long start = System.nanoTime();
        //call function here.....
        System.out.println(isValidBST(root));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int isValidBST(TreeNode a) {
        if ( a == null ) return 1;
        if ( a.left == null && a.right== null) return 1;
        if ( a.left!=null && a.val <= a.left.val) return 0;
        if ( a.left!=null && a.left.right!=null && a.val <= a.left.right.val) return 0;
        if ( a.right!=null && a.val >= a.right.val) return 0;
        if ( a.right!=null && a.right.left!=null && a.val >= a.right.left.val) return 0;

        return isValidBST(a.left) * isValidBST(a.right);

    }
}

/* SOLUTION APPROACH

*/