package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
PATH SUM
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.




GENERATE PATH SUM
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]

*/

/*  

Input : 23 6 2 8 1 4 7 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1
9
Expected :
My Code : 


Input : 5 1000 200 -1 -1 -1
1000
Expected :
My Code : 

Input :333 0 2 0 0 2 1 0 1 1 2 1 -1 -1 0 1 2 1 2 2 2 1 0 0 2 0 0 1 0 0 2 2 0 0 1 0 2 2 -1 -1 1 2 0 0 -1 -1 -1 -1 2 -1 2 2 0 2 2 1 2 1 -1 0 1 -1 -1 2 0 1 2 0 1 -1 -1 0 1 1 2 0 1 -1 1 1 -1 -1 -1 -1 -1 2 -1 -1 -1 -1 0 2 -1 1 0 2 0 0 -1 2 -1 1 0 -1 0 0 1 1 2 1 2 1 -1 -1 -1 0 -1 0 -1 -1 0 -1 0 0 2 -1 0 0 0 -1 -1 0 -1 0 -1 1 -1 0 -1 -1 -1 -1 -1 -1 -1 -1 1 1 -1 -1 -1 -1 -1 -1 0 0 -1 2 -1 -1 -1 -1 -1 1 -1 1 2 0 1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 2 2 0 2 1 -1 1 -1 -1 2 -1 -1 -1 -1 0 -1 2 -1 0 -1 0 1 0 -1 -1 0 -1 2 0 -1 1 -1 -1 -1 -1 -1 -1 1 -1 0 1 -1 1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 0 2 1 2 -1 -1 2 -1 -1 2 1 0 2 -1 -1 -1 -1 0 1 -1 -1 -1 -1 2 1 1 -1 2 0 -1 0 -1 -1 -1 -1 -1 1 -1 -1 -1 -1 2 1 0 1 -1 -1 -1 1 -1 -1 -1 -1 1 -1 -1 -1 -1 -1 2 0 -1 -1 -1 1 -1 2 -1 -1 -1 0 -1 -1 0 2 -1 2 1 -1 -1 -1 -1 -1 -1 -1 2 0 1 -1 0 -1 -1 0 -1 -1 -1 -1 -1 1 -1 -1
6
Expected : 1
My Code : 0

Input :23 6 2 8 1 4 3 9 0 -1 3 5 -1 -1 -1 10 -1 -1 -1 -1 -1 -1 -1 -1
17
Expected :
My Code :


543 0 2 0 1 0 2 2 1 0 0 1 2 1 1 2 1 2 1 0 0 2 0 2 2 -1 1 0 1 -1 1 2 2 2 1 1 -1 1 2 1 0 1 1 0 2 2 2 2 2 0 2 0 1 2 -1 -1 0 1 0 2 -1 2 1 0 -1 -1 2 1 0 -1 0 2 -1 -1 1 2 -1 -1 0 2 1 -1 1 0 0 -1 2 -1 -1 1 2 0 -1 -1 2 1 2 -1 1 1 0 2 2 0 -1 1 1 0 1 0 0 1 2 2 0 -1 1 2 0 -1 -1 -1 0 -1 2 2 -1 -1 0 -1 1 0 -1 -1 0 -1 1 -1 0 1 -1 1 0 0 -1 2 1 -1 0 0 0 0 -1 -1 -1 -1 2 1 -1 1 2 -1 0 1 1 2 0 -1 -1 0 -1 0 2 0 -1 1 -1 2 1 -1 0 -1 0 2 -1 0 2 0 1 0 -1 -1 -1 0 -1 -1 -1 -1 -1 2 -1 1 0 -1 1 0 -1 -1 -1 -1 -1 -1 -1 -1 0 -1 1 1 -1 -1 -1 -1 -1 -1 -1 -1 1 0 -1 -1 -1 2 1 1 2 1 -1 -1 -1 1 -1 -1 -1 -1 -1 0 2 2 0 -1 -1 1 0 -1 1 1 1 -1 2 1 0 2 -1 1 2 -1 -1 -1 -1 2 2 1 1 -1 2 0 2 -1 -1 -1 1 2 -1 -1 -1 -1 0 1 1 -1 -1 -1 2 2 -1 -1 2 2 -1 -1 -1 1 0 -1 -1 2 -1 -1 -1 -1 -1 -1 0 -1 -1 1 -1 -1 1 2 -1 1 2 2 -1 -1 -1 2 -1 0 -1 0 2 2 0 2 -1 0 2 1 -1 0 -1 -1 2 -1 -1 -1 -1 -1 2 1 -1 0 2 -1 -1 -1 -1 -1 -1 1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 2 -1 -1 -1 0 2 1 0 -1 -1 2 0 -1 -1 -1 1 1 -1 -1 -1 0 1 -1 -1 -1 -1 1 0 -1 0 0 -1 1 1 1 2 -1 -1 -1 1 1 -1 0 -1 -1 -1 2 -1 -1 -1 0 2 0 -1 -1 -1 -1 -1 1 -1 -1 -1 -1 -1 -1 -1 -1 0 0 2 2 -1 -1 -1 -1 -1 -1 -1 0 -1 -1 2 -1 -1 1 -1 -1 1 2 1 0 -1 -1 0 -1 2 -1 -1 -1 -1 -1 -1 -1 2 -1 -1 2 -1 -1 2 -1 1 -1 -1 2 -1 -1 -1 -1 -1 -1 0 -1 -1 -1 1 1 -1 -1 1 -1 -1 -1 -1 -1 -1 -1 0 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 1 -1 -1 -1 -1 -1 -1 -1 1 0 0 1 1 0 -1 -1 -1 -1 -1 -1 -1 -1
10

*/

public class PathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int sum = sc.nextInt();
        TreeNode root = TreeNode.InsertIntoTree(inputList);
        Node root2 = BTreePrint.InsertIntoTree(inputList);

        //BTreePrint.printNode(root2);

        long start = System.nanoTime();
        //call function here.....
        System.out.println(hasPathSum(root,sum));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here....
        System.out.println(pathSum(root,sum));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int hasPathSum(TreeNode A, int B) {
        if(( A==null && B!=0) ) return 0;
        if( A!=null && A.left==null && A.right==null && B-A.val==0) return 1;
        else if(A!=null){
            if( hasPathSum(A.left,B-A.val)==1 || hasPathSum(A.right,B-A.val)==1) return 1;
            else return 0;
        }else return -1;
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if ( A == null) return result;

        generatePathsSums(A, B, result,new ArrayList<Integer>());
        return result;
    }

    private static void generatePathsSums(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if ( root == null && sum!=0) return;
        if ( root!=null && root.left==null && root.right==null && sum - root.val==0) {
            path.add(root.val);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        if( root!=null){
            path.add(root.val);
            generatePathsSums(root.left,sum-root.val,result,path);
            generatePathsSums(root.right,sum-root.val,result,path);
            path.remove(path.size()-1);
        }
    }


}

/* SOLUTION APPROACH

*/