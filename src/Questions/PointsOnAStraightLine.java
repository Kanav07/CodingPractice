package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/* QUESTION

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

*/

/*  

Input : 2 1 2 2 4
Expected :
My Code : 

Input :  3 0 0 1 1 -1 -1
Expected : 3
My Code : 


Input : 6 -6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20
Expected : 2
My Code :

Input :
Expected :
My Code :

*/

public class PointsOnAStraightLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputListX = new ArrayList<Integer>();
        ArrayList<Integer> inputListY = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputListX.add(inputNumber);
             inputNumber = sc.nextInt();
            inputListY.add(inputNumber);
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(maxPoints(inputListX,inputListY));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    static class Line{
        public double m;
        public  double c;

        public Line(double m, double c) {
            this.m = m;
            this.c = c;
        }

        public Line(Line temp) {
            this.m = temp.m;
            this.c = temp.c;
        }

        @Override
        public boolean equals(Object o) {
            Line x = (Line) o;
            if(x.m == this.m && x.c == this.c) return true;
            else return false;
        }

        @Override
        public int hashCode()
        {
            return (int)(this.m + this.c);
        }

    }

    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b)  {

        if ( a.size() < 2 || b.size() < 2) return a.size()==0 ? 0 : 1;


        HashMap<Line,HashMap<Integer,Integer>> map = new HashMap<Line, HashMap<Integer, Integer>>();
        // The hashmap will store the attributes of the line, and a record of all the points that lie on it.
        // Instead of maintaining a list of points , keeping a Hashmap in which the index of the points will be stored to avoid repeitions. Eg, if a , b ,c lie on the same line ( m,c ) and the Hashmap already has an entry ( m,c) --> (a,b), then when the points b & c will be checked, only c will be added to the entry ( m,c)
        Line temp = new Line(0,0);
        int maxPoints = 0;


        for (int i = 0; i < a.size(); i++) {
            int x1 = a.get(i);
            int y1 = b.get(i);
            for (int j = i + 1; j < a.size() ; j++) {
                int x2 = a.get(j);
                int y2 = b.get(j);
                double slope,constant;
                if ( x2 - x1 !=0 )  {
                    slope = (y2 - y1)/(double)(x2 - x1);
                    constant = (y1*x2 - y2*x1)/(double)(x2 -x1);
                }
                else {
                    slope = (double) Integer.MAX_VALUE;
                    constant=  x1;
                }
                temp.m = slope;
                temp.c = constant;

                if ( !map.containsKey(temp)) {
                    // storing the Line
                    HashMap<Integer,Integer> points = new HashMap<Integer, Integer>();
                    points.put(i,1);
                    points.put(j,1);
                    int count = points.size();
                    if ( count > maxPoints) maxPoints = count;
                    map.put(new Line(temp),points);
                }
                else {
                    HashMap<Integer,Integer> points = map.get(temp);
                    if ( !points.containsKey(i) ) points.put(i,1);
                    if ( !points.containsKey(j) ) points.put(j,1);
                    int count = points.size();
                    if ( count > maxPoints) maxPoints = count;
                }
            }
        }
        return maxPoints;
    }

}

/* SOLUTION APPROACH

*/