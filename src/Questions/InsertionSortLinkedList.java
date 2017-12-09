package Questions;

import algorithmsBasics.ListNode;

import java.util.Scanner;



/*Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3
*/

/*

3 1 3 2

7 4 5 6 7 0 1 2


*/


public class InsertionSortLinkedList {
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
        ListNode print = insertionSortList(head);
        long end = System.nanoTime();
        while (print!= null) {
            System.out.print(print.val + " ");
            print = print.next;
        }



    }


    public static ListNode insertionSortList(ListNode a) {


        ListNode sorted = null, tempA = a,temp = null,prev=null, head = null;

        while (tempA != null){
            temp = tempA;

            sorted = head;
            prev = null;
            while (sorted != null && sorted.val < tempA.val){
                prev = sorted;
                sorted = sorted.next;
            }

            if ( sorted == null && prev == null) {
                sorted = new ListNode(temp.val);
                head = sorted;
                sorted.next = null;
            } else {
                if ( prev == null) {
                    temp = new ListNode(temp.val);
                    temp.next = sorted;
                    sorted = temp;
                    head = temp;
                }
                else {
                   temp = new ListNode(temp.val);
                    prev.next = temp;
                    temp.next = sorted;
                }
            }

            if ( tempA != null) tempA = tempA.next;

        }

        return head;
    }
}
