package TestQues;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION

Write a function in Python/Java/C++ that converts a positive integer into a string representation using only 3 characters 0, 1 and 2 such that
0 = “0”
1 = “1”
2 = “2”____
3 = “00”
4 = “01”
5 = “02”_____
6 = “10”
7 = “11”
8 = “12”_____
09 = “20”
10 = “21”
11 = “22”____
12 = “000”
13 = “001”
14 = “002”___
15 = “010”
And so on ….
*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class TwistedBinaryConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int inputListSize = sc.nextInt();
//
//        ArrayList<String> inputList = new ArrayList<String>();
//        for (int i = 0; i < inputListSize; i++) {
//            String in = sc.next();
//            inputList.add(in);
//        }
        long start = System.nanoTime();
        //call function here.....
        for (int i = 0; i < 900 ; i++) {
            System.out.printf("%3d  => '%s'\n",i,conv(i));

        }
        //System.out.println(conv(1));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }


    public static String conv( int a){

        StringBuilder res= new StringBuilder();

        int x = a%3;
        res.append((char)(x + '0'));
        a = a - x;
        int temp, multi = 3;

        while (a > 0){

            if ( a - multi*3 == 0 || ((a - multi*3 )%(multi*3) < 3 && (a - multi*3 >= multi*3))) {
                res.append(2);
                a = a - multi*3;
            } else  if ( a - multi*2 == 0 || (a - multi*2)%(multi*3) < 3 && (a - multi*2 >= multi*3)){
                res.append(1);
                a = a - multi*2;
            } else  if ( a - multi == 0 || (a - multi)%(multi*3) < 3 && (a - multi >= multi*3)){
                res.append(0);
                a = a - multi;
            }
            multi = multi*3;
        }
        res.reverse();
        return res.toString();


    }
}

/* SOLUTION APPROACH

  0  => '0'
  1  => '1'
  2  => '2'
  3  => '00'
  4  => '01'
  5  => '02'
  6  => '10'
  7  => '11'
  8  => '12'
  9  => '20'
 10  => '21'
 11  => '22'
 12  => '000'
 13  => '001'
 14  => '002'
 15  => '010'
 16  => '011'
 17  => '012'
 18  => '020'
 19  => '021'
 20  => '022'
 21  => '100'
 22  => '101'
 23  => '102'
 24  => '110'
 25  => '111'
 26  => '112'
 27  => '120'
 28  => '121'
 29  => '122'
 30  => '200'
 31  => '201'
 32  => '202'
 33  => '210'
 34  => '211'
 35  => '212'
 36  => '220'
 37  => '221'
 38  => '222'
 39  => '0000'
 40  => '0001'
 41  => '0002'
 42  => '0010'
 43  => '0011'
 44  => '0012'
 45  => '0020'
 46  => '0021'
 47  => '0022'
 48  => '0100'
 49  => '0101'
 50  => '0102'
 51  => '0110'
 52  => '0111'
 53  => '0112'
 54  => '0120'
 55  => '0121'
 56  => '0122'
 57  => '0200'
 58  => '0201'
 59  => '0202'
 60  => '0210'
 61  => '0211'
 62  => '0212'
 63  => '0220'
 64  => '0221'
 65  => '0222'
 66  => '1000'
 67  => '1001'
 68  => '1002'
 69  => '1010'
 70  => '1011'
 71  => '1012'
 72  => '1020'
 73  => '1021'
 74  => '1022'
 75  => '1100'
 76  => '1101'
 77  => '1102'
 78  => '1110'
 79  => '1111'
 80  => '1112'
 81  => '1120'
 82  => '1121'
 83  => '1122'
 84  => '1200'
 85  => '1201'
 86  => '1202'
 87  => '1210'
 88  => '1211'
 89  => '1212'
 90  => '1220'
 91  => '1221'
 92  => '1222'
 93  => '2000'
 94  => '2001'
 95  => '2002'
 96  => '2010'
 97  => '2011'
 98  => '2012'
 99  => '2020'
100  => '2021'
101  => '2022'
102  => '2100'
103  => '2101'
104  => '2102'
105  => '2110'
106  => '2111'
107  => '2112'
108  => '2120'
109  => '2121'
110  => '2122'
111  => '2200'
112  => '2201'
113  => '2202'
114  => '2210'
115  => '2211'
116  => '2212'
117  => '2220'
118  => '2221'
119  => '2222'
120  => '00000'
121  => '00001'
122  => '00002'
123  => '00010'
124  => '00011'
125  => '00012'
126  => '00020'
127  => '00021'
128  => '00022'


*/