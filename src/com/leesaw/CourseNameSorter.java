package com.leesaw;

import java.util.Comparator;

public class CourseNameSorter implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getCourse().compareToIgnoreCase(student2.getCourse());
    }
}
