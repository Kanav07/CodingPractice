package Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class AllFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        /*for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }*/
        long start = System.nanoTime();
        //call function here.....
        inputList = allFactors(input);
        long end = System.nanoTime();
        for (Integer x : inputList) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


    }
    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        if ( a == 1 ){
            factors.add(a);
            return factors;
        }
        for( int i = 1; i <= Math.sqrt(a) ; i ++){
            if ( a % i == 0 ) {
                insertInPlace(factors,i);
                insertInPlace(factors,a/i);
            }
        }
        return factors;
    }
    public static void insertInPlace( ArrayList<Integer> list, int a){
        if ( list.size() ==0 ) list.add(a);
        else{
            int i;
            for (i = 0; i < list.size(); i++) {
                if( list.get(i) >= a){
                    if(list.get(i) > a ) list.add(i,a);
                    break;
                }
            }
            if (i ==list.size()) list.add(a);
        }
    }
}
