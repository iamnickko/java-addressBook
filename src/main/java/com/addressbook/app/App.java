package com.addressbook.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        UserInput.start(scanner, addressBook);
    }
}



