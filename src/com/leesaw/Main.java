package com.leesaw;

public class Main {

    public static void main(String[] args) {

        // Create and show the menu screen
        Menu theMenu = new Menu();
        int selection = 0;

        // Specify filename
        String filename = "students.bin";

        // Begin the data processing session
        Session session = new Session(filename);

        // Keep returning to the menu until the user exits
        while(selection < 6) {

            // Show menu and ask for selection
            selection = theMenu.getSelection();

            // Pass the selection to the session object
            session.setSelection(selection);

            // Run the selected activity method
            session.beginActivity();
        }
    }
}