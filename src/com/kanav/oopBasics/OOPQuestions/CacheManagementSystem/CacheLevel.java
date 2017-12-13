package com.kanav.oopBasics.OOPQuestions.CacheManagementSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CacheLevel implements Cachable {

    private HashMap<String, String> data;
    private Queue<String> entryKeeper;
    private int capacity;
    private int readTime;
    private int writeTime;
    private CacheLevel nextLevel;
    private CacheLevel prevLevel;


    public CacheLevel(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<String, String>(this.capacity);
        this.entryKeeper = new LinkedList<String>();
        this.readTime = -1;
        this.writeTime = -1;
        this.nextLevel = null;
        this.prevLevel = null;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMemoryStatus(){
        return this.data.size();
    }

    public int getReadTime() {
        return readTime;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    public int getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(int writeTime) {
        this.writeTime = writeTime;
    }

    public CacheLevel getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(CacheLevel nextLevel) {
        this.nextLevel = nextLevel;
    }

    public CacheLevel getPrevLevel() {
        return prevLevel;
    }

    public void setPrevLevel(CacheLevel prevLevel) {
        this.prevLevel = prevLevel;
    }

    @Override
    public String read(String key) {
        if (this.data.isEmpty()) return null;
        else if (this.data.containsKey(key)) return this.data.get(key);
        else return null;
    }

    @Override
    public boolean write(String key, String value) {
    //return true if entry made in cache, return false if already present
        // if cache is full, purge old data

        //purge oldest data
        if (this.data.size() == this.capacity) {
            String firstKey = entryKeeper.peek();
            this.data.remove(firstKey);
            entryKeeper.remove();

        }

       // write
        if (!this.data.containsKey(key)) {
            this.data.put(key, value);
            entryKeeper.add(key);
            return true;
        } else return false;


    }
}
