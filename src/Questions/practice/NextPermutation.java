package Questions.practice;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.interviewbit.com/problems/next-permutation/
// 3 1 2 3
// 3 3 2 1
// 6 8 9 7 4 3 1
//7 6 2 1 5 4 3 0
/*
Your Input: 94 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766 759 983 728 220 16 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856 701 319 695 52

Expected output : 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766 759 983 728 220 16 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856 701 695 52 319

My Output  : 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766 759 983 728 220 52 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856 701 319 695 16

*/

//Your Input: 4 701 319 695 52
//        Expected output is 701 695 52 319

//Your Input: 4 7 3 6 2
//        Expected output is 7 6 2 3
//My : 7 6 3 2


public class NextPermutation {
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
        nextPermutationSolution ( inputList );
        long end = System.nanoTime();
        for (int x : inputList ) System.out.print(x +  " " );
        System.out.println("\nTime taken : " + (end - start));

    }

    public static void nextPermutation(ArrayList<Integer> a) {

        int temp=-1,size = a.size(),j =0 ;
        ArrayList<Integer> reverse = new ArrayList<Integer>();
        for (int i = size-1; i >=0 ; i--) {
            for (int k = i-1; k >=0 ; k--) {
                if ( a.get(k) < a.get(i) ) {
                    temp = a.get(i);
                    a.set(i, a.get(k));
                    a.set(k, temp);
                    return;
                }
            }
            reverse.add(a.get(i));
        }
        for (int x : reverse) a.set(j++,x);
        return;
    }


    public static void nextPermutationSolution(ArrayList<Integer> a) {

        int temp=-1,size = a.size(),j =0,k ;
        for (int i = size-1; i >=0 ; i--) {
            if(i> 0 && a.get(i-1)< a.get(i)){

                int small = a.get(i-1);
                //find smallest number greater than current number..
                for ( k = size-1; k > i ; k--)
                    if (a.get(k) > small ) break;
                temp = a.get(k);
                a.set(k,small);
                a.set(i-1,temp);

                //traversing the list from end..and placing them in ascending order after the current index
                for(j = i , k = size -1; j < k ; j++,k--){
                    temp = a.get(j);
                    a.set(j,a.get(k));
                    a.set(k,temp);
                }
                return;
            }
        }
        for(j = 0, k = size-1; j < k ; j++,k--){
            temp = a.get(j);
            a.set(j,a.get(k));
            a.set(k,temp);
        }
        return;
    }
}

