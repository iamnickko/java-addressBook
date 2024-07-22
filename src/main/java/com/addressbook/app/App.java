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
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        UserInput.start(scanner, addressBook);
    }
}



