package com.addressbook.app;

import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {

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

    public static void displayMenu() {
        System.out.println("==============");
        System.out.println("MENU");
        System.out.println("==============");
        System.out.println("1. View contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Search for an existing contact");
        System.out.println("4. Edit an existing contact");
        System.out.println("5. Remove an existing contact.");
        System.out.println("6. Close application.");
        System.out.println("Enter a single digit to make your selection. (1 / 2 / 3 / 4 / 5)");
    }

    public static void menuHeader(String heading) {
        System.out.println("==============");
        System.out.println(heading);
        System.out.println("==============");
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

