package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Example :
Input

         Number of islands ( n ) = 4
         1 2 1
         2 3 4
         1 4 3
         4 3 2
         1 3 10
In this example, we have number of islands(n) = 4 . Each row then represents a bridge configuration. In each row first two numbers represent the islands number which are connected by this bridge and the third integer is the cost associated with this bridge.

In the above example, we can select bridges 1(connecting islands 1 and 2 with cost 1), 3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4 and 3 with cost 2). Thus we will have all islands connected with the minimum possible cost(1+3+2 = 6).
In any other case, cost incurred will be more.

See Expected Output

*/

/*  

Input : 4
4 3 1 2 1 2 3 2 3 4 4 1 4 3
Expected : 6
My Code : 

Input : 3
3 3 1 2 10 2 3 5 1 3 9
Expected : 14
My Code : 

*/

public class CommutableIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int islands = sc.nextInt();
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
        System.out.println();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(islands,inputMatrix));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }
    static int min = Integer.MAX_VALUE;

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[][] bridges = new int[A][A];

        for(int i =0; i < B.size(); i++) {
            bridges[B.get(i).get(0)-1][B.get(i).get(1)-1] = B.get(i).get(2);
            bridges[B.get(i).get(1)-1][B.get(i).get(0)-1] = B.get(i).get(2);
        }

        for (int i = 0; i < bridges.length; i++) {
            dfs(bridges,i,new int[A],0);
            bfs(bridges,i,new int[A],0);

        }
        return min;
    }

    private static void bfs(int[][] br, int k, int[] visited, int cost) {

        boolean f = true;
        for (int i = 0; i < br.length; i++) {
            if (visited[i] == 0) {
                f = false;
                break;
            }
        }
        if (f == true) {
            min = cost < min ? cost : min;
            return;
        }

        visited[k] = 1;


        for (int i = 0; i < br.length; i++) {
            if (visited[i] == 1 || br[k][i] == 0) continue;
            cost += br[k][i];
            visited[i] = 2;
        }

        for (int i = 0; i < br.length; i++) {
            if(visited[i]==2) bfs(br,i,visited,cost);
        }

    }

    public static void dfs(int[][] br, int k,int[] visted,int cost) {

        boolean f = true;
        for(int i = 0; i < br.length; i++) {
            if( visted[i] == 0) {
                f=false; break;
            }
        }
        if( f == true ) {
            min = cost < min ? cost : min;
            return;
        }

        visted[k]=1;


        for (int i = 0; i < br.length ; i++) {
            if(visted[i]==1 || br[k][i]==0) continue;
            cost += br[k][i];
            visted[i] =1;
            dfs(br,i,visted,cost);
            visted[i] = 0;
            //visted[k] =0;
        }

    }
}

/* SOLUTION APPROACH

*/