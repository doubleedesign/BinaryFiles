package com.leesaw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Method to write the data to the file
     * @param file: The name of the file to write to
     * @param list: The list of students to write to the file
     */
    public static void writeData(String file, ArrayList<Student> list) {
        FileOutputStream fileOutput = null;
        DataOutputStream dataOutput = null;

        try {
            fileOutput = new FileOutputStream(file, true);
            dataOutput = new DataOutputStream(fileOutput);

            // Loop through the students in our list and write each attribute value to the file
            for(Student student : list) {
                dataOutput.writeInt(student.getId());
                dataOutput.writeUTF(student.getFirst());
                dataOutput.writeUTF(student.getLast());
                dataOutput.writeUTF(student.getCourse());
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Data file not found");
        }
        catch (IOException e) {
            System.err.println("Problem with the output data stream");
        }
        finally {
            try {
                // Close the data stream
                if(dataOutput != null) {
                    dataOutput.close();
                }
            } catch (IOException e) {
                System.err.println("Problem closing the output data stream");
            }
        }
    }


    /**
     * Method to get
     * @param file: The file to read from
     * @return ArrayList: List of students in the file
     */
    public static ArrayList<Student> getData(String file) {
        FileInputStream fileInput = null;
        DataInputStream dataInput = null;

        // Create a new ArrayList to assign our data to
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            // Initialise student data variables
            int id;
            String first;
            String last;
            String course;

            // Create our file stream
            fileInput = new FileInputStream(file);
            dataInput = new DataInputStream(fileInput);

            // Grab data out and add it to our list
            while(dataInput.available() > 0) {

                // Get data and assign it to the variables
                id = dataInput.readInt();
                first = dataInput.readUTF();
                last = dataInput.readUTF();
                course = dataInput.readUTF();

                // Create a student object and add it to the list
                Student thisStudent = new Student(id, first, last, course);
                list.add(thisStudent);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        catch (IOException e) {
           System.err.println("Problem with the data stream");
        }
        finally {
            try {
                // Close the data stream
                if(dataInput != null) {
                    dataInput.close();
                }
            }
            catch (IOException e) {
                System.err.println("Problem opening the output data stream");
            }
        }

        // Return our populated list
        return list;
    }
}
