package Questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
  /*  public static void SpiralTraversal (List<ArrayList<Integer>> grid){
        //print the elements of the 2-d array in spiral order
        int leftUpper=0, rightUpper=grid.get(0).size()-1, leftLower=grid.size()-1, rightLower=grid.get(grid.size()).size()-1;
        while(){ // leftUpper < leftLower && rightUpper < rightLower && leftUpper < rightUpper && leftLower < rightLower
            // clockwise traversal
            //left to right ->  right to bottom right ->  bottom right to bottom left --> bottom left to left
            //leg 1
            for (int i = 0; i < grid.get(leftUpper).size(); i++) {
                System.out.print(grid.get(leftUpper).get(i) + " ");
            }
            leftUpper++;
            rightUpper++;
            //leg 2

        }
    }*/
  public static void SpiralTravel ( int[][] grid){
      int top=0, bottom = grid.length-1,left = 0, right = grid[0].length-1;
/*      System.out.print("THE POINTERS ARE : " +"TOP =" + top + " " + "BOTTOM =" +bottom + " "  + "LEFT =" +left + " " + "RIGHT =" +right);
      System.out.println();*/
      while(top!=bottom || left!=right){
          for (int i = left; i <= right; i++) {
              System.out.print(grid[top][i] + " ");
          }
          if( top < bottom ) {
              top++;
/*
              System.out.println();
              System.out.println("Leg - 1 THE POINTERS ARE : " + "TOP =" + top + " " + "BOTTOM =" + bottom + " " + "LEFT =" + left + " " + "RIGHT =" + right);
*/
          }else if (top == bottom) {
              left = right;
              break;
          }
          //if(top== bottom)
          for (int i = top; i <= bottom ; i++) {
              System.out.print(grid[i][right] + " ");
          }
          if ( left < right ) {
              right--;
/*
              System.out.println();
              System.out.println ("Leg - 2 THE POINTERS ARE : " +"TOP =" + top + " " + "BOTTOM =" +bottom + " "  + "LEFT =" +left + " " + "RIGHT =" +right);
*/

          }else if(left==right) {
              top = bottom;
              break;
          }

          for (int i = right; i >=left ; i--) {
              System.out.print(grid[bottom][i] + " ");
          }
          if ( top < bottom ) {
              bottom--;
/*
              System.out.println();
              System.out.println ("Leg - 3 THE POINTERS ARE : " +"TOP =" + top + " " + "BOTTOM =" +bottom + " "  + "LEFT =" +left + " " + "RIGHT =" +right);

*/
          }else if ( top ==bottom){
              right = left;
              break;
          }

          for (int i = bottom; i >=top ; i--) {
              System.out.print(grid[i][left]+ " ");
          }
          if ( left < right ) {
              left++;
/*
              System.out.println();
              System.out.println ("Leg - 4 THE POINTERS ARE : " +"TOP =" + top + " " + "BOTTOM =" +bottom + " "  + "LEFT =" +left + " " + "RIGHT =" +right);
*/

          }else if (left==right){
              bottom = top;
              break;
          }

      }
      if(grid.length==grid[0].length && grid.length%2==1 ) System.out.println(grid[top][right]);
  }

    public  static  int[] SpiralTravel2 ( int[][] grid){
        int top=0, bottom = grid.length-1,left = 0, right = grid[0].length-1;
        int direction=0,outputIndex=0;
        int[] output = new int [grid.length * grid[0].length];
        while (top <=bottom && left<=right){
            switch (direction){
                case 0 :
                    for (int i = left; i <= right ; i++) output[outputIndex++] = grid[top][i];
                    top++;
                    direction = 1;
                    break;
                case 1 :
                    for (int i = top; i <=bottom ; i++) output[outputIndex++] = grid[i][right];
                    right--;
                    direction = 2;
                    break;
                case 2 :
                    for (int i = right; i >= left ; i--) output[outputIndex++] = grid[bottom][i];
                    bottom--;
                    direction = 3;
                    break;
                case 3 :
                    for (int i = bottom; i >= top ; i--) output[outputIndex++] = grid[i][left];
                    left++;
                    direction = 0;
                    break;
            }
        }
        return output;
    }
    public static void main (String[] args){
        /*ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> rowOne =  new ArrayList<Integer>();
        rowOne.add(1);
        rowOne.add(2);
        rowOne.add(3);
        rowOne.add(4);
        grid.add(rowOne);
        ArrayList<Integer> rowTwo =  new ArrayList<Integer>();
        rowTwo.add(5);
        rowTwo.add(6);
        rowTwo.add(7);
        rowTwo.add(8);
        grid.add(rowTwo);
        ArrayList<Integer> rowThree =  new ArrayList<Integer>();
        rowThree.add(9);
        rowThree.add(10);
        rowThree.add(11);
        rowThree.add(12);
        grid.add(rowThree);
        SpiralTraversal(grid)*/;
/*
        int[][] grid = {{ 1, 2, 3, 4,22},
                        { 5, 6, 7, 8,23},
                        { 9,10,11,12,24},
                        {13,14,16,17,26},
                        {18,19,20,21,27}};
*/
        int[][] grid = {{ 1, 2, 3, 4,22},
                        { 5, 6, 7, 8,23},
                        { 9,10,11,12,24},
                        {18,19,20,21,27}};

        SpiralTravel(grid);
        int[] spiral = SpiralTravel2(grid);
        System.out.println();
        for (int number:spiral ) {
            System.out.print(number + " ");
        }
    }
}
