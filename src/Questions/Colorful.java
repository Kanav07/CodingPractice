package Questions;

import java.util.*;

/* QUESTION

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245 & the number itself.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.


Output : 1

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class Colorful {
    public static void main(String[] args) {
//Scanner sc = new Scanner(System.in);
//        int inputListSize = sc.nextInt();
//
//        ArrayList<Integer> inputList = new ArrayList<Integer>();
//        for (int i = 0; i < inputListSize; i++) {
//            int inputNumber = sc.nextInt();
//            inputList.add(inputNumber);
//        }

        int input = 12;
        long start = System.nanoTime();
        //call function here.....
        System.out.println(colorful(input));

        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    public static int colorful(int a) {

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int temp = a;
        while (temp > 0) {
            digits.add(0, temp % 10);
            temp = temp / 10;
        }
        if ( digits.size() < 2 ) return 1;
        for (int chop = 1; chop <= digits.size() ; chop++) {

            for (int i = 0; i + chop <= digits.size(); i++) {
                int product = 1, num = 0;
                for (int j = i; j < i + chop; j++) {
                    product *= digits.get(j);
                    num = num*10 + digits.get(j);
                }
                if ( !map.containsKey(product)) map.put(product,num);
                else return 0;
            }
        }
        return 1;
    }

    public static void getSubs(StringBuilder input, ArrayList<Integer> output, int index, StringBuilder temp){

        for (int i = index; i < input.length() ; i++) {
            temp.append(input.charAt(i));
            getSubs(input,output,i+1,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if ( temp.length() > 0) {
            int num = Integer.parseInt(temp.toString());
            output.add(num);
            return;
        }

    }
    public static int colorfulFAIL2 ( int a){

        StringBuilder input = new StringBuilder(String.valueOf(a));
        if ( input.length() < 2 ) return 1;
        ArrayList<Integer> Subs = new ArrayList<Integer>();
        getSubs(input,Subs,0,new StringBuilder());

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (Integer x :Subs) {
            int product=1;
            int num = x;
            while (x > 0) {
                product *= x%10;
                x = x/10;
            }
            if ( !map.containsKey(product) ) map.put(product,num);
            else return 0;
        }

        return 1;

    }

    public static int colorfulFAIL(int number){
        if(number < 10) return 1;

        String colorString = String.valueOf(number);
        int length = colorString.length();

        List<Integer> colorMap = new ArrayList<Integer>();

        for(int i =  1; i < length; i++){
            for (int j = 0;  j+i <= length; j++){
                String sub = colorString.substring(j, j+i);
                int product = getProduct(Integer.parseInt(sub));
                if(colorMap.contains(product)) return 0;
                else{
                    colorMap.add(product);
                }
            }
        }
        return 1;
    }

    private static int getProduct(int digits) {
        if(digits < 10) return digits;
        int num = digits;
        int product = 1;
        while(num > 0){
            product = product * (num % 10);
            num = num / 10;
        }
        return product;
    }


    static int isColorful(int number){

        Set<Integer> s = new HashSet<Integer>();
        String num = number+"";
        int[] digits = new int[num.length()];
        for(int i=0;i<num.length();i++){
            digits[i]=Integer.parseInt(num.charAt(i)+"");
            s.add(digits[i]);
        }

        for(int i=2;i<num.length();i++){
            for(int j=0;j<digits.length-i+1;j++){
                int tempi=i;
                int tempj=j;
                int product=1;
                while(tempi >=0){
                    product*=digits[tempj++];
                    tempi--;
                }
                if(s.add(product)==false){
                    return 1;
                }
            }
        }


        return 0;
    }
}

/* SOLUTION APPROACH

*/