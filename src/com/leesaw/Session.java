package com.leesaw;

import javax.swing.*;
import java.util.ArrayList;

public class Session {
    String file;
    int selection;

    // Constructor
    public Session(String filename) {
        this.file = filename;

        ArrayList<Student> existing = getStudents();
        if(!existing.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existing file found. You can display, search, or add to the existing records.");
        }
        else {
            JOptionPane.showMessageDialog(null, "No existing file found. Continue to create one.");
        }
    }


    /**
     * Method to update the selection
     * @param enteredSelection
     */
    public void setSelection(int enteredSelection) {
        selection = enteredSelection;
    }


    /**
     * Method to begin the activity the user has selected
     */
    public void beginActivity() {

        switch (selection) {
            case 1 -> this.inputStudent();
            case 2 -> this.sortStudentsByLastName();
            case 3 -> this.sortStudentsByCourseName();
            case 4 -> this.searchStudentsByID();
            case 5 -> this.searchStudentsByLastName();
            case 6 -> System.exit(0);
        }
    }


    /**
     * Method to add a student to the file
     */
    public void inputStudent() {
        // Create a local array list to store students entered
        ArrayList<Student> enteredStudents = new ArrayList<Student>();

        // Get input from the user
        // By default this will be strings so for the ID we need to ad some handling to make it an integer and handle incorrect input
        // We also need to check that name fields are at least two characters
        int id = 0;
        while(id < 1) {
            String inputID = JOptionPane.showInputDialog("Enter student's ID");
            try {
                id = Integer.parseInt(inputID);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wrong data type. Please ensure student ID is a whole number greater than 0.");
            }
        }

        String first = "";
        int firstLength = 0;
        while (firstLength < 2) {
            String inputFirst = JOptionPane.showInputDialog("Enter student's first name");
            firstLength = inputFirst.length();
            if(firstLength > 1) {
                first = inputFirst;
            }
            else {
                JOptionPane.showMessageDialog(null, "Names must be at least two characters");
            }
        }

        int lastLength = 0;
        String last = "";
        while (lastLength < 2) {
            String inputlast = JOptionPane.showInputDialog("Enter student's last name");
            lastLength = inputlast.length();
            if(lastLength > 1) {
                last = inputlast;
            }
            else {
                JOptionPane.showMessageDialog(null, "Names must be at least two characters");
            }
        }

        // Get the course
        String course = JOptionPane.showInputDialog("Enter name of student's course");

        // Create student and add them to the list
        Student thisStudent = new Student(id, first, last, course);
        enteredStudents.add(thisStudent);

        // Save the data to a file using our FileHandler class
        FileHandler.writeData(file, enteredStudents);

        // Show a message
        JOptionPane.showMessageDialog(null, "Success! Student saved to file");
    }


    /**
     * Utility method to get the students from the file and put them back into array list format so we can do stuff with them
     * @return ArrayList
     */
    public ArrayList<Student> getStudents() {

        return FileHandler.getData(file);
    }


    /**
     * Method to display students from a provided array list
     */
    public void displayList(ArrayList<Student> list) {

        // First handle the list being empty - show message and exit
        if(list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No results");
            return;
        }

        // Create a string for the output
        StringBuilder output = new StringBuilder();
        output.append("Result list:\n\n");

        // Prepare a string of output to display
        for (Student student : list) {
            output.append(student.toString()).append("\n");
        }

        // Display the output
        JOptionPane.showMessageDialog(null, output);
    }


    public void sortStudentsByLastName() {
        ArrayList<Student> students = getStudents();

        // Sort using our LastNameSorter class
        LastNameSorter sorter = new LastNameSorter();
        students.sort(sorter);

        // Display the list
        displayList(students);
    }


    public void sortStudentsByCourseName() {
        ArrayList<Student> students = getStudents();

        // Sort using our CourseNameSorter class
        CourseNameSorter sorter = new CourseNameSorter();
        students.sort(sorter);

        // Display the list
        displayList(students);
    }


    /**
     * Method to sarch students by ID and  display the results
     */
    public void searchStudentsByID() {
        ArrayList<Student> students = getStudents();

        // Array list to store our search results
        ArrayList<Student> searchResults = new ArrayList<Student>();

        int searchID = 0;
        while(searchID < 1) {
            String searchTerm = JOptionPane.showInputDialog("Enter ID to search for");
            try {
                searchID = Integer.parseInt(searchTerm);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wrong data type. Please ensure student ID is a whole number greater than 0.");
            }
        }

        // Loop through students and add matching ones to the list
        for(Student thisStudent : students) {
            if(thisStudent.getId() == searchID) {
                searchResults.add(thisStudent);
            }
        }

        // Display the list
        displayList(searchResults);
    }


    /**
     * Method to search students by last name and display the results
     */
    public void searchStudentsByLastName() {
        ArrayList<Student> students = getStudents();

        // Array list to store our search results
        ArrayList<Student> searchResults = new ArrayList<Student>();

        // Get the search term from the user
        String searchTerm = JOptionPane.showInputDialog("Enter surname to search for");

        // Loop through students and add matching ones to the list
        for(Student thisStudent : students) {
            if(thisStudent.getLast().equals(searchTerm)) {
                searchResults.add(thisStudent);
            }
        }

        // Display the list
        displayList(searchResults);
    }
}
