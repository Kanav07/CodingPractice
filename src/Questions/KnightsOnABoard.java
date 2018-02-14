package Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/* QUESTION

*/

/*  

Input : 4
7
2
6
2
4
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class KnightsOnABoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int inputListSize = sc.nextInt();
//
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }
        long start = System.nanoTime();
        //call function here.....
        System.out.println(knight(4,7,2,6,2,4));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    static int[] dx = {-2,-1, 1, 2, 2, 1,-1,-2 };
    static int[] dy = { 1, 2, 2, 1,-1,-2,-2,-1 };
    static int minMoves = -1;
    static int Bx , By;
    static int[][] Board;


    public static int knight(int A, int B, int C, int D, int E, int F) {
        Bx = A;
        By = B;
        Board = new int[A+1][B+1];
        dfs(C,D,E,F,0);
        return minMoves;
    }
    public static void dfs(int x1, int y1, int x2, int y2, int steps){


        if( Board[x1][y1] != 0) return;

        if(x1==x2 && y1==y2) {
            if( steps < minMoves || minMoves ==-1) minMoves = steps;
            return;
        }

        for( int i=0; i < 8 ; i++){

            int x = x1 + dx[i];
            int y = y1 + dy[i];

            if(x > 0 && x <= Bx && y > 0 && y <= By) {
                dfs(x,y,x2,y2,steps + 1);
                if( Board[x][y] > 0 && Board[x][y] + 1 < Board[x1][y1]) Board[x1][y1] = Board[x][y] + 1;
            }

        }
    }
}

/* SOLUTION APPROACH

*/