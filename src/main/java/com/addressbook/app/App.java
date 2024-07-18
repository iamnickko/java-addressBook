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

        while (applicationOn) {
            InputScanner.displayMenu();
            String userSelection = InputScanner.captureMenuInput(scanner);


            switch (userSelection) {
                case "1":
                    InputScanner.menuHeader("CONTACT LIST");
                    addressBook.viewContacts();
                    break;
                case "2":
                    InputScanner.menuHeader("ADD A NEW CONTACT");
                    try {
                        String nameInput = InputScanner.captureInput("Enter contact's full name:", scanner);
                        String emailInput = InputScanner.captureInput("Enter contact's email address:", scanner);
                        String phoneInput = InputScanner.captureInput("Enter contact's phone number:", scanner);
                        addressBook.addContact(new Contact(nameInput, emailInput, phoneInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    InputScanner.menuHeader("SEARCH CONTACTS");
                    try {
                        System.out.println("Enter a name to search for:");
                        String searchInput = scanner.nextLine();
                        System.out.println(InputScanner.searchList(addressBook.getContacts(), searchInput));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    InputScanner.menuHeader("EDIT CONTACT");
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
                    InputScanner.menuHeader("REMOVE CONTACT");
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


