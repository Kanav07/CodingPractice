package Questions.practice;

import java.util.ArrayList;
import java.util.Scanner;


//Input : 
// Expected :
// My Code : 

public class PrettyPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        int inputNumber;
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
        long start = System.nanoTime();
        //call function here.....
        ArrayList<ArrayList<Integer>> output = prettyPrint(inputListSize);
        long end = System.nanoTime();
        for (ArrayList<Integer> list: output) {
            System.out.println();
            for (Integer x : list) System.out.printf( "%4d ",x);
        }
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        int size = 2*a -1;
        ArrayList<ArrayList<Integer>> outputArray = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size ; i++) {
            outputArray.add(new ArrayList<Integer>());
            for (int j = 0; j < size ; j++) {

                if( i + j < size ) outputArray.get(i).add(Math.max(a-i,a-j));
                else outputArray.get(i).add(Math.max(i,j) - a + 2);
            }
        }
        return outputArray;
    }
}
