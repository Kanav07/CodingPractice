package Questions.practice;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Implement pow(x, n) % d.

In other words, given x, n and d,

find (x^n % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
*/

//Input : 2147483647
// Expected : 46340
// My Code : 

public class ImplementPowerFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 10;// = sc.nextInt();
        int n = 9;//sc.nextInt();
        int d = 7;//sc.nextInt();
        /*int inputNumber;
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }*/
        long start = System.nanoTime();
        //call function here.....
        int remainder = powBest(x, n, d);
        //x =740819855;//5;// 2147483647;
        //int sqrt = sqrt(x);
        long end = System.nanoTime();
        System.out.println(remainder);
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
         remainder = powRecursive(x, n, d);
        //x =740819855;//5;// 2147483647;
        //int sqrt = sqrt(x);
         end = System.nanoTime();
        System.out.println(remainder);
        System.out.println("\nTime taken : " + (end - start));


        /*start = System.nanoTime();
        //call function here.....
         remainder = pow(x, n, d);
        end = System.nanoTime();
        System.out.println(remainder);
        System.out.println("\nTime taken : " + (end - start));*/

    }

    public static int pow(int x, int n, int d) {
        if (n == 0 || x == 1) return d > 1 ? 1 : 0;
        if (x == 0 || n < 0  ) return 0;
        boolean isNeg = false;
        if (x < 0 )
        {
            x = Math.abs(x);
            if (n % 2 != 0) {
                isNeg = true;
            }
        }


        long temp = x % d, remainder = 1;
        while (n != 1) {
            if (n%2!=0) {
                remainder = (remainder* temp)%d;
            }
            temp = temp * temp;
            temp = temp % d;
            n = n / 2;
            if ( remainder > d) {
                remainder= remainder%d;
            }
        }
        if ( isNeg) return d - (int)remainder;
        return (int) remainder;

    }


    public static int powRecursive(int x, int n, int d){
        if ( n == 0)  return d > 1 ? 1 : 0;
        if ( n ==1 ) return x%d;

        if (n%2==0) return (powRecursive((x*x)%d , n/2,d))%d;
        else return (x*powRecursive(x*x, n/2,d))%d;
    }

    public static int powBest(int x, int n, int d) {

        long rem = 1;
        int check = 0;

        // simple cases
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        // make x positive, check if power is odd
        if (x < 0) {
            x = Math.abs(x);
            if (n % 2 != 0) {
                check = 1;
            }
        }

        long temp = x % d;

        while (n != 0) {
            if (n % 2 != 0) {
                rem = (rem * temp) % d;
            }

            temp = temp * temp;
            temp = temp % d;

            n = n / 2;
            if (rem > d) {
                rem = rem % d;
            }
        }

        // if power is odd and x < 0, return d-rem
        if (check == 1) {
            return d - (int) rem;
        }

        return (int) rem;
    }


    public static  int sqrt(int a) {
        if ( a==0 ) return 0;
        if ( a < 4) return 1;
        else{
            int low=0, high = a;
            long temp=1;
            while ( low <= high){
                temp = (low + high)/2;
                if ( temp * temp == a ) return (int) temp;
                if ( temp * temp > a) {
                    high = (int)temp-1;
                }
                else {
                    low = (int)temp+1;
                }
            }
            return (int)temp;

        }
    }
}


/* SOLUTION APPROACH

*/