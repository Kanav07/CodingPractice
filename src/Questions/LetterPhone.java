package Questions;


/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/

/**/

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
    public static void main(String[] args) {

        String input = "12";

        long start = System.nanoTime();
        //call function here.....
        ArrayList<String> ouput = letterCombinations(input);
        long end = System.nanoTime();
        for (String x : ouput) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));


         start = System.nanoTime();
        //call function here.....
         ouput = letterCombinationsOWN(input);
         end = System.nanoTime();
        for (String x : ouput) System.out.print(x + " ");
        System.out.println("\nTime taken : " + (end - start));

    }


    public static ArrayList<String> recHelper(HashMap<Character, String> mp,
                                              String a, int index){

        // if we reached the end of the digit string, return an empty string
        ArrayList<String> ans = new ArrayList<String>();
        if(index == a.length()){
            ans.add("");
            return ans;
        }

        // get the current option for the digit in index
        String curr = mp.get(a.charAt(index));

        // for each of the chars relating to that digit
        for(int i = 0; i < curr.length(); i++){

            // append all possible string from the remaining string
            ArrayList<String> next = recHelper(mp, a, index + 1);
            for(String s : next){
                ans.add(Character.toString(curr.charAt(i)) + s);

            }
        }

        return ans;
    }

    public static ArrayList<String> letterCombinations(String a) {

        // create the mapping
        HashMap<Character, String> mp = new HashMap<Character, String>();
        mp.put('0', "0");
        mp.put('1', "1");
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        return recHelper(mp, a, 0);

    }


    public static ArrayList<String> letterCombinationsOWN(String a){
        String[] keypad = { "0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};


        return getCombinations(a.charAt(0) - '0',keypad,a,0);

    }

    public static ArrayList<String> getCombinations(int key, String[] keypad, String input,int index){

        ArrayList<String> result = new ArrayList<String>();

        char[] curr = keypad[key].toCharArray();

        if ( index == input.length()-1){
            for (char c:curr) result.add("" + c);
            return result;
        }

        for (char prefix : curr) {
            ArrayList<String> suffixes = getCombinations(input.charAt(index + 1)-'0',keypad,input,index+1);
            for (String suffix : suffixes) {
                result.add("" + prefix + suffix);
            }
        }
        return result;
    }

}


