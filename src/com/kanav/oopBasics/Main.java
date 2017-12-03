package com.kanav.oopBasics;

import javax.swing.*;
import java.io.Console;
import java.util.Scanner;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Main {

    public static void main(String[] args) {
	// write your code here
/*        for (int i = 0; i < 5; i++) {
            if ( i%2!=0) System.out.print(" ");
            System.out.println("* * * * *");
        }
        long  big = 12346789999L;
        float average =  55.66f;*/
/*
        System.out.println(big + " " + average);
        System.out.println("Use \\\" to place\n a \" within\ta\tstring");
        System.out.println("          \'__\'\n          (oo)\n  +========\\/\n / || %%% ||\n / || %%% ||\n*  ||-----||\n   \"\"     \"\"\"");
*/
        /*// Range of int is [-2147483648, 2147483647]
        int i1 = 2147483647;  // maximum int
        System.out.println(i1 + 1);   // -2147483648 (overflow!)
        System.out.println(i1 + 2);   // -2147483647
        System.out.println(i1 * i1);  // 1

        int i2 = -2147483648;  // minimum int
        System.out.println(i2 - 1);   // 2147483647 (overflow!)
        System.out.println(i2 - 2);   // 2147483646
        System.out.println(i2 * i2);  // 0

        String str = "Java is cool!";
        System.out.println(str.split(str));*/

/*        for (int i = 0; i < 10 ; i++) {
            if( i<1) System.out.print("* | ");
            else System.out.print(i + " | ");
            for (int j = 1; j < 10; j++) {
                if (i < 1) System.out.printf( "%2d ",j);
                else System.out.printf("%2d ",j*i);
            }
            System.out.println("");
            if(i==0) System.out.println("-------------------------------");
        }*/

/*        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(i==0 || j==0 || i==6 || j== 6 || i==j || i + j ==6 ) System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println("");
        }*/
        /*System.out.printf("Hello%2d and %6s%n", 8, "HI!!!%n");
        System.out.printf("Hi,%s%4d%n", "Hello", 88);
*/
    /*   Scanner in = new Scanner(System.in);
        System.out.print("Enter a string (with space): ");
        // Use nextLine() to read entire line including white spaces,
        //   but excluding the terminating newline.
        int str  = in.nextInt();
        System.out.printf("%d%n", str);
        in.close();*/

        /*int age;
        age = Integer.parseInt(JOptionPane.showInputDialog("Enter the age    "));
        System.out.println(age);
        String a;
        a = "22";   
        System.out.println();*/

        /*Console con = System.console();
       String inLine = con.readLine();
        String msg = con.readLine("Enter your message: ");        // readLine() with prompting message
        msg = con.readLine("%s, enter message: ", "Kanav");
        System.out.println(msg + " " );*/
/*
        Console con = System.console();   // Retrieve the Console object
        // Console class does not work in Eclipse/NetBeans
        if (con == null) {
            System.err.println("Console Object is not available.");
            System.exit(1);
        }

        // Read a line with a prompting message
        String name = con.readLine("Enter your Name: ");
        con.printf("Hello %s%n", name);
        // Use the console with Scanner for parsing primitives
        Scanner in = new Scanner(con.reader());
        con.printf("Enter an integer: ");
        int anInt = in.nextInt();
        con.printf("The integer entered is %d%n", anInt);
        con.printf("Enter a floating point number: ");
        double aDouble = in.nextDouble();
        con.printf("The floating point number entered is %f%n", aDouble);
        in.close();*/

/*

        int[] marks = {10,13, 16, 19};
        int av=0;
        for (int i = 0; i < marks.length; i++) {
            av+=marks[i];
        }
        System.out.println("The average is : " + (av/4.0));
*/


 /*       Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = in.nextInt();
        int[] grades = new int[students];
        int temp,average = 0;
        for (int i = 0; i < students; i++) {
            System.out.print("Enter the grade for student "+ (i+1) +": ");
            temp = in.nextInt();
            while(temp > 100 || temp < 0 ) {
                System.out.println("Invalid grade, try again...");
                System.out.print("Enter the grade for student "+ (i+1) +": ");
                temp = in.nextInt();
            }
            grades[i] = temp;
            average += grades[i];
        }
        System.out.println("The average is: " +  (average/(double)students));*/

      /*  Scanner in = new Scanner(System.in);
        System.out.print(" Enter a binary number : ");
        String binary = in.nextLine();
        while (isValidBinary(binary)== false){
            System.out.println("You have entered an invalid binary string. Retry!!");
            System.out.print(" Enter a binary number : ");
            binary = in.nextLine();
        }
        System.out.println("The Decimal nmber is : " + BinToDec(binary));
*/


      /*int n = 0xa0;

      System.out.println(n + " " + (n<<2));
      int x = 100;
      System.out.println(x + "   " + (x>>3));*/

      /*int a,b,temp;
      Scanner in = new Scanner(System.in);
      a= in.nextInt();
      b = in.nextInt();
      if( b > a) {
          temp = a;
          a = b;
          b = temp;
      }
      while(b!=0){
          System.out.println(a + " " + b);
          temp = a%b;
          a =b;
          b = temp;

      }
        System.out.println(" THe GCD is : " +  a);*/

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the upper bound : " );
        Integer upperBound = in.nextInt();
        int[] perfect = new int[upperBound/10];
        int[] normal = new int [upperBound];
        int perfectIndex =0, normalIndex=1,countPerfect=0, countNormal =0;
        for (int i = 2; i <= upperBound ; i++) {
            if( isPerfect(i)) {
                perfect[perfectIndex++] = i;
                countPerfect++;
            }
            else if ( !isDeficient(i)){
                normal[normalIndex++]= i;
                countNormal++;
            }
        }
        System.out.println("These numbers are perfect: ");
        for (int i = 0; i < countPerfect; i++) {
            System.out.print(perfect[i] + " ");
        }
        System.out.println();
        System.out.println("[" + countPerfect + " perfect numbers found (" + (countPerfect*100/(double)upperBound) + "% )]");

        System.out.println();
        System.out.println("These numbers are neither deficient nor perfect: ");
        for (int i = 1; i < countNormal; i++) {
            System.out.printf("%3d ",normal[i] );
            if( i % 20 ==0 && i > 0) System.out.println();
        }
        System.out.println();
        System.out.println("[" + countNormal + "  numbers found (" + (countNormal*100/(double)upperBound )+ "% )]");

    }

    public static boolean isPerfect ( Integer input){
        int sum = 1;
        for (int i = 2; i <= input/2; i++) {
            if( input%i==0) sum+=i;
        }
        if(sum == input) return  true;
        else return false;
    }

    public static boolean isDeficient ( Integer input){
        int sum = 0;
        for (int i = 1; i <= input/2; i++) {
            if( input%i==0) sum+=i;
        }
        if(sum < input) return  true;
        else return false;
    }

 /*   public static boolean isValidBinary ( String input){
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)!= '0' && input.charAt(i)!= '1' && input.charAt(i)!= ' ') return false;
        }
        return true;
    }
    public static int BinToDec ( String input){
        int binStrLen = input.length();  // The length of binStr
        int dec = 0;  // Equivalent decimal number, accumulating from 0

        // We need to process from the right (i.e. Least-significant bit)
        for (int charPos = binStrLen - 1, exp = 0; charPos >= 0; --charPos) {
            char binChar = input.charAt(charPos);
            // 3 cases: '1' (add to dec, ++exp), '0' (++exp), ' ' (do nothing)
            if (binChar == '1') {
                dec += (int)Math.pow(2, exp);
                ++exp;
            } else if (binChar == '0') {
                ++exp;
            } // else for ' ' (do nothing)
        }
        return dec;
    }*/
}
