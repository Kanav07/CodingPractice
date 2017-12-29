package Questions;

import java.util.HashMap;

public class Trie {

    public boolean EndofWord ;
    public HashMap<Character,Trie> children;

    public Trie() {
        this.EndofWord = false;
        this.children = new HashMap<Character, Trie>();
    }
}
