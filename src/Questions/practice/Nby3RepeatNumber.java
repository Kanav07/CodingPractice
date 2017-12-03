package Questions.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// https://www.interviewbit.com/problems/n3-repeat-number/
// 9 1 2 3 1 1 3 7 2 4
// 9 1 2 3 1 1 3 7 2 1
//  [ 265 1000545 1000038 1000647 1000038 1000562 1000038 1000586 1000487 1000951 1000226 1000038 1000145 1000038 1000761 1000196 1000038 1000821 1000829 1000038 1000570 1000846 1000038 1000178 1001000 1000038 1000568 1000278 1000734 1000048 1000038 1000002 1000271 1000388 1000315 1000816 1000038 1000038 1000846 1000305 1000853 1000383 1000116 1000797 1000279 1000038 1000038 1000049 1000108 1000789 1000240 1000201 1000506 1000429 1000857 1000649 1000898 1000211 1000000 1000178 1000038 1000569 1000695 1000451 1000159 1000038 1000038 1000038 1000129 1000038 1000038 1000904 1000038 1000038 1000902 1000525 1000038 1000166 1000038 1000765 1000038 1000561 1000417 1000523 1000668 1000296 1000038 1000038 1000038 1000461 1000654 1000924 1000985 1000038 1000426 1000038 1000038 1000038 1000904 1000775 1000148 1000961 1000038 1000038 1000038 1000833 1000332 1000038 1000038 1000512 1000322 1000592 1000524 1000788 1000057 1000497 1000625 1000599 1000484 1000038 1000747 1000457 1000111 1000038 1000038 1000493 1000287 1000007 1000695 1000344 1000098 1000038 1000191 1000038 1000576 1000481 1000488 1000199 1000038 1000663 1000176 1000038 1000521 1000721 1000728 1000247 1000038 1000038 1000460 1000644 1000038 1000497 1000966 1000431 1000038 1000975 1000063 1000580 1000669 1000038 1000038 1000492 1000038 1000038 1000529 1000553 1000333 1000038 1000341 1000569 1000862 1000017 1000532 1000571 1000508 1000402 1000285 1000611 1000210 1000646 1000110 1000038 1000553 1000273 1000729 1000038 1000038 1000720 1000400 1000038 1000983 1000038 1000766 1000038 1000180 1000494 1000765 1000136 1000038 1000029 1000246 1000991 1000038 1000759 1000038 1000038 1000045 1000038 1000648 1000038 1000038 1000694 1000914 1000990 1000038 1000038 1000758 1000435 1000038 1000554 1000038 1000452 1000156 1000038 1000322 1000828 1000868 1000038 1000973 1000991 1000464 1000294 1000633 1000038 1000582 1000229 1000285 1000038 1000038 1000086 1000038 1000989 1000038 1000038 1000157 1000307 1000369 1000300 1000038 1000038 1000038 1000244 1000038 1000038 1000222 1000458 1000038 1000523 1000434 1000316 1000038 1000256 1000038 1000695 1000038 1000469 ]

// A : [ 112 1000697 1000110 1000110 1000671 1000941 1000304 1000110 1000742 1000160 1000558 1000110 1000110 1000110 1000650 1000200 1000110 1000133 1000110 1000548 1000002 1000397 1000110 1000533 1000724 1000110 1000882 1000110 1000515 1000110 1000110 1000110 1000181 1000051 1000110 1000110 1000644 1000110 1000301 1000110 1000040 1000424 1000336 1000426 1000244 1000485 1000439 1000554 1000110 1000110 1000497 1000836 1000760 1000110 1000135 1000872 1000110 1000739 1000242 1000790 1000110 1000384 1000110 1000384 1000110 1000713 1000110 1000110 1000048 1000110 1000172 1000727 1000502 1000649 1000830 1000387 1000953 1000110 1000640 1000291 1000612 1000389 1000110 1000698 1000462 1000054 1000110 1000110 1000181 1000221 1000408 1000110 1000905 1000110 1000532 1000939 1000110 1000817 1000388 1000069 1000110 1000163 1000453 1000847 1000908 1000395 1000574 1000127 1000132 1000110 1000110 1000201 1000689 ]




public class Nby3RepeatNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
       // int number = repeatedNumber(inputList);
        long end = System.nanoTime();
        //System.out.print(number + "\n");
        System.out.println("Time taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        int number = repeatedNumberBestSolution(inputList);
        end = System.nanoTime();
        System.out.print(number + "\n");
        System.out.println("Time taken : " + (end - start));

    }
    public static int repeatedNumber(final List<Integer> a) {
        Collections.sort(a);
        int size = a.size(),count = 0;
        for (int i = 0,temp = a.get(i); i < size; i++) {
            if( a.get(i) == temp){
                count++;
                if (count > size/3) {
                    return temp;
                }
            } else {
                temp = a.get(i);
                count = 1;
            }
        }
        return -1;
    }

    public static int repeatedNumberBestSolution(final List<Integer> a) {
        int len = a.size();

        if(a.size() == 0) {
            return -1;
        }

        if(a.size() == 1) {
            return a.get(0);
        }

        int c1 = a.get(0);
        int c2 = a.get(1);
        int c1count = 0;
        int c2count = 0;

        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(c2 == num) {
                c2count++;
            } else if(c1count == 0) {
                c1 = num;
                c1count = 1;
            } else if(c2count == 0) {
                c2 = num;
                c2count = 1;
            } else {
                c1count--;
                c2count--;
            }
        }

        c1count = 0;
        c2count = 0;
        for(int num : a) {
            if(c1 == num) {
                c1count++;
            } else if(num == c2) {
                c2count++;
            }
        }

        if(c1count > len / 3) {
            return c1;
        } else if(c2count > len / 3) {
            return c2;
        } else {
            return -1;
        }

    }
}
