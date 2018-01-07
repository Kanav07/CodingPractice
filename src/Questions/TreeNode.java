package Questions;

import javax.transaction.TransactionRequiredException;
import java.util.*;

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
        }

    public static TreeNode InsertIntoTree(ArrayList<Integer> list){
        TreeNode root = null,current = null;
        if ( list.size() == 0 ) return root;
        if ( list.size() ==1  && list.get(0) == -1) return null;
        int startChildren=0;
        Queue<TreeNode> parents = new LinkedList<TreeNode>();
        while (startChildren < list.size()){
            if ( root== null){
                root = InsertNode(list.get(startChildren));
                parents.add(root);
                startChildren = 2*startChildren +1;
            } else {
                while (!parents.isEmpty()){
                    current = parents.remove();
                    current.left = InsertNode(list.get(startChildren++));
                    if ( current.left != null) parents.add(current.left);
                    current.right = InsertNode(list.get(startChildren++));
                    if ( current.right!=null) parents.add(current.right);
                }
            }
        }
        return root;
    }

    public static TreeNode InsertNode(int x){
        if ( x == -1) return null;
        else return new TreeNode(x);
    }

    public static void prettyPrintTree( TreeNode root){
        if ( root == null) return;
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        TreeNode temp1,temp2;
        ArrayList<StringBuilder> TreeLevels = new ArrayList<StringBuilder>();
        children.add(root);
        TreeLevels.add(new StringBuilder(root.val + ""));
        while (!children.isEmpty()){
            temp1 = children.remove();
            if ( temp1 == null ) {
                TreeLevels.add(new StringBuilder(""));
            }else if ( temp1.left == null) {
                TreeLevels.add(new StringBuilder("x"));
                children.add(null);
            } else {
                TreeLevels.add(new StringBuilder(temp1.left.val + ""));
                children.add(temp1.left);
            }
            if ( temp1 == null ) {
                TreeLevels.get(TreeLevels.size()-1).append(" ");
            }else if ( temp1.right == null) {
                TreeLevels.get(TreeLevels.size()-1).append("x");
                children.add(null);
            } else {
                TreeLevels.get(TreeLevels.size()-1).append(" " +temp1.right.val);
                children.add(temp1.right);
            }
        }


        int i,start=0,j=1;
        while (true) {
            for ( i = start; i < Math.pow(2, j-1)  && i < TreeLevels.size(); i++) {
                System.out.print(TreeLevels.get(i).toString());
            }
            System.out.println();
            start = i;
            j++;
            if ( i == TreeLevels.size()) break;
        }
    }



    // Function to print binary tree in 2D
// It does reverse inorder traversal
    static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.printf("%d\n", root.val);

        // Process left child
        print2DUtil(root.left, space);
    }

    public static void main ( String[] args){

        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        TreeNode root = InsertIntoTree(inputList);
        prettyPrintTree(root);
    }
}
