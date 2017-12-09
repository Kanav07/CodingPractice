package Questions;

import algorithmsBasics.ListNode;

import java.util.Scanner;




/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
3 2 4 3
3 5 6 4
Output: 7 -> 0 -> 8



Input: (3 -> 2 -> 1) + ( 6 -> 4)
3 3 2 1
2 6 4
Output: 7 -> 0 -> 8


Input: (9 -> 9 -> 9) + ( 1)
3 9 9 9
1 1
Output: 7 -> 0 -> 8
*/
public class AddTwoNumAsLinkedLists {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int headValue = sc.nextInt();
        ListNode headA = new ListNode(headValue);
        ListNode train = headA;
        for (int i = 1; i < input; i++) {
            int value = sc.nextInt();
            train.next= new ListNode(value);
            train = train.next;
        }

         input = sc.nextInt();
         headValue = sc.nextInt();
        ListNode headB = new ListNode(headValue);
         train = headB;
        for (int i = 1; i < input; i++) {
            int value = sc.nextInt();
            train.next= new ListNode(value);
            train = train.next;
        }

        long start = System.nanoTime();
        //call function here.....
        ListNode print = AddTwoList(headA,headB);
        long end = System.nanoTime();
        while (print!= null) {
            System.out.print(print.val + " ");
            print = print.next;
        }

    }

    public static ListNode AddTwoListII ( ListNode a, ListNode b){

        if ( a == null || b == null) return a;

        ListNode tempA=a, tempB=b,temp,curr = tempA,next, previous=null;

        while (curr != null){
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        tempA = previous;
        curr = tempB;
        previous = null;
        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        tempB = previous;
        int carryover = 0;
        ListNode sum=null;
        temp = null;
        while (tempA!= null || tempB!=null){
            int digita = 0, digitb = 0, result;
            if ( tempA != null) digita = tempA.val;
            if ( tempB != null) digitb = tempB.val;
            result = digita + digitb + carryover;

            if (sum==null) {
                sum = new ListNode(result%10);
            }else {
                sum.next = new ListNode(result%10);
                sum = sum.next;

            }

            carryover = result/10;
            if ( tempA != null )tempA= tempA.next;
            if ( tempB != null ) tempB= tempB.next;
        }

        if ( carryover > 0){
            sum = new ListNode(carryover);

        }
        return sum;

    }

    public static ListNode AddTwoList ( ListNode a, ListNode b) {


        if ( a == null ) return b;
        else if (b == null) return a;

        ListNode sumhead = null,sum=null;
        ListNode tempA = a,tempB = b;

        int carryover = 0;
        while (tempA != null || tempB != null){

            int digitA = ( tempA != null) ? tempA.val : 0;
            int digitB = ( tempB != null) ? tempB.val : 0;

            int result = digitA + digitB + carryover;
            carryover = result/10;

            if ( sumhead == null) {
                sumhead = new ListNode(result%10);
                sum = sumhead;
            } else {
                sum.next = new ListNode(result%10);
                sum = sum.next;
            }

            if ( tempA != null )tempA= tempA.next;
            if ( tempB != null ) tempB= tempB.next;

        }
        if ( carryover > 0){
            sum.next = new ListNode(carryover);

        }
        return  sumhead;


    }



}
