package com.kanav.oopBasics.OOPQuestions.CacheManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/*

5
10 15 20 25 30
1 2 3 4 5
2 4 6 8 10

WRITE abc def
WRITE ghi jkl
READ abc
WRITE mno pqr
WRITE stu vwx
WRITE yz 123
WRITE 467 897
READ yz
READ stu
WRITE sum kan
STATS
WRITE asd asdas
WRITE asda sfssf
WRITE afajf sdkjfks
STATS
WRITE sfs uferf
WRITE sfu sfrsfs
WRITE aea rfr
STATS
READ abc
READ sfu
WRITE ghi jkl
WRITE tgeuw edhwse
READ sfu
READ xxxxx
STATS
exit


*/

public class CacheManager {

    private static int noOfReadOperations = 0;
    private static int noOfWriteOperations = 0;
    private static int readTime;
    private static int writeTime;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int noOfcacheLevels = sc .nextInt();
        CacheLevel headCache = null,curr_cache = null;
       // Initialising cache
        for (int i = 0; i < noOfcacheLevels ; i++) {
            int cacheSize = sc.nextInt();
            if ( headCache == null) {
                headCache = new CacheLevel(cacheSize);
                curr_cache = headCache;
            } else {
                curr_cache.setNextLevel( new CacheLevel(cacheSize));
                curr_cache.getNextLevel().setPrevLevel(curr_cache);
                curr_cache = curr_cache.getNextLevel();
            }
        }

        curr_cache = headCache;
        //setting read & write times
        for (int i = 0; i < noOfcacheLevels ; i++) {
            int readTime = sc.nextInt();
            curr_cache.setReadTime(readTime);
            curr_cache = curr_cache.getNextLevel();
        }
        curr_cache = headCache;
        for (int i = 0; i < noOfcacheLevels ; i++) {
            int writeTime = sc.nextInt();
            curr_cache.setWriteTime(writeTime);
            curr_cache = curr_cache.getNextLevel();
        }


        String operation = sc.next();
        while (  !operation.matches("") ){
            if ( operation.matches("READ")) read(headCache,sc.next());
            else if ( operation.matches("WRITE")) write(headCache,sc.next(),sc.next());
            else if ( operation.matches("STATS")) stats(headCache);
            else if ( operation.matches("exit")) break;
            else System.out.println("INVALID INPUT");
            operation = sc.next();
        }

        sc.close();



    }

    private static void stats(CacheLevel headCache) {
        CacheLevel currCache = headCache;
        System.out.println("Usage : ");
        while (currCache!=null) {
            System.out.print(currCache.getMemoryStatus() + "/" + currCache.getCapacity() + ", ");
            currCache = currCache.getNextLevel();
        }
        System.out.println();
        System.out.println("Average Read Time : " + (readTime/(double)noOfReadOperations));
        System.out.println("Average Write Time : " + (writeTime/(double)noOfWriteOperations));
    }

    private static void write(CacheLevel headCache, String key, String value) {

        CacheLevel currCache = headCache;
        int writeTimeTaken =0;

        while (currCache!=null){
            if (currCache.write(key, value)) writeTimeTaken += currCache.getWriteTime() + currCache.getReadTime() ;
            else writeTimeTaken += currCache.getReadTime();
            currCache = currCache.getNextLevel();
        }

        noOfWriteOperations++;
        writeTime += writeTimeTaken;
        System.out.println("Write Time : " + writeTimeTaken);


    }

    public static void read( CacheLevel headCache, String searchKey){

        CacheLevel currCache = headCache;
        String searchResult = null;
        int readTimeTaken=0;

        // find key iteratively till found
        while (currCache!=null && searchResult==null ) {
            searchResult = currCache.read(searchKey);
            readTimeTaken += currCache.getReadTime();
            if ( searchResult==null ) currCache = currCache.getNextLevel();
        }

        while (currCache!=null && currCache.getPrevLevel()!=null){
            currCache.getPrevLevel().write(searchKey,searchResult);
            readTimeTaken += currCache.getPrevLevel().getWriteTime();
            currCache = currCache.getPrevLevel();
        }

        if ( searchResult!=null )System.out.println("Value at "+ searchKey + " is " + searchResult);
        else System.out.println("Value at "+ searchKey + " NOT FOUND");
        noOfReadOperations++;
        readTime += readTimeTaken;
        System.out.println("Read Time : " + readTimeTaken);


    }
}
