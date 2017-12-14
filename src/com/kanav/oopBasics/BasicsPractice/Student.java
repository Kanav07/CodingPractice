package com.kanav.oopBasics.BasicsPractice;

public class Student extends  Person {
    private  int numCourses;
    private String[] courses;
    private  int[] grades;
    private static  final int MAX_COURSES = 20;

    public Student(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES];
        this.grades = new int[MAX_COURSES];
    }


    public String toString(){
        return "Student : " + super.toString();
    }


    public void addCourseGrade(String courseName, int courseGrade){
        this.courses[numCourses] = courseName;
        this.grades[numCourses] = courseGrade;
        numCourses++;
    }

    // Print all courses taken and their grade
    public void printGrades() {
        System.out.print(this);
        for (int i = 0; i < numCourses; ++i) {
            System.out.print(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    // Compute the average grade
    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++ ) {
            sum += grades[i];
        }
        return (double)sum/numCourses;
    }
}
