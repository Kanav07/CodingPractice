package Questions;


/*The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

import java.util.ArrayList;

public class NQueen {
    public static void main(String[] args) {

        int input = 10/2;

//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
        long start = System.nanoTime();
        //call function here.....
        ArrayList<ArrayList<String>> output = solveNQueens(input);
        long end = System.nanoTime();
        int i = 1;
        for (ArrayList<String> arr : output) {
            System.out.println("SOLUTION " + (i++));
            for (String s : arr) System.out.println(s);
            System.out.println();

        }
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {

        ArrayList<ArrayList<Integer>> int_output = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        if (a == 0) return output;
        if (a == 1) {
            output.add(new ArrayList<String>());
            output.get(0).add("Q");
            return output;
        }
        int[] lefts = new int[a];
        int[] rights = new int[a];
        for (int i = 0; i < a; i++) {
            lefts[i] = -1;
            rights[i] = -1;
        }
//
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < a; i++) temp.append(".");
        ArrayList<String> temp1 = new ArrayList<String>();
        for (int i = 0; i < a; i++) {
            StringBuffer NqueenStrings= new StringBuffer(temp);
            NqueenStrings.setCharAt(i,'Q');
            temp1.add(NqueenStrings.toString());
        }



        placeNQueen(int_output, lefts, rights, new int[a], 0, new ArrayList<Integer>());

        for (ArrayList<Integer> sol : int_output) {
            ArrayList<String> temp2 = new ArrayList<String>();
            for (int i = 0; i < a; i++) {
                String temp3 = temp1.get(sol.get(i));
                temp2.add(temp3);
            }
            output.add(new ArrayList<String>(temp2));
        }
        /*
         StringBuilder temp = new StringBuilder();
         ArrayList<String> temp1 = new ArrayList<String>();
         for (int i = 0; i < a; i++) temp.append(".");
         for (int i = 0; i < a; i++) {
             StringBuilder temp3 = new StringBuilder(temp);
             temp3.setCharAt(solution.get(i),'Q');
             temp1.add(new String(temp3.toString()));
             temp3 = null;
         }
         output.add(temp1);
         temp = null;
         temp1 = null;*/
        return output;
    }

    private static void placeNQueen(ArrayList<ArrayList<Integer>> output, int[] lefts, int[] rights, int[] currentRow, int row, ArrayList<Integer> solution) {

        int a = lefts.length;
        if (row == a) {
            output.add(new ArrayList<Integer>(solution));
            return;

        }

        for (int j = 0; j < a; j++) {
            if (currentRow[j] != -1) {
                //Place Queen here
                solution.add(j);
                // prepare the next row
                int[] nextRow = new int[a];
                nextRow[j] = -1;
                for (int i = 0; i < solution.size(); i++) nextRow[solution.get(i)] = -1;
                lefts[row] = j - 1;
                rights[row] = j + 1;
                for (int i = 0; i <= row; i++) {
                    if (lefts[i] >= 0) nextRow[lefts[i]] = -1;
                    if (rights[i] < a) nextRow[rights[i]] = -1;
                    lefts[i]--;
                    rights[i]++;
                }
                placeNQueen(output, lefts, rights, nextRow, row + 1, solution);

                solution.remove(solution.size() - 1);
            }
        }

    }


    public ArrayList<ArrayList<String>> solveNQueensFIRST(int a) {

        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        if (a == 0) return output;
        if (a == 1) {
            output.add(new ArrayList<String>());
            output.get(0).add("Q");
            return output;
        }
        int[] lefts = new int[a];
        int[] rights = new int[a];
        for (int i = 0; i < a; i++) {
            lefts[i] = -1;
            rights[i] = -1;
        }


        placeNQueenFIRST(a, output, lefts, rights, new int[a], 0, new ArrayList<Integer>());
        return output;
    }

    private void placeNQueenFIRST(int a, ArrayList<ArrayList<String>> output, int[] lefts, int[] rights, int[] currentRow, int row, ArrayList<Integer> solution) {

        if (row == a) {
            StringBuilder temp = new StringBuilder();
            ArrayList<String> temp1 = new ArrayList<String>();
            for (int i = 0; i < a; i++) temp.append(".");
            for (int i = 0; i < a; i++) {
                StringBuilder temp3 = new StringBuilder(temp);
                temp3.setCharAt(solution.get(i), 'Q');
                temp1.add(new String(temp3.toString()));
            }
            output.add(temp1);
            return;

        }

        for (int j = 0; j < a; j++) {
            if (currentRow[j] != -1) {
                //Place Queen here
                solution.add(j);
                // prepare the next row
                int[] nextRow = new int[a];
                nextRow[j] = -1;
                for (int i = 0; i < solution.size(); i++) nextRow[solution.get(i)] = -1;
                lefts[row] = j - 1;
                rights[row] = j + 1;
                for (int i = 0; i <= row; i++) {
                    if (lefts[i] >= 0) nextRow[lefts[i]] = -1;
                    if (rights[i] < a) nextRow[rights[i]] = -1;
                    lefts[i]--;
                    rights[i]++;
                }
                placeNQueenFIRST(a, output, lefts, rights, nextRow, row + 1, solution);

                solution.remove(solution.size() - 1);
            }
        }

    }
}

