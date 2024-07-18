package com.addressbook.app;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    public static ArrayList<Contact> searchList(ArrayList<Contact> Contacts, String searchQuery) {
        String lowerCaseSearchQuery = searchQuery.toLowerCase();
        ArrayList<Contact> resultsList = new ArrayList<>();

        for (Contact contact : Contacts) {
            if (contact.getName().toLowerCase().contains(lowerCaseSearchQuery)) {
                resultsList.add(contact);
            }
        }
        if (resultsList.isEmpty()) {
            throw new RuntimeException("There are no matching results to display");
        }
        return resultsList;
    }



    public static String captureMenuInput(Scanner scanner) {
        String userInput;
        while (true) {
            try {
                userInput = scanner.nextLine();
                Validate.validateUserInputMenu(userInput);
                return userInput; // Return the validated input
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // Print error message and prompt again
                System.out.println("Please enter a valid selection:");
            }
        }
    }

    public static String captureInput(String prompt, Scanner scanner) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        Validate.validateUserInput(input);
        return input; // Return the validated input
    }

    }

