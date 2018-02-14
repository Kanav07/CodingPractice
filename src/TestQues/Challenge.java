package TestQues;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

class Challenge {
    public static void main(String[] args){
        dedup("/Users/apple/IdeaProjects/untitled1/src/TestQues/input","/Users/apple/IdeaProjects/untitled1/src/TestQues/output");
        System.out.println(redup("/Users/apple/IdeaProjects/untitled1/src/TestQues/output","/Users/apple/IdeaProjects/untitled1/src/TestQues/output2"));
    }

    static void dedup(String input_file_path, String output_file_path) {

        // Generating the file input stream as file specified is too long.
        File aFile = new File(input_file_path);
        File oFile = new File(output_file_path);
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        try {
            inFile = new FileInputStream(aFile);
            outFile = new FileOutputStream(oFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }

        int size = aFile.length() %1024 == 0 ?  (int) (aFile.length() / 1024) : (int) (aFile.length() / 1024) + 1 ;
        int[] arrayMap = new int[size];
        byte[] bucket = new byte[1024]; // chunks of data

        HashMap<String, Integer> map = new HashMap<String ,Integer>();
        try {
            int bytesRead = 0, i = 0;
            while (bytesRead != -1) {
                bytesRead = inFile.read(bucket);
                if (bytesRead > 0) {
                    //do the hashing
                    String str = (new BASE64Encoder()).encode(bucket);

                    if (!map.containsKey(str)) {
                        map.put(str, map.size());
                    }
                    arrayMap[i] = map.get(str);
                    i++;
                }
            }
            inFile.close();

            // print the output file
            outFile.write(size);
            for ( i = 0; i < size; i++) {
                outFile.write(arrayMap[i]);
            }
            Iterator itr = map.keySet().iterator();
            while (itr.hasNext()) {

                byte[] by = (new BASE64Decoder()).decodeBuffer((String) itr.next());
                outFile.write( by);
            }
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static boolean redup(String input_file_path, String output_file_path) {

        File aFile = new File(input_file_path);
        File oFile = new File(output_file_path);
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        try {
            inFile = new FileInputStream(aFile);
            outFile = new FileOutputStream(oFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }

        try {
            int size = inFile.read();
            int[] arr_map = new int[size];
            for (int i = 0; i < size; i++) {
                arr_map[i] = inFile.read();
            }
            ArrayList<String> hash = new ArrayList<String>();
            byte[] bucket = new byte[1024]; // chunks of data

            int bytesRead = 0;
            while (bytesRead != -1) {
                bytesRead = inFile.read(bucket);
                if (bytesRead > 0) {
                    String str = (new BASE64Encoder()).encode(bucket);
                    hash.add(str);
                }
            }
            inFile.close();


            for (int i = 0; i < size ; i++) {
                byte[] by = (new BASE64Decoder()).decodeBuffer(hash.get(arr_map[i]));
                outFile.write(by);
            }
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}