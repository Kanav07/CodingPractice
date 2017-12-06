package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
*/

/*  Input :  6 0 1 2 0 1 2

    Expected :
    My Code : 
*/

public class SortByColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        ArrayList<Integer> inputListcopy = (ArrayList<Integer>) inputList.clone();
        long start = System.nanoTime();
        //call function here.....
        sortColors(inputList);
        for (int x : inputList) System.out.print(x + " ");
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
        sortColorsSwappingApproach(inputListcopy);
        for (int x : inputList) System.out.print(x + " ");

        end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));
    }


    public static void sortColors(ArrayList<Integer> a) {

        if ( a== null || a.size() < 1) return;

        int c0=0,c1=0,c2=0;

        for ( int i =0; i< a.size(); i++){
            if ( a.get(i).intValue()== 0 ) c0++;
            else if ( a.get(i).intValue()== 1 ) c1++;
            else c2++;
        }

        for ( int i =0; i< a.size(); i++){
            if ( c0 > 0 ){
                a.set(i,0);
                c0--;
            }else if ( c1 > 0 ){
                a.set(i,1);
                c1--;
            } else if ( c2 > 0 ){
                a.set(i,2);
                c2--;
            }
        }
    }


    public static void sortColorsSwappingApproach(ArrayList<Integer> a) {

        if ( a== null || a.size() < 1) return;


        int away=0,home=0,temp;
        while (away < a.size()-1){
            if ( a.get(away).intValue()==0) away++;
            else {
                home = away+1;
                while (home < a.size()) {
                    if (a.get(home).intValue() != 0) home++;
                    else{
                        a.set(home,a.get(away));
                        a.set(away,0);
                        away++;
                        break;
                    }
                }
                if ( home == a.size() ) break;
            }
        }
        away = a.size()-1;
        while (away > 0){
            if ( a.get(away).intValue()==2) away--;
            else {
                home = away-1;
                while (home >= 0) {
                    if (a.get(home).intValue() != 2) home--;
                    else{
                        a.set(home,a.get(away));
                        a.set(away,2);
                        away--;
                        break;
                    }
                }
                if ( home < 0 ) break;
            }
        }



    }
}

/* SOLUTION APPROACH

*/