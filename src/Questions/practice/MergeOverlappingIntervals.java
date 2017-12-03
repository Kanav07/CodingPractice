package Questions.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import static java.lang.Math.*;

// 6 1 10 2 9 3 8 4 7 5 6 6 6
// 29 54 75 56 60 61 86 22 43 56 87 32 53 14 81 64 65 9 42 12 33 22 58 84 90 27 59 41 48 43 47 22 29 16 23 41 72 15 87 20 59 45 84 14 77 72 93 20 58 47 53 25 88 5 89 34 97 14 47
// 8 93 94 26 28 57 79 15 34 1 56 36 51 47 64 11 16 


public class MergeOverlappingIntervals {


      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }

          @Override
          public String toString() {
              return "{" +
                      " " + start +
                      ", " + end +
                      " }";
          }
      }

      public static class IntervalComparator implements Comparator<Interval>{

          @Override
          public int compare(Interval i1, Interval i2) {
              if( i1.start < i2.start) return -1;
              else  return 1;
          }
      }

    public static void main ( String[] args){
        Scanner sc = new Scanner(System.in);
        int noOfSets = sc.nextInt();
        int XCoods,YCoods;
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < noOfSets; i++) {
            XCoods = sc.nextInt();
            YCoods = sc.nextInt();
            intervals.add(new Interval(XCoods,YCoods));
        }
        long start =System.nanoTime();
        ArrayList<Interval> intervals1 = mergeImproved(intervals);
        long end =System.nanoTime();
        System.out.println("Time taken : " + (end -start));
        start =System.nanoTime();
        intervals = merge(intervals);
        end =System.nanoTime();
        System.out.println("Time taken : " + (end -start));
        for (Interval i : intervals
             ) {
            System.out.println(i);
        }

        for (Interval i : intervals1
                ) {
            System.out.println(i);
        }
    }

    public static  ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int a1,a2,b1,b2;
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i+1; j < intervals.size() ; j++) {
                a1 = intervals.get(i).start;
                a2 = intervals.get(i).end;
                b1 = intervals.get(j).start;
                b2 = intervals.get(j).end;
                if ( max(a1,b1) <= min(a2,b2) ){
                    intervals.remove(i);
//                    for (int k = 0; k <= i; k++) {
//                        if(  i==0 || intervals.get(i).start > max(b1,b2)) intervals.add(i,new Interval(min(a1,b1), max(a2,b2)));
//                    }
                    intervals.add(i,new Interval(min(a1,b1), max(a2,b2)));
                    intervals.remove(j);
                    j=i;
                }

            }
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        return intervals;
    }

    public static  ArrayList<Interval> mergeImproved(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        ArrayList<Interval>res=new ArrayList<Interval>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<=end)
            {
                end=Math.max(intervals.get(i).end,end);
            }
            else
            {
                res.add(new Interval(start,end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }
        res.add(new Interval(start,end));

        return res;
    }

}
