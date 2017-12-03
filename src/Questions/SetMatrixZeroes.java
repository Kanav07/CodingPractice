package Questions;

import java.util.ArrayList;
import java.util.Scanner;


 //2 2 1 0 1 1
// 2 2 1 1 0 0

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputRowSize = sc.nextInt();
        int inputColumnSize = sc.nextInt();
        int inputNumber;
        ArrayList<ArrayList<Integer>> inputMatrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputRowSize; i++) {
            inputMatrix.add(new ArrayList<Integer>());
            for (int j = 0; j < inputColumnSize; j++) {
                inputNumber = sc.nextInt();
                inputMatrix.get(i).add(inputNumber);
            }
        }
        for (ArrayList<Integer> list: inputMatrix) {
            System.out.println();
            for (Integer x : list) System.out.print(x + " ");
        }
        long start = System.nanoTime();
        //call function here.....
        setZeroes ( inputMatrix );
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));
        for (ArrayList<Integer> list: inputMatrix) {
            System.out.println();
            for (Integer x : list) System.out.print(x + " ");
        }

        start = System.nanoTime();
        //call function here.....
        setZeroesImproved ( inputMatrix );
        end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));
        for (ArrayList<Integer> list: inputMatrix) {
            System.out.println();
            for (Integer x : list) System.out.print(x + " ");
        }

    }
     public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
         int rows = a.size(), cols = a.get(0).size();
         short[] row = new short[rows];
         short[] column = new short[cols];
         for (int i = 0; i < rows; i++) {
             for (int j =0; j < cols;j++) {
                 if (a.get(i).get(j) == 0) {
                     row[i] = 1;
                     column[j] = 1;
                 }
             }
         }
         for (int i = 0; i < rows; i++) {
             if( row[i]== 1 ) {
                 for (int j =0 ; j <cols; j ++) a.get(i).set(j,0) ;
             }
         }
         for (int i = 0; i < cols; i++) {
             if( column[i]==1) {
                 for (int j = 0; j < rows; j++) a.get(j).set(i,0);
             }
         }
     }


     public static void setZeroesImproved(ArrayList<ArrayList<Integer>> a) {
         int rows = a.size(), cols = a.get(0).size(),breakFlag = 0;
         loopOuter : for (int i = 0; i < rows; i++) {
             loopInner : for (int j =0; j < cols;j++) {
                 if (a.get(i).get(j) == 0) {
                     for (int k = 0; k < cols; k++) a.get(i).set(k,0);
                     for (int k = 0; k < rows; k++) a.get(k).set(j,0);
                     break loopOuter;
                 }
             }
         }
     }
}
