package Questions;

import java.util.*;

/* QUESTION

*/

/*  

Input : 
Expected :
My Code : 

Input : 
Expected :
My Code : 

*/

public class HotelReviews {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        for (int i = 0; i < inputListSize; i++) {
            int inputNumber = sc.nextInt();
            inputList.add(inputNumber);
        }
        long start = System.nanoTime();
        //call function here.....
        // Solution ( inputList );
        long end = System.nanoTime();
        System.out.println("\nTime taken : " + (end - start));

    }

    class Node{
        int match;
        int index;

        public Node(int m1,int i1){
            match = m1;
            index=i1;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2){
            if(n1.match==n2.match){return n1.index - n2.index;}
            return n2.match-n1.match;
        }
    }

        public ArrayList<Integer> solve(String s, ArrayList<String> arr) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if(arr.size()==0) return ans;

            String[] str = s.split("_");
            HashSet<String> set = new HashSet<String>(Arrays.asList(str));
            int count=0;
            ArrayList<Node> node = new ArrayList<Node>();

            for(int i=0;i<arr.size();i++){
                count=0;
                String[] temp = arr.get(i).split("_");
                for(String s1 : temp){count += set.contains(s1) ? 1 : 0;}
                node.add(new Node(count,i));
                // System.out.println(count);
            }

            Collections.sort(node,new NodeComparator());

            for(Node n : node){
                ans.add(n.index);
            }
            return ans;
        }
    }



/*
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
cool ice wifi

01. Bruteforce
    ---
    For every review search for every good word.
    Time complexity: O(Slen * Rlen)

02. Hashmap
    ---
    Create a hashmap with good words as keys. For every review iterate by words and
    check if word is good by hashmap.
    Solved problem: faster lookups
    Time complexity: O(sWordsNum + rWordsNum)

03. Trie
    ---
    Create a trie from good words. For every review iterate by letters, check by trie
    if word is good. If not, skip to the next word immediately.
    Time complexity: O(sWords + rWordsNum)


*/