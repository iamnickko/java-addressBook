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
                return userInput;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid selection:");
            }
        }
    }

    public static String captureInput(String prompt, Scanner scanner) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        Validate.validateUserInput(input);
        return input;
    }

    public static void start(Scanner scanner, AddressBook addressBook) {

        boolean applicationOn = true;

        while (applicationOn) {
            MenuPrinter.displayMenu();
            String userSelection = UserInput.captureMenuInput(scanner);

            switch (userSelection) {
                case "1":
                    MenuPrinter.menuHeader("CONTACT LIST");
                    addressBook.viewContacts();
                    break;
                case "2":
                    MenuPrinter.menuHeader("ADD A NEW CONTACT");
                    try {
                        String nameInput = UserInput.captureInput("Enter contact's full name:", scanner);
                        String emailInput = UserInput.captureInput("Enter contact's email address:", scanner);
                        String phoneInput = UserInput.captureInput("Enter contact's phone number (11 digit mobile - e.g. 07XXXXXXXXX):", scanner);
                        addressBook.addContact(new Contact(nameInput, emailInput, phoneInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    MenuPrinter.menuHeader("SEARCH CONTACTS");
                    try {
                        System.out.println("Enter a name to search for:");
                        String searchInput = scanner.nextLine();
                        System.out.println(UserInput.searchList(addressBook.getContacts(), searchInput));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    MenuPrinter.menuHeader("EDIT CONTACT");
                    try {
                        String nameInput = UserInput.captureInput("Which contact would you like to edit? Enter their full name:", scanner);
                        String newNameInput = UserInput.captureInput("Enter contact's new Name:", scanner);
                        String newEmailInput = UserInput.captureInput("Enter contact's new Email:", scanner);
                        String newPhoneNumberInput = UserInput.captureInput("Enter contact's new PhoneNumber (11 digit mobile - e.g. 07XXXXXXXXX):", scanner);
                        addressBook.editContact(nameInput, newNameInput, newEmailInput, newPhoneNumberInput);
                        System.out.printf("Successfully edited contact's details to: %s, %s, %s %n", newNameInput, newEmailInput, newPhoneNumberInput);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "5":
                    MenuPrinter.menuHeader("REMOVE CONTACT");
                    try {
                        String toRemoveInput = UserInput.captureInput("Which contact would you like to remove? Enter their full name:", scanner);
                        addressBook.removeContact(toRemoveInput);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "6":
                    System.out.println("Closing the address book, until next time!");
                    scanner.close();
                    applicationOn = false;
            }
        }

    }
}

