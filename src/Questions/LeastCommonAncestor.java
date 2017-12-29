package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

*/

/*


Input : 23 6 2 8 1 4 7 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1

Expected :
My Code :

Input : 11 1 2 3 -1 -1 4 -1 -1 5 -1 -1
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class LeastCommonAncestor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }

        int B = sc.nextInt();
        int C = sc.nextInt();
        TreeNode root = TreeNode.InsertIntoTree(inputList);
        Node root2 = BTreePrint.InsertIntoTree(inputList);

        //BTreePrint.printNode(root2);
        long start = System.nanoTime();
        //call function here.....
        System.out.println(lca(root,B,C));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int lca(TreeNode A, int B, int C) {
        if( A==null) return -1;

        boolean leftB = contains(A.left,B);
        boolean leftC = contains(A.left,C);
        boolean rightB = contains(A.right,B);
        boolean rightC = contains(A.right,C);

        if( (A.val==B && (leftC || rightC)) ||
                (A.val==C && (leftB || rightB)) ||
                (A.val==B && A.val==C) ||
                (leftB && rightC) || (leftC && rightB)) return A.val;

        if( (!leftB &&  !rightB) || (!leftC && !rightC)) return -1;


        if( leftB && leftC ) return lca(A.left,B,C);
        if( rightB && rightC ) return lca(A.right,B,C);


        return -2;

    }

    public static boolean contains(TreeNode node, int x){
        if( node==null) return false;

        if( node.val == x) return true;

        if( contains(node.left,x) || contains(node.right,x)) return true;

        return false;
    }
}

/* SOLUTION APPROACH

*/