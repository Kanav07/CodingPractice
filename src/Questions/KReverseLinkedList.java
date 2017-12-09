package Questions;

import algorithmsBasics.ListNode;

import java.util.Scanner;


/*
*
*
* Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

3 2 1 6 5 4

Try to solve the problem using constant extra space.

*
*
* */


/*
8 1 2 3 6 9 8 4 7
4


 95 850  3137  5924  538  8654  5070  8451  3420  1916  6276  1145  6841  4240  8385  8413  27  6828  4671  2526  5631  571  5363  2349  1055  4746  6500  6152  9019  3348  6291  8586  1211  869  9448  996  7167  2504  5423  7730  6032  6891  9829  8550  4511  8658  3726  8575  7209  4944  1271  9684  3678  1686  2289  203  521  6659  5077  6726  6733  785  4987  9060  6479  9142  5277  8276  9216  4997  9125  2568  3117  9716  4063  1085  4592  5765  8802  9545  7848  2837  7571  3438  9074  9020  8696  2754  3697  7431  1810  4114  8777  6232  1438  4668
  5

 */

public class KReverseLinkedList {
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

        int k = sc.nextInt();

        long start = System.nanoTime();
        //call function here.....
        ListNode print = reverseListBEST(head,k);
        long end = System.nanoTime();
        while (print!= null) {
            System.out.print(print.val + " ");
            print = print.next;
        }
    }

    public static ListNode reverseList(ListNode A, int B) {


        //  1 2 3 6 9 8 4 7 11 13 23 10
        // 6 3 2 1 7 4 8 9
        if ( A == null || B == 0) return A;

        int k = B;
        ListNode start=A, end=null, currentNode= A, nextNode = A.next, temp,previous = null,head= null;

        while (start!=null) {
            {
                while (k > 1 && currentNode != null) {
                    temp = nextNode.next;
                    nextNode.next = currentNode;
                    currentNode.next = previous;
                    previous = currentNode;
                    currentNode = nextNode;
                    nextNode = temp;
                    k--;
                }
                if ( head== null) {
                    head = currentNode;
                }else {
                    start.next = currentNode;
                    start = end;
                }

                k = B;
                end = nextNode;
                previous = null;
                currentNode = nextNode;
                if ( currentNode!= null ) nextNode = currentNode.next;



            }


        }


        return head;
    }


    public static ListNode reverseListBEST(ListNode node, int B) {
        ListNode current = node;
        ListNode previous = null;
        ListNode next = null;

        int count=B;
        while(count-->0 && current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        if(current!=null){
            node.next=reverseListBEST(current, B);
        }

        return previous;
    }


}
