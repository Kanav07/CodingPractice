package Questions;

import java.util.ArrayList;
import java.util.Scanner;

/* QUESTION

Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.

Lets say we are given a binary grid of 3 * 3 size.

1 0 1

0 1 0

1 0 0

At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:

1 1 0

0 0 1

1 0 0

Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case. Hence 2 will be the answer in this case.

*/

/*  

Input : 22 75
0 1 0 1 1 1 1 0 1 1 0 0 1 0 0 0 0 1 1 1 0 1 1 0 0 0 0 0 0 1 1 1 1 0 1 0 1 0 1 0 0 0 0 1 1 0 0 1 1 1 1 0 1 0 1 0 1 0 1 1 1 0 1 1 0 1 0 0 1 1 1 0 0 0 0
1 1 0 0 0 0 0 0 0 1 0 1 1 1 0 0 1 1 1 1 1 0 0 0 0 1 0 0 1 0 1 1 0 0 0 1 1 1 0 1 1 0 1 0 0 0 1 0 0 1 1 0 1 0 0 1 1 1 1 0 1 0 0 1 1 0 0 0 1 1 0 0 0 1 0
1 0 0 0 0 0 0 1 0 1 0 1 1 1 0 1 0 0 0 0 1 1 0 1 1 0 0 1 1 1 1 0 1 1 1 0 1 1 0 1 1 0 0 0 1 0 1 1 0 1 1 0 0 0 1 1 1 1 0 1 1 0 0 1 0 1 0 1 0 0 1 1 0 0 1
1 1 1 1 1 0 1 0 0 0 0 1 0 0 1 0 0 1 1 0 1 1 1 0 1 1 0 0 0 0 1 1 0 1 0 0 1 1 0 1 0 1 0 0 1 1 0 1 1 1 0 0 1 1 0 1 0 1 0 0 1 1 0 1 1 1 1 0 1 0 1 0 1 0 1
0 1 0 0 1 1 1 1 0 1 0 0 0 1 0 0 1 0 1 0 0 0 1 0 1 1 1 1 0 1 0 1 0 0 1 1 1 0 0 1 1 1 0 1 0 1 0 0 1 1 1 1 0 1 1 1 0 1 0 0 0 1 1 0 1 1 0 0 1 0 1 0 0 1 0
0 1 0 0 1 1 1 0 1 1 1 0 0 0 0 0 0 0 0 1 1 1 0 1 0 1 0 0 0 0 1 0 0 1 0 1 1 0 1 0 1 0 0 0 0 1 0 0 1 0 0 1 1 1 1 0 0 0 1 1 0 0 1 1 1 0 0 1 1 0 1 1 0 1 1
0 0 0 1 1 0 1 1 1 0 0 0 0 0 1 1 1 1 1 0 0 1 1 1 1 1 0 1 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 1 1 0 0 0 1 1 0 0 0 1 1 1 1 1 0 0 0 0 1 1 0 0 0 0 0 1 1 0 1 0 1
0 1 1 1 1 1 1 1 0 0 0 0 1 1 1 0 0 1 0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 1 1 0 1 1 1 0 1 1 0 1 1 1 1 1 0 1 0 1 1 0 1 0 1 0 0 0 1 1 1 1 1 0 1 1 0 0 1 0 1 0 1
1 1 1 1 0 1 1 1 1 0 0 1 1 1 1 1 0 1 0 1 0 0 0 0 0 0 1 1 0 0 1 0 0 1 1 0 1 1 0 0 1 0 1 0 1 0 1 1 0 1 1 1 1 1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 1 1 1
0 0 0 0 0 0 1 0 1 0 0 1 1 1 1 1 1 0 0 0 1 1 1 0 0 0 1 1 0 1 0 1 1 0 1 1 1 1 1 1 0 1 0 1 0 1 1 1 0 1 1 1 1 0 0 1 1 0 1 0 1 0 1 0 0 0 0 1 1 0 1 1 1 1 0
0 1 1 0 1 0 1 0 0 1 0 0 0 1 0 0 1 0 0 0 0 0 1 0 0 0 1 1 0 0 0 1 0 0 0 1 0 1 1 1 0 0 1 1 0 0 0 0 1 1 0 1 1 1 1 1 0 1 0 0 1 1 1 1 0 1 0 1 1 0 0 0 1 0 0
0 1 0 0 0 1 1 1 0 1 1 1 0 0 0 0 1 1 1 1 0 1 0 0 0 1 0 0 0 1 1 0 0 0 0 0 1 1 0 1 1 1 1 1 1 1 1 0 0 0 1 0 0 1 1 0 1 1 1 1 1 0 0 1 1 1 1 0 1 1 0 0 1 0 0
1 0 1 0 0 1 0 1 0 0 1 1 0 0 1 0 0 0 1 0 1 0 0 1 0 0 1 0 1 0 0 0 1 0 1 1 0 1 0 1 1 1 1 0 1 1 1 1 0 0 1 1 0 1 0 1 1 1 1 1 0 1 0 1 1 0 1 0 1 0 1 0 0 1 1
1 0 1 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 0 1 0 1 0 1 0 0 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 0 1 0 1 0 1 0 0 1 1 1 0 0 0 1 1 1 0 0 1 1 1 0 0 1 0 0 1 0 1 0 0 0
1 1 1 0 0 1 1 0 0 0 0 1 1 0 0 0 1 1 0 1 1 0 1 1 1 1 0 1 0 0 1 1 0 0 0 0 1 1 0 1 0 1 1 0 0 1 0 0 0 0 0 1 0 0 0 0 1 1 0 1 0 1 1 0 0 1 0 0 0 0 0 0 0 0 0
1 1 0 0 0 1 1 1 1 0 1 1 1 1 0 1 1 0 0 0 0 0 0 0 1 1 1 1 0 1 1 0 0 1 1 1 0 0 0 1 1 0 1 1 0 1 0 0 1 1 1 0 0 1 1 1 0 1 0 0 1 1 1 1 1 1 0 0 1 1 1 1 0 0 0
0 1 0 0 1 1 1 1 1 0 1 0 1 1 1 1 0 0 1 1 0 0 0 1 0 0 0 1 1 0 0 0 0 1 0 1 1 0 0 1 0 1 1 1 0 0 1 1 1 1 0 1 0 1 0 1 0 0 0 1 1 0 0 0 0 1 1 1 1 0 0 1 0 1 1
1 1 1 1 1 1 0 0 1 1 1 1 0 0 0 0 1 1 0 0 1 1 1 0 1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1 0 1 0 1 1 0 1 0 0 1 0 0 0 1 1 0 1 1 0 1 0 0 1 0 1 0 1 1 1 0 0 0 0 0 0
1 0 1 0 0 0 1 1 1 1 0 0 1 1 1 1 0 1 0 1 1 0 0 0 0 1 0 1 1 0 1 0 0 1 0 1 1 1 0 0 1 0 1 1 1 1 1 0 1 0 1 0 1 1 0 0 1 1 1 1 0 1 1 1 0 0 1 0 1 0 0 0 0 0 1
0 1 1 1 0 0 1 1 1 1 0 1 0 1 1 0 0 1 1 0 1 1 1 0 0 1 0 0 1 1 1 0 1 0 1 1 0 0 1 0 0 0 1 1 0 1 0 1 1 0 0 1 0 0 0 0 1 0 1 1 1 1 0 1 1 0 0 0 1 1 1 1 1 1 0
0 0 1 0 0 1 1 1 0 1 0 0 0 0 0 1 1 0 0 0 0 1 1 0 1 1 0 0 1 1 0 0 1 1 1 1 1 0 1 1 1 1 1 1 0 0 1 1 0 1 1 1 1 1 0 1 0 1 0 1 0 1 0 1 1 0 0 0 0 0 0 0 1 0 1
0 0 1 0 0 0 1 1 1 1 1 0 0 1 0 1 1 1 0 1 0 0 1 0 0 1 1 1 0 1 0 1 1 1 1 0 0 0 0 0 1 1 0 1 0 1 0 1 1 0 0 1 0 1 0 0 1 1 0 0 0 0 0 0 0 0 1 1 1 1 1 0 1 0 1
43 17
0 1 0 1 1 1 1 1 0 0 1 1 0 0 1 1 0
1 0 0 1 0 1 0 0 0 1 1 0 0 1 0 1 0
1 1 0 1 0 1 1 0 1 1 1 1 0 1 1 1 0
0 0 0 1 0 1 1 0 1 1 1 0 1 1 1 1 0
1 1 0 0 1 0 0 0 1 0 1 0 1 1 0 1 0
1 1 1 0 0 0 1 1 1 0 0 0 0 1 1 0 0
0 1 1 0 1 0 0 0 0 1 1 1 0 1 0 1 1
1 0 1 1 1 1 1 1 1 0 1 1 0 0 0 0 1
1 1 1 0 0 1 0 0 0 1 1 0 0 1 1 1 1
0 0 0 0 1 0 0 0 0 1 1 1 1 0 1 1 1
0 0 0 1 1 1 0 0 0 0 0 0 1 0 0 0 1
0 0 1 0 1 1 1 0 1 0 0 0 1 0 1 0 0
1 0 0 0 0 1 1 0 1 1 1 0 1 1 0 0 1
0 1 1 1 1 0 1 1 0 0 1 1 0 0 1 1 1
1 1 0 0 0 1 0 0 0 1 1 0 1 1 0 1 1
0 0 0 0 1 0 1 0 0 0 0 1 0 0 1 0 0
0 1 1 1 1 1 1 0 1 1 0 1 0 0 1 0 1
1 1 1 1 0 1 0 1 1 1 0 0 0 1 0 0 1
0 1 0 1 0 0 0 0 1 0 1 1 0 0 1 1 1
0 0 1 1 0 0 0 0 0 0 1 0 0 0 1 1 0
0 0 1 1 1 0 1 1 0 1 0 1 0 0 0 1 1
0 0 0 1 0 1 1 1 1 1 0 0 1 1 0 0 1
1 1 1 0 0 0 1 1 1 1 0 0 0 0 1 1 1
0 0 1 1 0 0 0 1 0 1 1 0 1 0 1 0 1
0 1 1 0 0 1 0 1 0 0 0 1 0 0 1 0 0
1 0 1 1 0 0 1 1 1 0 1 0 0 1 0 1 1
0 0 0 1 0 1 1 0 1 1 1 1 0 0 1 1 0
1 0 1 1 1 0 1 0 1 1 0 1 0 1 0 1 1
0 0 1 1 1 0 0 1 0 1 1 0 1 0 0 0 0
Expected :
My Code : 

Input : 2 3
1 1 0
1 0 1
4 4
Expected :
My Code :

4 4
 1 1 1 0
 1 0 0 0
 1 1 0 1
 1 1 0 1

*/

public class LargestAreaRectangleWithPermutations {
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
        System.out.println();
        long start = System.nanoTime();
        //call function here.....
        System.out.println(solve(inputMatrix));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int m=A.size();
        int n=A.get(0).size();
        int hist[][]=new int [m][n];

        for(int i = 0; i < n; i++){
            hist[0][i]=A.get(0).get(i);
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A.get(i).get(j) == 1)
                    hist[i][j] =  hist[i-1][j] + 1;
                else
                    hist[i][j] = 0;
            }
        }


        int res=0;
        for(int i=0;i<m;i++){
            int count[]=new int[m+1];

            for(int j=0;j<n;j++){
                count[hist[i][j]]++;
            }
            int cnt=0;
            for(int k=m;k>=0;k--){
                cnt += count[k];
                res = Math.max(res, cnt * k);
            }


        }

        return res;

    }
}

/* SOLUTION APPROACH

*/