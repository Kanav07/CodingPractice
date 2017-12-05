package Questions;



/*Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
For example,
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
We will retroactively disqualify such submissions and the submissions will incur penalties.*/


/*
*
*
* */


import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args) {

//        String number1 = "6020453667958309279424408570378228292268488402";
//        String number2 = "0021473700594524297017810575200827941459805716642468749607585313713214621412";

//        String number1 = "2";
//        String number2 = "0";

//        String number1 = "6020453667958309279424408570378228292268488402";
//        String number2 = "0021473700594524297017810575200827941459805716642468749607585313713214621412";
        //129281419508942330644788914772375911909165364374172850648846234013189757981044692486872392891670352883617068289942863624
        //12928141950894233064478891477237591190916536437417285064884623401318975798104469248687239289167035288361706828994286362

        String number1 = "08820630429040561575390435750496374086954522352294";
        String number2 = "000697826988569335421188593345882896718338487540954558211321155541041788833007";

        long start = System.nanoTime();
        //call function here.....
        System.out.println(multiply(number1, number2));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
        System.out.println(multiplyBESTSOLUTION(number1, number2));
         end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }

    public static String multiply(String a, String b) {

        // since assumed that a will not be longer than b
        if (b.length() < a.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        if (a.equals("0") || b.equals("0")) return "0";
        if (a.equals("1")) return b;


        int sizeA = a.length(), sizeB = b.length(), Alast = 0, Blast = 0, Afirst = sizeA - 1, Bfirst = sizeB - 1;

        String product = "";
        int temp = 0, carryover = 0, AIndex = 0, BIndex = 0;
        for (int i = 0; i < sizeA + sizeB; i++) {
            temp = 0;
            if (i <= Afirst) {
                AIndex = Afirst - i;
                for (int j = Bfirst; j >= Bfirst - i && AIndex <= Afirst; j--) {
                    temp = temp + Character.getNumericValue(a.charAt(AIndex)) * Character.getNumericValue(b.charAt(j));
                    AIndex++;
                }
                temp = temp + carryover;
                carryover = temp / 10;
                temp = temp % 10;
                product = String.valueOf(Character.forDigit(temp, 10)) + product;
            } else {

                BIndex = Bfirst + Afirst - i;
                for (int j = Alast; j <= Math.min(Afirst, Afirst + Bfirst - i) && BIndex >= 0; j++) {
                    temp = temp + Character.getNumericValue(a.charAt(j)) * Character.getNumericValue(b.charAt(BIndex--));
                }
                temp = temp + carryover;
                if (temp == 0 && i == sizeA + sizeB - 1) continue;
                carryover = temp / 10;
                temp = temp % 10;
                product = String.valueOf(Character.forDigit(temp, 10)) + product;
            }

        }
        for (int i = 0; product.length() > 1 && product.charAt(i) == '0'; ) {
            product = product.substring(1);
        }
        return product;
    }

/*
* Would it be easier if you reversed the number for multiplication to calculate the reverse of the answer and then reverse it back to get the actual answer?

It is mostly simulation of the multiplication process where we take one number digit by digit and keep multiplying the digit with the other number and maintaining the sum in another array.
* */
    public static String multiplyBESTSOLUTION(String num1, String num2) {
        if(num1.length()==0||num2.length()==0) return "";
        if(num1.equals("0")||num2.equals("0")) return "0";
        char[] c1=new StringBuilder(num1).reverse().toString().toCharArray();
        char[] c2=new StringBuilder(num2).reverse().toString().toCharArray();
        char[] c=new char[c1.length+c2.length+1];
        Arrays.fill(c,'0');
        for(int i=0;i<c2.length;i++){
            int dig2=c2[i]-'0';
            int carry=0;
            for(int j=0;j<c1.length;j++){
                int dig1=c1[j]-'0';
                int temp=c[i+j]-'0';
                int cur=dig1*dig2+temp+carry;
                c[i+j]=(char) (cur%10+'0');
                carry=cur/10;
            }
            c[i+c1.length]=(char) (carry+'0');
        }
        String ret=new StringBuilder(new String(c)).reverse().toString();
        int pos=0;
        while(ret.charAt(pos)=='0'&&pos<ret.length()) pos++;
        return ret.substring(pos);
    }

}


/*
* MY SOLUTION APPROACH
*
* Let A & B be the two strings, such that len(A) <= len(B)
*
* A = { a0 , a1, a2 }           // numbers represent the index of elements in the string as well
* B = { b0 , b1 , b2 , b3 }
*
* "A-First" is the index of the first element according to multiplication i.e 'ones place' = 2
* "A-Last" is the index of the first element according to multiplication i.e 'hundreds place' = 0
*
*  Similarly, B-First = 3 & B-Last = 0
*
* then the "by-hand multiplication" looks like this
*
*
*                              a0      a1      a2
*                      b0      b1      b2      b3
*      ____________________________________________
*                               a0b3    a0b3    a0b3
*                       a0b2    a1b2    a0b2    x
*               a0b1    a1b1    a2b1    x       x
*       a0b0    a1b0    a2b0    x       x       x
*       ___________________________________________
*
* T-1   T0      T1      T2      T3      T4      T5
*
* 6     5       4       3       2       1       0              // loop iterator (i)
*
*   T0 to T5 are the digits in the final answer, with an additional T-1 for the carryover from T5.
*
*   Now, the number of digits in the product will be at max ( digits(A) + digits(B) )
*           ==> 3 + 4 = 7. Hence we have T-1 to T5 ( 7 digits)
*
*
*
* */