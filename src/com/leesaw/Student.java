package com.leesaw;

public class Student {

    // Attributes
    private int id;
    private String first;
    private String last;
    private String course;

    /**
     * Default constructor
     */
    public Student() {
        this.id = 0;
        this.first = "";
        this.last = "";
        this.course = "";
    }

    /**
     * Constructor with parameters
     * @param id
     * @param first
     * @param last
     * @param course
     */
    public Student(int id, String first, String last, String course) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.course = course;
    }

    /**
     * Getters
     * (Not creating any setters for this exercise because the values are only set when the student is created)
     */
    public int getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getCourse() {
        return course;
    }


    /**
     * ToString method
     * @return String
     */
    @Override
    public String toString() {

        StringBuilder neatString = new StringBuilder();
        neatString.append(id);
        neatString.append(" ");
        neatString.append(first);
        neatString.append(" ");
        neatString.append(last);
        neatString.append(" ");
        neatString.append("studying ").append(course);

        return neatString.toString();
    }
}
