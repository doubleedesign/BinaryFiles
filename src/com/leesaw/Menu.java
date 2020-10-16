package com.leesaw;

import javax.swing.*;

public class Menu {

    private StringBuilder instructions = new StringBuilder();


    /**
     * Constructor
     */
    public Menu() {
    }


    /**
     * Get selection of activity from the user
     * @return int: Selection from a list of options
     */
    public int getSelection() {
        int selection = 0;

        // Build the list of instructions
        instructions.append("What would you like to do today?\n\n");
        instructions.append("1. Input student details\n");
        instructions.append("2. Sort and display students by last name\n");
        instructions.append("3. Sort and display students by course name\n");
        instructions.append("4. Search students by ID\n");
        instructions.append("5. Search students by last name\n");
        instructions.append("6. Save and exit\n\n");

        // Validate the selection (keep asking until a valid one is entered)
        while(selection < 1) {
            int enteredSelection =0;

            // Show the user the instructions and get their selection
            String inputString = JOptionPane.showInputDialog(instructions);

            // Make sure it's an integer
            try {
                enteredSelection = Integer.parseInt(inputString);

                // Make sure it's in the required range
                if(enteredSelection < 1 || enteredSelection > 6) {
                    throw new IndexOutOfBoundsException();
                }
                else {
                    selection = enteredSelection;
                }
            }
            catch (NumberFormatException | IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Please enter a whole number between 1 and 6.");
            }
        }

        // Clear the instructions so they don't keep appending every time
        instructions = new StringBuilder();

        // Return the validated selection
        return selection;
    }
}
