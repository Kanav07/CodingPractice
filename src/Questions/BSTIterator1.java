package Questions;

import java.util.ArrayList;

public class BSTIterator1 {


        private ArrayList<Integer> inorder;
        private int index;
        public BSTIterator1(TreeNode root) {
            this.inorder = new ArrayList<Integer>();
            this.inOrderTraversal(root,this.inorder);
            this.index = 0;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if ( this.index < inorder.size()) return true;
            else return false;

        }

        /** @return the next smallest number */
        public int next() {
            return inorder.get(this.index++);
        }
        private  void inOrderTraversal(TreeNode a,ArrayList<Integer> result ){
            if ( a==null) return ;
            inOrderTraversal(a.left,result);
            result.add(a.val);
            inOrderTraversal(a.right,result);

        }
}
