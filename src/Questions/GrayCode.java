package Questions;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow; 

/* QUESTION


The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.


*/

/*  Input : 
    Expected :
    My Code : 
*/

public class GrayCode {
    public static void main(String[] args) {

        int input = 3;
        long start = System.nanoTime();
        //call function here.....
        // Solution ( inputList );
        ArrayList<Integer> output = grayCode(input);
        long end = System.nanoTime();
        for (Integer s : output) System.out.println(s);
        System.out.println("\nTime taken : " + (end - start));

    }

    public static ArrayList<Integer> grayCode(int a) {
        
        ArrayList<StringBuilder> gray_matter = new ArrayList<StringBuilder>();
        gray_matter.add(new StringBuilder("0"));
        gray_matter.add(new StringBuilder("1"));

        StringBuilder temp  = new StringBuilder();
        for (int i = 0; i < a; i++)  temp.append('0');
        
        
        ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();
        for (int i = 0; i < pow(2,a); i++) output.add(temp);
        
//        generateGrayCode(a,gray_matter,output);
        
        int output_index = 0;
        ArrayList<StringBuilder> new_gray_matter = new ArrayList<StringBuilder>();
        for (int i = 0; i < a; i++) {
        int next_grey_index = i+1;
            for (int j = 0; j < gray_matter.size() && output_index < output.size(); j++) {
                StringBuilder temp1 = new StringBuilder(output.get(output_index));
                temp1.replace(0,i+1,gray_matter.get(j).toString());
                output.set(output_index,temp1);

                if(i % 2 == 0 ) output.get(output_index).setCharAt(i+1,'0');
                else output.get(output_index).setCharAt(i+1,'1');
                String temp2 = output.get(output_index).substring(0,next_grey_index+1);
                new_gray_matter.add(new StringBuilder(temp2));
                output_index++;
            }
            for (int j = gray_matter.size()-1; j >= 0 &&  output_index < output.size(); j--) {
                StringBuilder temp1 = new StringBuilder(output.get(output_index));
                temp1.replace(0,i+1,gray_matter.get(j).toString());
                output.set(output_index,temp1);

                if(i % 2 == 0 ) output.get(output_index).setCharAt(i+1,'1');
                else output.get(output_index).setCharAt(i+1,'0');
                String temp2 = output.get(output_index).substring(0,next_grey_index+1);
                new_gray_matter.add(new StringBuilder(temp2));
                output_index++;

            }
            gray_matter = new_gray_matter;
            new_gray_matter = new ArrayList<StringBuilder>();
            }


            return null;
        }

        
        
    }

//    private static void generateGrayCode(int a, ArrayList<String> gray_matter, ArrayList<String> output) {
//
//        for (int i = 0; i < ; i++) {
//
//        }
//    }


/* SOLUTION APPROACH

*/