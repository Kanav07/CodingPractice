package com.kanav.oopBasics.BasicsPractice;

public class Teacher extends  Person {
    private int numCourses;
    private String[] courses;
    private final int MAX_COURSES = 20;

    public Teacher(String name, String address) {
        super(name, address);
        this.numCourses=0;
        this.courses = new String[MAX_COURSES];

    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public boolean addCourse ( String courseName){
        if(numCourses!=0){
            for (int i = 0; i < numCourses ; i++) {
                if( this.courses[i].equals(courseName)) return  false;
            }
        }
        courses[numCourses] = courseName;
        numCourses++;
        return  true;
    }

    // Return false if the course cannot be found in the course list
    public boolean removeCourse(String course) {
        boolean found = false;
        // Look for the course index
        int courseIndex = -1;  // need to initialize
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            // Remove the course and re-arrange for courses array
            for (int i = courseIndex; i < numCourses-1; i++) {
                courses[i] = courses[i+1];
            }
            numCourses--;
            return true;
        } else {
            return false;
        }
    }

}
