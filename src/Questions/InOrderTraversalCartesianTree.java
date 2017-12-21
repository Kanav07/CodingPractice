package Questions;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class InOrderTraversalCartesianTree {
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
        TreeNode root = buildTree(inputList);

        long end = System.nanoTime();
        System.out.println(InOrderTraversal.inOrderTraversal(root));
        System.out.println(PreOrderTraversal.PreOrderTraversal(root));
        System.out.println(PostOrderTraversal.postorderTraversal(root));
        System.out.println("\nTime taken : " + (end - start));

    }

    public static TreeNode buildTreeFAIL(ArrayList<Integer> a) {
        if ( a.size()==0) return null;

        TreeNode curr = new TreeNode(a.get(0));
        curr.left=null;
        curr.right=null;
        TreeNode root=null,max = null;
        for (int i = 1; i < a.size(); i++) {
            TreeNode temp = new TreeNode(a.get(i));
            if ( temp.val > curr.val){
                temp.left=curr;
                temp.right=null;
                curr= temp;
            } else if (temp.val < curr.val){
                curr = max;

            }
            if( max == null || max.val <temp.val) max = temp;

        }
        return max;
    }

    public static TreeNode buildTree( ArrayList<Integer> a){

        if ( a.size() == 0) return null;

        int max = 0;
        for (int i = 1; i < a.size(); i++) {
            if ( a.get(i) > a.get(max)) max = i;
        }
        TreeNode curr = new TreeNode(a.get(max));
        curr.left = buildTree( new ArrayList<Integer>(a.subList(0,max)));
        if( max+1< a.size() ) curr.right = buildTree( new ArrayList<Integer>(a.subList(max+1,a.size())));
        else curr.right = null;
        return curr;
    }
}

/* SOLUTION APPROACH

*/