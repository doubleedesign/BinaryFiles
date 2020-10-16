package com.leesaw;

import java.util.Comparator;

public class LastNameSorter implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
       return student1.getLast().compareToIgnoreCase(student2.getLast());
    }
}
