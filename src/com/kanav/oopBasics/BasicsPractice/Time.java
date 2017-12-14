package com.kanav.oopBasics.BasicsPractice;

/*
 * The Time class models a time instance with second, minute and hour.
 * This class performs input validations using exception handling.
 */
public class Time {
    // The private instance variables - with input validation
    private int second;  // [0, 59]
    private int minute;  // [0, 59]
    private int hour;    // [0, 23]

    // Input validations are done in setters.
    // All the other methods (such as constructors and setTime()) invoke
    //   these setters to perform input validation to avoid code duplication.
    public void setSecond(int second) {
        if (second >=0 && second <= 59) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid second!");
        }
    }
    public void setMinute(int minute) {
        if (minute >=0 && minute <= 59) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Invalid minute!");
        }
    }
    public void setHour(int hour) {
        if (hour >=0 && hour <= 23) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Invalid hour!");
        }
    }

    // Set second, minute and hour
    public void setTime(int second, int minute, int hour) {
        // Invoke setters to do input valiation
        this.setSecond(second);
        this.setMinute(minute);
        this.setHour(hour);
    }

    // The constructors (overloaded)
    public Time(int second, int minute, int hour) {
        // Invoke setters to do input valiation
        this.setTime(second, minute, hour);
    }
    public Time() {  // The default constructor
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
    }

    // Getters
    public int getSecond() {
        return this.second;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getHour() {
        return this.hour;
    }

    // Return "hh:mm:ss" with leading zeros.
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Increment this instance by one second, return this instance
    public Time nextSecond() {
        ++second;
        if (second == 60) {
            second = 0;
            ++minute;
            if (minute == 60) {
                minute = 0;
                ++hour;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
        return this;   // Return this instance, to support chaining
    }
}