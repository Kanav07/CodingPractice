package algorithmsBasics;


import java.util.ArrayList;
import java.util.Scanner;


public class LinkedList {
    public static void main(String[] args) {

        ListNode headA = new ListNode(2);
        ListNode temp = new ListNode(1);
        headA.next = temp;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        ListNode c1 = temp;
        temp.next = new ListNode(7);
        temp = temp.next;
        ListNode c2 = temp;
        // 2 -> 1-> 3 -> 4 -> 7

        //4 -> 7 -> 9 -> 2 -> 4 -> 7
        ListNode headB = new ListNode(4);
        temp = new ListNode(7);
        headB.next = temp;
        temp.next = new ListNode(9);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = c1;


       /*
       // Building link list from command line
       Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int headValue = sc.nextInt();
        ListNode head = new ListNode(headValue);
        ListNode train = head;
        for (int i = 0; i < input; i++) {
            int value = sc.nextInt();
            train.next= new ListNode(value);
            train = train.next;
        }
        */


        System.out.println(getIntersectionNodeBoolean(headA,headB));

        ListNode print = getIntersectionNode(headA,headB);
        while (print!= null){
            System.out.print(print.val + " ");
            print= print.next;
        }



    }


    public static boolean getIntersectionNodeBoolean(ListNode a, ListNode b) {


        // 2 -> 1-> 3 -> 4 -> 7

        //4 -> 7 -> 9 -> 2 -> 4 -> 7
        if ( a == null || b == null) return false;
        if ( a.equals(b)) return true;
        ListNode tempA ,tempB;
        while (true ) {
            if ( a.next == null ) break;
            a = a.next;
        }
        while (true)  {
            if ( b.next == null) break;
            b = b.next;
        }
        if ( a.equals(b)) return true;


        return false;
    }

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {

        if ( a == null || b == null) return null;
        if ( a.equals(b)) return a;

        int lenA=0,lenB=0;
        ListNode tempA = a, tempB = b;

        // 2 -> 1-> 3 -> 4 -> 7

        //4 -> 7 -> 9 -> 2 -> 4 -> 7

        while (true ) {
            if ( a.next == null ) break;
            a = a.next;
            lenA++;
        }
        while (true)  {
            if ( b.next == null) break;
            b = b.next;
            lenB++;
        }
        a= tempA;
        b = tempB;

        if ( lenA > lenB ){
            for (int i = lenA - lenB; i >0 ; i--) a=a.next;
        } else {
            for (int i = lenB - lenA; i >0 ; i--) b=b.next;
        }

        while (a!=null && b!=null && !a.equals(b)){
            a=a.next;
            b=b.next;
        }

        return a;
    }



}
