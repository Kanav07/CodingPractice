package Questions;

import java.util.*;

/* QUESTION

*/

/*  

Input : 7 10
XOXXXXOOXX
XOOOOXOOXX
OXXOOXXXOO
OXOXOOOXXO
OXOOXXOOXX
OXXXOXXOXO
OOXXXXOXOO

[[X, O, X, X, X, X, O, O, X, X],
 [X, O, O, O, O, X, O, O, X, X],
 [O, X, X, O, O, X, X, X, O, O],
 [O, X, O, X, O, O, O, X, X, O],
 [O, X, O, O, X, X, O, O, X, X],
 [O, X, X, X, O, X, X, O, X, O],
 [O, O, X, X, X, X, O, X, O, O]]

Expected :
XOXXXXOOXX
XOOOOXOOXX
OXXOOXXXOO
OXXXOOOXXO
OXXXXXOOXX
OXXXXXXOXO
OOXXXXOXOO

[[X, O, X, X, X, X, O, O, X, X],
 [X, O, O, O, O, X, O, O, X, X],
 [O, X, X, O, O, X, X, X, O, O],
 [O, X, X, X, O, O, O, X, X, O],
 [O, X, X, X, X, X, O, O, X, X],
 [O, X, X, X, X, X, X, O, X, O],
 [O, O, X, X, X, X, O, X, O, O]]

 Run as custom input
My Code :
[[X, O, X, X, X, X, O, O, X, X],
 [X, X, X, X, X, X, O, O, X, X],
 [O, X, X, X, X, X, X, X, O, O],
 [O, X, X, X, X, X, X, X, X, O],
 [O, X, X, X, X, X, X, X, X, X],
 [O, X, X, X, X, X, X, X, X, O],
 [O, O, X, X, X, X, O, X, O, O]]


Input : 9 5 OOXXO XOXOO XXOOO OOOOX XXOOX XOXOO XXXXO XXOOO XOOOO
Expected :  OOXXO XOXOO XXOOO OOOOX XXOOX XXXOO XXXXO XXOOO XOOOO
My Code : 

*/

public class CaptureRegionsonBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < r; i++) {
            String in = sc.next();
            inputList.add(in);
        }

        ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < r; i++) {
            grid.add(new ArrayList<Character>());
            for (int j = 0; j < c; j++) {
                grid.get(i).add(inputList.get(i).charAt(j));
            }
        }
        System.out.println(grid);
        long start = System.nanoTime();
        //call function here.....
        solve(grid);
        System.out.println(grid);
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static void solve(ArrayList<ArrayList<Character>> a){

        int r = a.size();
        int c = a.get(0).size();


        for (int i = 0; i <c ; i++) {
            if( a.get(0).get(i) == 'O') bfs( a,0,i);
            if( a.get(r-1).get(i) == 'O') bfs( a,r-1,i);
        }
        for (int i = 0; i <r ; i++) {
            if (a.get(i).get(0) == 'O') bfs(a,i,0);
            if (a.get(i).get(c - 1) == 'O') bfs(a,i,c-1);
        }


        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if( a.get(i).get(j)=='B') a.get(i).set(j,'O');
                else if( a.get(i).get(j)=='O') a.get(i).set(j,'X');
            }
        }
        return;
    }

    private static void bfs(ArrayList<ArrayList<Character>> a, int x, int y) {

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x,y));

        while (!q.isEmpty()){

            int cx = q.peek().x;
            int cy = q.peek().y;
            q.remove();
            a.get(cx).set(cy,'B');
            for (int i = 0; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if( nx < 0 || nx >= a.size() || ny < 0 || ny >= a.get(0).size()) continue;

                if( a.get(nx).get(ny) == 'O') q.add(new Pair(nx,ny));

            }
        }
    }


    static int[] dx = { 1,-1, 0, 0};
    static int[] dy = { 0, 0,-1, 1};

    static class Pair{
        public int x; public int y;
        public Pair( int a, int b){
            this.x = a; this.y = b;
        }
    }
    public static void solveFAIL(ArrayList<ArrayList<Character>> a) {


        int r = a.size();
        int c = a.get(0).size();

        int[][] grid = new int[r][c];

        for( int i =0; i < r ; i++){
            for ( int j =0; j < c ; j++){
                if ( a.get(i).get(j)== 'X') grid[i][j] = 1;

            }
        }

        Stack<Pair> fl = new Stack<Pair>();



        for( int i =0; i < r ; i++){
            for ( int j =0; j < c ; j++){

                if(grid[i][j]==0){
                    if ( captured(grid,new Pair(i,j) ,fl) == true ){
                        while(!fl.isEmpty()) {
                            Pair p = fl.pop();
                            a.get(p.x).set(p.y,'X');
                        }
                    } else grid[i][j] = -2;
                }
            }
        }
        return;


    }


    //7 3 OOX OOO XXX XXX XOX OXX XOO
    //3 8
    //XOOOOOOX
    //XXOOXOOX
    //OXXOXOXX
    public static boolean captured(int[][] grid, Pair curr, Stack<Pair> fl){

        int X = curr.x;
        int Y = curr.y;

        grid[X][Y] = -1;
        ArrayList<Integer> t = new ArrayList<Integer>();
        for(int i =0; i< 4; i++){

            int x = X + dx[i];
            int y = Y + dy[i];

            if( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;

            if( grid[x][y] == 1 ) continue;
            else if ( grid[x][y] == -1 ) continue;
            else if ( grid[x][y] == 0 ) {
                t.add(i);
                continue;
            } else if (grid[x][y] == -2 ) return false;
        }
        for (int i = 0; i < t.size() ; i++) {
            int x = X + dx[t.get(i)];
            int y = Y + dy[t.get(i)];

            if ( captured(grid, new Pair(x,y),fl) == false) return false;
            else continue;
        }
        fl.add(curr);
        return true;
    }
}

/* SOLUTION APPROACH

*/