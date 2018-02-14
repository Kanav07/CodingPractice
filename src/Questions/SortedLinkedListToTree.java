package Questions;

import algorithmsBasics.ListNode;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3



*/

/*  

Input : 3 1 4 8
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class SortedLinkedListToTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int headValue = sc.nextInt();
        ListNode head = new ListNode(headValue);
        ListNode train = head;
        for (int i = 1; i < input; i++) {
            int value = sc.nextInt();
            train.next= new ListNode(value);
            train = train.next;
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(InOrderTraversal.inOrderTraversal(sortedListToBST(head)));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
        System.out.println(InOrderTraversal.inOrderTraversal(sortedListToBST_bottomsUp(head)));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static TreeNode sortedListToBST(ListNode a) {
        ListNode temp = a;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while( temp!= null) {
            list.add( temp.val);
            temp= temp.next;
        }

        return rec_tree_maker(list, 0, list.size()-1);
    }

    public static TreeNode rec_tree_maker(ArrayList<Integer> list, int i, int j){
        if( i > j) return null;

        int mid = i + (j-i)/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = rec_tree_maker(list,i,mid-1);
        root.right = rec_tree_maker(list,mid+1,j);

        return root;
    }


    public static TreeNode sortedListToBST_bottomsUp(ListNode a) {

        ListNode temp = a;
        int len = 0;
        while (temp!=null) {
            temp = temp.next;
            len++;
        }
        head = a;
        return rec_bottom_up_tree(len);
    }

    static ListNode head;

    private static TreeNode rec_bottom_up_tree( int len) {

        if(len <= 0) {
            return null;
        }


        TreeNode left = rec_bottom_up_tree(len/2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = rec_bottom_up_tree(len - len/2-1);

        return root;

    }


}

/* SOLUTION APPROACH


1  - Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.

1) Get the Middle of the linked list and make it root.
2) Recursively do same for left half and right half.
       a) Get the middle of left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it right child of the
          root created in step 1.

Time complexity: O(nLogn) where n is the number of nodes in Linked List.

Easy & Cheeky - Copy Linked List to Array. Find the middle of the list, make it the root. Left part of the tree comes from the first half and right part of the tree comes from the later half. O(n)


How about inserting nodes following the list’s order? If we can achieve this, we no longer need to find the middle element, as we are able to traverse the list while inserting nodes to the tree.

2 - Medium - The idea is to insert nodes in BST in the same order as the appear in Linked List, so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
*/