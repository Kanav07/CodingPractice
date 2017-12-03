package Questions.practice;

import java.util.ArrayList;
import java.util.Scanner;

// 2 2 1 2 3 4

//3 3 1 2 3  4 5 6  7 8 9
// 4 4   31 32 228 333          79 197 241 246          77 84 126 337          110 291 356 371
// [110 77 79 31 ]
// [291 84 197 32 ]
// [356 126 241 228 ]
// [371 337 246 333 ]

//  10 10 69    5   29   82   56   97   28   25    4   57 70   88   74   87   91   20   47   89   21   85         98  100   67    3   68   35   60   80   26   44         55    2   40   65   12   24   96   11   15   71         32   36   14    8   42    7   81   27   51   45         16   61   95   38   33   19   76   53   99   43         23   34   37   84   59   86   72   94   73   62         18    6   54   13   41   46   63   50   78   79         10    1   83   92    9   58   77   52   39   31         93   66   64   48   49   17   75   30   22   90
public class RotateMatrix {
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
            for (Integer x : list) System.out.printf("%3d ",x);
        }
        ArrayList<ArrayList<Integer>> inputMatrixCopy = (ArrayList<ArrayList<Integer>>) inputMatrix.clone();
System.out.print("\n\n");

        long start = System.nanoTime();
        //call function here.....
        rotate(inputMatrix);
        long end = System.nanoTime();
        for (ArrayList<Integer> list: inputMatrix) {
            System.out.println();
            for (Integer x : list) System.out.printf("%3d ",x);
        }
        System.out.println("\nTime taken : " + (end - start));



         start = System.nanoTime();
        //call function here.....
        rotateImproved(inputMatrixCopy);
         end = System.nanoTime();
        for (ArrayList<Integer> list: inputMatrix) {
            System.out.println();
            for (Integer x : list) System.out.printf("%3d ",x);
        }
        System.out.println("\nTime taken : " + (end - start));



    }

    public static  void rotate(ArrayList<ArrayList<Integer>> a) {

        int upperBound =0, lowerBound = a.size()-1, leftBound = 0, rightBound = a.size()-1,temp=0;

        for (int j = 0,rotations = a.size(); j < a.size() /2 ; j++) {
           if (upperBound < lowerBound && leftBound < rightBound){

               for (int k = rotations; k > 1  ; k--) {

                   for (int i = rightBound; i > leftBound ; i--) {
                       if ( i == rightBound ) temp = a.get(upperBound).get(i);
                       a.get(upperBound).set(i,a.get(upperBound).get(i-1));
                   }
                   for (int i = upperBound; i < lowerBound  ; i++) {
                       a.get(i).set(leftBound,a.get(i+1).get(leftBound));
                   }
                   for (int i = leftBound; i < rightBound; i++) {
                       a.get(lowerBound).set(i,a.get(lowerBound).get(i+1));
                   }
                   for (int i = lowerBound; i > upperBound  ; i--) {
                       if(i == upperBound + 1 ) continue;;
                       a.get(i).set(rightBound,a.get(i-1).get(rightBound));
                   }
                   a.get(upperBound+ 1).set(rightBound,temp);
               }
           }
            upperBound ++;
            leftBound ++;
            lowerBound--;
            rightBound--;
            rotations -= 2;
        }

    }

    public static  void rotateImproved(ArrayList<ArrayList<Integer>> a) {

        int temp1,temp2,temp3,temp4, n = a.size();
        for (int i = 0; i < n/2 ; i++) {
            for (int j = 0; j < n; j++) {

                temp1 = a.get(i).get(j);
                temp2 = a.get(n-1 -i).get(j);
                temp3 = a.get(n-1-i).get(n-1-j);
                temp4 = a.get(i).get(n-1-j);

                a.get(n-1-i).set(j,temp1);
                a.get(n-1-i).set(n-1-j,temp2);
                a.get(i).set(n-1-j,temp3);
                a.get(i).set(j,temp4);

            }
        }

    }

}
