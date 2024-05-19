package com.addressbook.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean applicationOn = true;
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        Contact nick = new Contact("Nick Ko", "nick@gmail.com", "07888888888");
        addressBook.addContact(nick);
        Contact anotherContact = new Contact("Missile Potato", "potato@missile.com", "07887642613");
        addressBook.addContact(anotherContact);

        while (applicationOn) {

            System.out.println("Welcome to your address book.");
            System.out.println("1 View contacts");
            System.out.println("2 Add new contact");
            System.out.println("3 Search for an existing contact");
            System.out.println("4 Remove an existing contact.");
            System.out.println("5 Close application.");
            System.out.println("Enter a single digit to make your selection. (1 / 2 / 3 / 4 / 5)");
            int userSelection = scanner.nextInt();

            switch (userSelection) {
                case 1:
                    addressBook.viewContacts();
                    break;
                case 2:
                    try {
                        System.out.println("Enter contact's full name:");
                        scanner.nextLine();
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
                case 3:
                    try {
                        System.out.println("Enter a name to search for:");
                        scanner.nextLine();
                        String searchInput = scanner.nextLine();
                        System.out.println(InputScanner.searchList(addressBook.getContacts(),searchInput));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Will remove a contact");
                case 5:
                    System.out.println("Closing the address book, until next time!");
                    scanner.close();
                    applicationOn = false;
            }
        }
    }
}


