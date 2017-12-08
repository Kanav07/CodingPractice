package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* QUESTION


Find the kth smallest element in an unsorted array of non-negative integers.

Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
NOTE
You are not allowed to modify the array ( The array is read only ).
Try to do it using constant extra space.

Example:

A : [6 2 1 4 3 2 6]
k : 3

A : [23  94 87 100 11 23 98 17 35 43 66 34 53 72 80 5 34 64 71 9 16 41 66 96
19
answer : 2

A : [ 46 8 16 80 55 32 8 38 40 65 18 15 45 50 38 54 52 23 74 81 42 28 16 66 35 91 36 44 9 85 58 59 49 75 20 87 60 17 11 39 62 20 17 46 26 81 92
9

A : [ 44 72 10 91 11 64 39 57 14 57 67 18 12 57 10 60 82 31 51 60 68 33 24 17 98 29 70 44 7 3 80 88 96 78 65 15 43 77 62 32 60 77 65 30 77
22

500 607 776 38 797 290 84 539 397 208 604 429 698 215 917 751 156 830 829 368 979
                225 705 481 715 978 77 741 44 126 254 354 352 550 667 317 800 142 836 380 842 240 389
                443 449 201 639 346 813 560 448 834 730 824 595 645 412 581 856 736 552 926 860 54 492 97 654 22 110 507 310 588 282 56 277 728 656 908 795 6 360 722 636 633 764 931 23 421 190 470 953 707 246 942 411 782 180 300 524 805 872 295 162 733 814 224 117 742 276 675 29 542 652 711 238 206 433 286 327 547 761 221 820 613 591 522 745 420 25 677 672 275 913 408 242 969 331 709 485 727 638 119 232 393 134 620 382 699 324 618 586 20 263 907 472 658 139 749 463 212 619 105 822 332 71 217 370 182 609 695 854 521 252 598 14 222 3 39 63 245 17 279 2 772 960 48 428 862 655 641 100 684 930 845 567 788 689 375 27 617 503 518 794 700 152 278 231 622 517 770 540 166 956 923 871 268 893 241 697 673 179 396 696 41 778 626 877 804 243 89 580 214 223 631 112 488 309 478 721 482 674 997 121 832 528 124 562 493 49 806 676 338 763 704 972 605 502 563 898 693 600 859 376 127 313 266 831 487 933 784 99 28 732 779 294 533 683 576 999 400 508 879 900 271 612 151 308 454 892 912 78 273 630 145 76 774 851 320 102 678 10 355 880 111 681 666 572 140 970 702 840 783 737 68 115 359 261 629 941 574 724 233 292 650 314 205 384 66 417 789 98 530 459 585 128 520 118 176 194 132 936 153 855 94 131 838 594 828 601 318 15 691 248 987 293 849 330 33 226 692 948 985 52 559 236 5 72 706 402 334 322 284 62 944 383 283 843 593 589 415 549 710 846 512 147 986 940 431 88 687 980 685 305 432 553 916 895 558 726 219 297 946 473 896 943 125 109 120 932 971 865 743 615 811 802 47 307 7 858 919 747 172 875 452 291 536 890 719 474 653 848 210 386 734 171 963 464 990 58 883 928 426 817 708 679 568 164 446 713 424 343 483 686 825 566 92 513 847 26 184 611 167 361 515 216 818 541 950 435 897 12 69 87 965 504 471 793 479 192 304 239 808 257 750 819 592 501 701 438 777 807 398 113 299 516 419 537 981 494 247 927


*/

/*  Input : 
    Expected :
    My Code : 
*/

public class KthSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        int k = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(kthsmallest(inputList,k));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
        System.out.println(kthsmallestBinary(inputList,k));
         end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

 /*   public static int kthsmallestBAD(final List<Integer> a, int k) {

        if ( a== null || a.size() <  k ) return -1;

       *//* int[] kArray = new int[k];

        for (int i = 0; i < k ; i++)  kArray[i]= Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            if ( a.get(i).intValue() < kArray[0]){
                for (int j = k-1; j > 0 ; j--) {
                    kArray[j] = kArray[j-1];
                }
                kArray[0] = a.get(i).intValue();
            } else if (a.get(i).intValue() > kArray[k-1]){
                continue;
            } else {
                for (int j = 0; j < k ; j++) {
                    if ( kArray[j] > a.get(i).intValue() ){
                        for (int l = k-1; l < j ; l--) {
                            kArray[l] = kArray[l-1];
                        }
                        kArray[j] = a.get(i).intValue();
                        break;
                    }
                }
            }
        }
        return kArray[k-1];
*//*
       
       
       
       
       
    }*/

    public static int kthsmallest(final List<Integer> a, int k) {

        if ( a== null || a.size() <  k ) return -1;
        
        int temp1 = a.get(0),temp2;
        boolean begin = true;
        if ( k > a.size() /2 ) {
            begin = false;
            temp2 = -1;
        } else {
            temp2 = Integer.MAX_VALUE;
        }

        int count, candidate,reps;
        for (int i = 0; i <a.size() ; i++) {
            candidate = a.get(i).intValue();
            count = 0;
            reps = 0;
           if ( begin) {
                
               if ( candidate >= temp1 && candidate < temp2) {

                   for (int j = 0; j < a.size(); j++) {
                       if (a.get(j).intValue() < candidate) {
                           count++;
                       }
                       if (a.get(j).intValue()== candidate)  reps++;
                   }

                   if (count + reps == k || (count < k &&  k - count < reps)) return candidate;
                   if (count + reps > k) {
                       temp2 = candidate;
                       if ( temp1 == temp2) temp1 = -1;
                   }
                   else temp1 = candidate;
               }
           } else {

               if ( candidate > temp2 && candidate <= temp1) {

                   for (int j = 0; j < a.size(); j++) {
                       if (a.get(j).intValue() > candidate) {
                           count++;
                       }
                       if (a.get(j).intValue()== candidate)  reps++;
                   }

                   if (count + reps == a.size() - k + 1 || (count < a.size() - k + 1 && a.size() - k + 1 - count < reps)) return candidate;
                   if (count + reps > a.size() - k + 1) {
                       temp2 = candidate;
                       if ( temp1 == temp2) temp1 = Integer.MAX_VALUE;
                   }
                   else temp1 = candidate;
               }
           }
        }
       return -1;
    }

    public static int kthsmallestBinary(final List<Integer> a, int k) {

        if ( a== null || a.size() <  k ) return -1;


        int max = Collections.max(a);
        int min = Collections.min(a);

        int mid,count,reps;
        while (min < max){
            mid = min + (max - min)/2;
            count = 0;
            reps = 0;
            for (int i = 0; i <a.size() ; i++) {
                if (a.get(i).intValue() < mid) {
                    count++;
                }
                if (a.get(i).intValue()== mid)  reps++;
                if ( count > k ) break;
            }

            if ((count < k &&  k - count <= reps)) return mid;
            if (count + reps > k) {
                max--;
            }
            else min++;
        }

        return -1;
    }


}

/* SOLUTION APPROACH

*/