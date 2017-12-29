package algorithmsBasics;

import Questions.BTreePrint;
import Questions.Node;
import Questions.TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

*/

/*  

Input : 
Expected :
My Code : 

Input : 6 5 3 2 6 1 4

Expected : 4 8 2 1 3
My Code : 

*/

public class SegmentTrees {

    static int INITIALISER  = Integer.MAX_VALUE;

    public void setINITIALISER(int INITIALISER) {
        this.INITIALISER = INITIALISER;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        int[] inputList = new int[inputListSize];
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList[i] = (inputNumber);
        }
        int rlow = sc.nextInt();
        int rhigh = sc.nextInt();
        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] output = buildSegamentTree(inputList);
        convertArrayToTree(output);
        for (int i = 0; i < output.length ; i++) {
            result.add(output[i]);
        }
        System.out.println(result);
        System.out.println(rangeMnimum(rlow,rhigh,inputList));

        int low = sc.nextInt();
        int high = sc.nextInt();
        int delta = sc.nextInt();
        updateRange(low,high,output,delta,inputListSize);
        result.clear();
        for (int i = 0; i < output.length ; i++) {
            result.add(output[i]);
        }
        convertArrayToTree(output);
        System.out.println(result);

        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static void convertArrayToTree(int[] list){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.length ; i++) {
            if( list[i] == Integer.MAX_VALUE) result.add(-2);
            else result.add(list[i]);
        }
        int size = (list.length + 1)/2;
        for (int i = 0; i < 2*size ; i++) {
            result.add(-1);
        }
        Node root2 = BTreePrint.InsertIntoTree(result);

        BTreePrint.printNode(root2);
        return;
    }

    public static int[] buildSegamentTree(int[] input){

        int n = input.length;
        int segamentTreeSize;
        for (segamentTreeSize = 1; segamentTreeSize < n; segamentTreeSize*=2) ;
        segamentTreeSize = 2*segamentTreeSize-1;
        int[] segamentTree = new int[segamentTreeSize];

        for (int i = 0; i < segamentTreeSize ; i++) {
            segamentTree[i] = Integer.MAX_VALUE;
        }
        constructSegamentTree(input,segamentTree,0,n-1,0);
        return segamentTree;
    }

    public static void constructSegamentTree(int[] input, int[] segamentTree, int start, int end,int pos) {

        if( start==end){
            segamentTree[pos] = input[start];
            return;
        }
        int mid = start + ( end - start)/2;
        constructSegamentTree(input,segamentTree,start,mid,2*pos+1);
        constructSegamentTree(input,segamentTree,mid+1,end,2*pos+2);
        segamentTree[pos] = Math.min(segamentTree[2*pos+1],segamentTree[2*pos+2]);
    }


    public static int rangeMnimum( int start, int end, int[] inputList){
        if( start== end) return inputList[start];
        int[] segamentTree = buildSegamentTree(inputList);
        return rangeMinimumQuery(0,inputList.length-1,segamentTree,start,end,0);
    }

    public static int rangeMinimumQuery( int start, int end,int[] segamentTree,int rangeLow, int rangeHigh,int pos){

        if( start >= rangeLow && end <= rangeHigh){
            return segamentTree[pos];
        }

        if( start > rangeHigh || end < rangeLow ) return Integer.MAX_VALUE;

        int mid = start + (end-start)/2;
        return Math.min(rangeMinimumQuery(start,mid,segamentTree,rangeLow,rangeHigh,2*pos+1),
                rangeMinimumQuery(mid+1,end,segamentTree,rangeLow,rangeHigh,2*pos+2));
    }


    public static void updateRange(int rangelow, int rangehigh, int[] segamentTree, int delta,int inputlength){
        updateRangeSegamentTree(rangehigh,rangelow,segamentTree,delta,0,inputlength-1,0);
    }

    private static void updateRangeSegamentTree(int rangehigh, int rangelow, int[] segamentTree, int delta, int low, int high, int pos) {


        if(low > rangehigh || high < rangelow){
            return;
        }

        if( low == high){
            segamentTree[pos] = segamentTree[pos] + delta;
            return;
        }

        int mid = low +  ( high - low)/2;

        updateRangeSegamentTree(rangehigh,rangelow,segamentTree,delta,low,mid,2*pos+1);
        updateRangeSegamentTree(rangehigh,rangelow,segamentTree,delta,mid+1,high,2*pos+2);

        segamentTree[pos] = Math.min(segamentTree[2*pos+1],segamentTree[2*pos+2]);
    }


}

/* SOLUTION APPROACH

*/