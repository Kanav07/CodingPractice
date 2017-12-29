package Questions;


import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator2 {


    private Stack<TreeNode> st;

    public BSTIterator2(TreeNode root) {
        this.st = new Stack<TreeNode>();
        this.initialiseStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = st.pop();
        if ( temp.right !=null) initialiseStack(temp.right);
        return temp.val;
    }
    private void initialiseStack ( TreeNode root){
        while (root!=null){
            this.st.push(root);
            root= root.left;
        }
    }

}
