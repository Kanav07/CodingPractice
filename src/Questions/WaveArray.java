package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

//https://www.interviewbit.com/problems/wave-array/
// 4 1 2 3 4
// 5 5 1 3 2 4




public class WaveArray {
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
        ArrayList<Integer> outputList = wave ( inputList );
        long end = System.nanoTime();
        for (Integer x : outputList) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

        start = System.nanoTime();
        //call function here.....
        outputList = waveImproved ( inputList );
        end = System.nanoTime();
        for (Integer x : outputList) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));




    }
    public  static ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> result = new ArrayList<Integer>();
        if( a.size() % 2 ==0 ) {
            for (int i = 0; 2 * i + 1 < a.size(); i++) {
                result.add(a.get(2 * i + 1));
                result.add(a.get(2 * i));
            }
        } else {
            for (int i = 0; 2 * i  < a.size(); i++) {
                if (2 * i + 1 < a.size()) result.add(a.get(2 * i + 1));
                result.add(a.get(2 * i));
            }
        }
        return result;
    }

    public  static ArrayList<Integer> waveImproved(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int size = a.size();
        for (int i = 0; i < size ; i+=2) {
            int j = i +1;
            if (j < size ) result.add(a.get(j));
            result.add(a.get(i));
        }
        return result;
    }



}
