package Questions;


/*
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.
*/

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {

        String input = "/a/./b/../../c/";
//        String input = "/home/";
//        String input = "/home//foo/";

        long start = System.nanoTime();
        //call function here.....
        System.out.println(simplifyPath(input));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }


    public static String simplifyPath(String A) {

        String[] directory = A.split("/");
        Stack<String> pathStack = new Stack<String>();
        StringBuilder path = new StringBuilder();
        //path.append("/");
        for (int i = 0; i < directory.length ; i++) {

            if ( directory[i].matches("[A-z]+")) {
                pathStack.push(directory[i]);
            }  else if ( directory[i].equals("..") && !pathStack.empty()) pathStack.pop();
            else if ( directory[i].equals(".")) continue;

        }
        if ( pathStack.empty()) path.insert(0,"/");
        while (!pathStack.empty()) {
            path.insert(0,pathStack.pop());
             path.insert(0,"/");
        }
        return path.toString();
    }
}
