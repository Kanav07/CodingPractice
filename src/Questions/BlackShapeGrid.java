package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION

Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:
3
OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class BlackShapeGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            String in = sc.next();
            inputList.add(in);
        }
        long start = System.nanoTime();
        //call function here.....
        System.out.println(black(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }


    static class Pair{
        public int x; public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int black(ArrayList<String> A) {

        int n = A.size(), m = A.get(0).length();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <m ; j++) {
                if ( A.get(i).charAt(j) == 'X') grid[i][j] = 1;
            }
        }

        int[] dx = { 1, -1, 0,0};
        int[] dy = { 0, 0 , -1,1};

        Stack<Pair> st  = new Stack<Pair>();
        int shapes=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if( grid[i][j] == 1){
                    //dfs
                    st.add(new Pair(i,j));
                    grid[i][j] = -1;

                    while (!st.isEmpty()){

                        Pair curr = st.pop();
                        grid[curr.x][curr.y] = -1;

                        for (int k = 0; k <4 ; k++) {
                            int x = curr.x + dx[k];
                            int y = curr.y + dy[k];

                            if( x < 0 || x >= n || y < 0 || y >= m) continue;
                            if(grid[x][y] > 0) st.add(new Pair(x,y));
                        }
                    }
                    shapes++;
                }
            }
        }
        return shapes;
    }



}

/* SOLUTION APPROACH




*/