package Questions.practice;


import java.util.Scanner;

import static java.lang.Math.abs;

/*You are in an infinite 2D grid where you can move in any of the 8 directions :

        (x,y) to
        (x+1, y),
        (x - 1, y),
        (x, y+1),
        (x, y-1),
        (x-1, y-1),
        (x+1,y+1),
        (x-1,y+1),
        (x+1,y-1)
        You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

        Example :

        Input : [(0, 0), (1, 1), (1, 2)]
        Output : 2
        It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
        https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
        */
public class MinStepsInInfiniteGrid {
    public  static int coverPoints(int[] A, int[] B) {
        int cost=0,xDiff,yDiff;
        for (int i = 1; i <  A.length; i++) {
            xDiff = abs(A[i] - A[i-1]);
            yDiff = abs(B[i] - B[i-1]);
            if( xDiff < yDiff) cost+= yDiff;
            else cost+=  xDiff;
        }
        return cost;
    }
    public static void main ( String[] args){
        Scanner sc = new Scanner(System.in);
        int noOfSets = sc.nextInt();
        int[] XCoods = new int[noOfSets];
        for (int i = 0; i < noOfSets; i++) {
            XCoods[i] = sc.nextInt();
        }
        noOfSets = sc.nextInt();
        int[] YCoods = new int[noOfSets];
        for (int i = 0; i < noOfSets; i++) {
            YCoods[i] = sc.nextInt();
        }
        int cost = coverPoints(XCoods,YCoods);
        System.out.println(cost);
    }

}
