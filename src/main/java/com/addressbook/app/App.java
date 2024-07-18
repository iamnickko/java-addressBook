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


