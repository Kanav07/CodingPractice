package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle. Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

Constraints
 0 <= x , y , R <= 100
 1 <= N <= 1000
Center of each circle would lie within the grid

Input
Input contains x, y , N , R  and two array of size N containing centers of circles.
The ith index of first array contains x co-ordinate of the ith circle and ith index of second array contains the y co-ordinate of the ith circle.

Output
YES or NO depending on weather it is possible to reach cell  (x,y) or not starting from (0,0).

  Sample Input
  2 3 1 1
  2
  3
  Sample Output
  NO


*/

/*  

Input : 2 3 1 1
1 2
1 3
Expected :
My Code : 

Input : 2 3 2 1
2 0 2
2 3 1
Expected : YES
My Code : 


4 4 2 2
2 0 4
2 4 0
YES


4 4 1 2
1 2
1 2
NO


4 4 1 3
1 0
1 4
NO

*/

public class ValidPathGridandCircles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int N = sc.nextInt();
        int R = sc.nextInt();


        int inputListSizeX = sc.nextInt();

        ArrayList<Integer> inputListX = new ArrayList<Integer>();
        for (int i = 0; i < inputListSizeX; i++) {
            int inputNumber = sc.nextInt();
            inputListX.add(inputNumber);
        }

        int inputListSizeY = sc.nextInt();

        ArrayList<Integer> inputListY = new ArrayList<Integer>();
        for (int i = 0; i < inputListSizeY; i++) {
            int inputNumber = sc.nextInt();
            inputListY.add(inputNumber);
        }


        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(x,y,N,R,inputListX,inputListY));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] grid = new int[A+1][B+1];

//        printGrid(grid);
//        System.out.println();
        //set circles
        for(int i = 0; i < C; i++){
            setcircle(grid, E.get(i),F.get(i),D);
        }
//        printGrid(grid);
//        System.out.println();
        boolean path = dfs(grid,0,0,A,B);
//        printGrid(grid);

        return path == true ? "YES" : "NO";

    }

    public static void setcircle ( int[][] grid, int x, int y,int r){

        grid[x][y] = -1;
        int i = Math.max(0,x-r), j ;
        for ( ; i <= Math.min(x+r,grid.length-1) ; i++) {

            for (j = Math.max(0,y-r) ; j <= Math.min(y+r,grid[0].length-1) ; j++) {

                // using equation of circle f(x,y) : (x - x1)^2 + (y - y1)^2 - r*r = 0
                // if x1,y1 lies inside the circle then f(x1,y1) <=0
                if ( ( (i-x)*(i-x) + (j-y)*(j-y) - r*r) <=0 ) grid[i][j]=-1;

            }
        }

    }

    public static boolean dfs(int[][] grid, int x, int y, int x2, int y2){

        if( grid[x][y] == -1) return false;

        if(x == x2 &&  y == y2) return true;

        if( grid[x][y] >= 1) return false;

        grid[x][y] =1;

        boolean p = x+1 < grid.length  ? true : false;
        boolean q = y+1 < grid[0].length ? true : false;
        boolean r = x-1 >= 0 ? true : false;
        boolean s = y-1 >= 0 ? true : false;


        if(        ( (r && s ) && (dfs(grid,x-1,y-1,x2,y2) ) ) || ( ( r) && ( dfs(grid,x-1,y,x2,y2)) )
                || ( (r && q ) && ( dfs(grid,x-1,y+1,x2,y2)) )|| ( ( q) && ( dfs(grid,x,y+1,x2,y2)) )
                || ( (p && q ) && (dfs(grid,x+1,y+1,x2,y2) ) )|| ( ( p) && (dfs(grid,x+1,y,x2,y2) ) )
                || ( (p && s ) && ( dfs(grid,x+1,y-1,x2,y2)) )|| ( ( s) && (dfs(grid,x,y-1,x2,y2) ) )
                ) {
            grid[x][y] = 2;
            return true;
        } else {
            return false;
        }

    }

    public static void printGrid( int[][] grid){
        for (int[] a: grid) {
            for (int x : a) System.out.printf("%3d ",x);
            System.out.println();
        }
    }
}

/* SOLUTION APPROACH

*/