package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/* QUESTION

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.

*/

/*  

Input : 5 AAAAA AAAAA AAAAA AAAAA AAAAA
FAFBA
Expected :
My Code : 

Input : 3 ABCE SFCS ADEE
ABCB
SEE
ABCCED
Expected :
My Code : 

*/

public class WordSearchOnBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            String in = sc.next();
            inputList.add(in);
        }
        String B = sc.next();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(exist(inputList,B));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int exist(ArrayList<String> A, String B) {
        if( A.size() == 0) return 0;
        int r = A.size();
        int c = A.get(0).length();



        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if(A.get(i).charAt(j) == B.charAt(0) && sol(A,B,i,j,1,new int[r][c])==true) return 1;
            }
        }
        return 0;
    }


    static int[] dx = { 1,-1, 0, 0};
    static int[] dy = { 0, 0,-1, 1};

    private static boolean sol(ArrayList<String> a, String b, int i, int j, int k, int[][] visited) {
        if( k == b.length()) return true;

            for (int l = 0; l < 4; l++) {

                int x = i + dx[l];
                int y = j + dy[l];

                if (x < 0 || x >= a.size() || y < 0 || y >= a.get(0).length()) continue;


                if( visited[x][y]!=1 && a.get(x).charAt(y)==b.charAt(k)) {
                    if( sol(a,b,x,y,k+1,visited)== true) return true;
                    else continue;
                }
            }
            return false;

    }



}

/* SOLUTION APPROACH

	public int exist(ArrayList<String> a, String b) {
	    int m = a.size();
	    if (m == 0) return 0;
	    int n = a.get(0).length();
	    if (n == 0) return 0;

	    if (b.length() == 0) return 1;
	    boolean[][] visited = new boolean[m][n];

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if ((a.get(i).charAt(j) == b.charAt(0)) && _sol(a, b, i, j, 0, visited)) {
	                return 1;
	            }
	        }
	    }

	    return 0;
	}

	public boolean _sol(ArrayList<String> a, String b, int i, int j,
	                    int len, boolean[][] visited) {
	    if (len == b.length()) return true;
	    int m = a.size();
	    int n = a.get(0).length();

	    if (i < 0 || i >= m || j < 0 || j >= n) return false;

	    //if (visited[i][j] == true || a.get(i).charAt(j) != b.charAt(len)) return false;
	    if (a.get(i).charAt(j) != b.charAt(len)) return false;

	    visited[i][j] = true;
	    if (_sol(a, b, i+1, j, len+1, visited) ||
	        _sol(a, b, i-1, j, len+1, visited) ||
	        _sol(a, b, i, j+1, len+1, visited) ||
	        _sol(a, b, i, j-1, len+1, visited)) return true;
	    visited[i][j] = false;

	    return false;
	}

*/