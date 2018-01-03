package Questions;


/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.

The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor.

32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
  1 -1 -1 -1 -1 3 12 -1 -1 12 -1 -1 -1 1 6 -1
  1 -1 -1 -1 -1 3 12 5 14 12 -1 3 -1 -1 -1 -1


  7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
  -1 -1 2 -1
    -1 -1 2 6
 Run as custom input


 6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
  */
import algorithmsBasics.ListNode;

import java.util.*;

public class LRUCache {


   private LinkedHashMap<Integer,Integer> map;
   private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if( map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        } else return -1;
    }

    public void set(int key, int value) {
        if( this.map.size() == this.capacity && !map.containsKey(key)){
            int last = (Integer) this.map.keySet().toArray()[0];
            map.remove(last);
        }
        if( map.containsKey(key)) map.remove(key);
        map.put(key,value);
    }



    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int ops = sc.nextInt();
        int cap = sc.nextInt();



        LRUCache cache = new LRUCache(cap);
        for (int i = 0; i < ops; i++) {
             String c = sc.next();
             if ( c.equals("S")){
                 cache.set(sc.nextInt(),sc.nextInt());
             } else if ( c.equals("G")){
                 System.out.print(cache.get(sc.nextInt()) + " ");
             } else System.out.println("invalid");
        }
    }
}
