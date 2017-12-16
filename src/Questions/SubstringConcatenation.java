package Questions;

import java.util.*;

/* QUESTION
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
*/

/*  

Input :
barfoothefoobarman
2 bar foo

Expected :
My Code : 



Input : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
5 aaa aaa aaa aaa aaa
Expected : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98

My Code : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97


Input :
Expected :
My Code :

Input :
Expected :
My Code :


*/

public class SubstringConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String main = sc.next();
        int inputListSize = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            inputList.add(sc.next());
        }

        long start = System.nanoTime();
        //call function here.....
        ArrayList<Integer> output = findSubstring(main,inputList);
        long end = System.nanoTime();
        for (Integer x: output) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

    }

    public static  ArrayList<Integer> findSubstring(String a, final List<String> b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if ( b.size()==0 || a.length()==0) return  result;

        int wordlength = b.get(0).length();
        int noOfwords = b.size();

        HashMap<String ,Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < b.size(); i++) {
            if ( !map.containsKey(b.get(i))) map.put(b.get(i),1);
            else map.put(b.get(i),map.get(b.get(i)) + 1);
        }
        HashMap<String,Integer> mapToCompare;

        ;

        for (int i = 0; i  + wordlength*noOfwords <= a.length() ; i++) {
            boolean skip = false, mismatch = false;
            mapToCompare = (HashMap<String, Integer>) map.clone();
            for (int j = i; j < i + noOfwords*wordlength ; j+= wordlength) {
                String temp = a.substring(j,j + wordlength);
                if ( mapToCompare.containsKey(temp)) mapToCompare.put(temp,mapToCompare.get(temp) -1);
                else {
                    skip = true;
                    break;
                }
            }
            if( !skip ){
                Iterator<Integer> itr = mapToCompare.values().iterator();
                while (itr.hasNext()) {
                    Integer count = itr.next();
                    if ( count > 0  || count < 0) {
                        mismatch = true;
                        break;
                    }
                }
                if (!mismatch ){
                    result.add(i);
                }
            }
        }

        return result;
    }
}

/* SOLUTION APPROACH

*/