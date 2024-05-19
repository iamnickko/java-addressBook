package com.addressbook.app;

import java.util.Scanner;

/* Hello, Ed! A few things I'd like to highlight that I'd improve on given a bit more time and to show how the direction I'd
    have continued working:
* - Would definitely pull out each case in the switch block and have as its own function in InputScanner. I believe I could
*   then write unit tests and increase the test coverage. Would apply relevant Validate functions to each.
* - I'd pull out the formatting System.out.println("=====") and the menu titles into their own function to reuse.
* - I'd move editContact() from AddressBook into Contact - better single responsibility. Contact for creating & editing,
*   AddressBook for holding, removing, & viewing.
* - Testing suites could be refactored with beforeEach & afterEach. I also struggled with how to make mocks behave how I
*   wanted, particularly with creating a mock AddressBook, so there's a couple of instances of tightly coupling other
*   classes to tests. */


public class App {
    public static void main(String[] args) {
        boolean applicationOn = true;
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your address book.");
        System.out.println("==============");
        while (applicationOn) {
            System.out.println("MENU");
            System.out.println("==============");
            System.out.println("1. View contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search for an existing contact");
            System.out.println("4. Edit an existing contact");
            System.out.println("5. Remove an existing contact.");
            System.out.println("6. Close application.");
            System.out.println("Enter a single digit to make your selection. (1 / 2 / 3 / 4 / 5)");
            String userSelection = scanner.nextLine();
            try {
                Validate.validateUserInputMenu(userSelection);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }


            switch (userSelection) {
                case "1":
                    System.out.println("==============");
                    System.out.println("CONTACT LIST");
                    System.out.println("==============");
                    addressBook.viewContacts();
                    System.out.println("==============");
                    break;
                case "2":
                    System.out.println("==============");
                    System.out.println("ADD A NEW CONTACT");
                    System.out.println("==============");
                    try {
                        System.out.println("Enter contact's full name:");
//                        scanner.nextLine();   // Occasionally, this was needed to stop email running immediately after name. ?!
                        String nameInput = scanner.nextLine();
                        System.out.println("You entered " + nameInput);
                        System.out.println("Enter contact's email address:");
                        String emailInput = scanner.nextLine();
                        System.out.println("You entered " + emailInput);
                        System.out.println("Enter contact's phone number (11 digit mobile - e.g. 07XXXXXXXXX)");
                        String phoneInput = scanner.nextLine();
                        System.out.println("You entered " + phoneInput);
                        addressBook.addContact(new Contact(nameInput, emailInput, phoneInput));
                        System.out.printf("Successfully added Name: %s Email: %s PhoneNumber: %s%n", nameInput, emailInput, phoneInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("==============");
                    System.out.println("SEARCH");
                    System.out.println("==============");
                    try {
                        System.out.println("Enter a name to search for:");
                        String searchInput = scanner.nextLine();
                        System.out.println(InputScanner.searchList(addressBook.getContacts(), searchInput));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("==============");
                    System.out.println("EDIT CONTACT");
                    System.out.println("==============");
                    System.out.println("Which contact would you like to edit? Enter a valid name:");
                    String nameInput = scanner.nextLine();
                    System.out.println("Enter contact's new Name:");
                    String newNameInput = scanner.nextLine();
                    System.out.println("entered: " + newNameInput);
                    System.out.println("Enter contact's new Email:");
                    String newEmailInput = scanner.nextLine();
                    System.out.println("Enter contact's new PhoneNumber:");
                    String newPhoneNumberInput = scanner.nextLine();
                    try {
                        addressBook.editContact(nameInput, newNameInput, newEmailInput, newPhoneNumberInput);
                        System.out.println("Successfully edited contact's details.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "5":
                    System.out.println("==============");
                    System.out.println("REMOVE CONTACT");
                    System.out.println("==============");
                    System.out.println("Which contact would you like to remove? Enter a valid name:");
                    String toRemoveInput = scanner.nextLine();
                    try {
                        addressBook.removeContact(toRemoveInput);
                        System.out.println("Successfully removed contact.");
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


