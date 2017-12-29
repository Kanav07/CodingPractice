package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* QUESTION

Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.

*/

/*  

Input : 4 zebra dog duck dove
Expected : [z, dog, du, dov]
My Code : 

Input : 2 bearcat bert
Expected :
My Code : 

*/

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            inputList.add(sc.next());
        }

        long start = System.nanoTime();
        //call function here.....
        System.out.println(prefix(inputList));
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

//    public class Trie {
//
//        public boolean EndofWord ;
//        public HashMap<Character,Questions.Trie> children;
//
//        public Trie() {
//            this.EndofWord = false;
//            this.children = new HashMap<Character, Questions.Trie>();
//        }
//    }

    public static ArrayList<String> prefix(ArrayList<String> A) {


        ArrayList<String> result = new ArrayList<String>();
        if (A.size()==0) return result;
        Trie root = new Trie();
        populateTrie(root,A);
        Trie temp;

        for (int i = 0; i < A.size(); i++) {
            String word = A.get(i);
            temp = root;
            int index = 0;
            //traverse the trie for each word until you find a Trienode whose children's size is less than 1. -- FAILS when A : [ "bearcat", "bert" ]
            //traverse each word till end of word - mark the last Trienode where the no. of children were > 1. Add substring to result
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if ( temp.children.containsKey(c) && temp.children.get(c).children.size() <= 1 ){
                    temp = temp.children.get(c);
                } else {
                    index = j+1;
                    temp = temp.children.get(c);
                }
            }
            result.add(word.substring(0,index+1));
        }
        return result;
    }

    private static void populateTrie(Trie root, ArrayList<String> strings) {
        Trie temp;
        for (int i = 0; i < strings.size(); i++) {
            temp= root;
            String word = strings.get(i);
            for (int j = 0; j < word.length() ; j++) {
                char c = word.charAt(j);
                if( !temp.children.containsKey(c)) temp.children.put(c,new Trie());
                temp = temp.children.get(c);
            }
            temp.EndofWord= true;
        }
    }
}

/* SOLUTION APPROACH

*/