package com.addressbook.app;

public class MenuPrinter {
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
        System.out.println("Enter a single digit to make your selection. (1 / 2 / 3 / 4 / 5 / 6)");
    }

    public static void menuHeader(String heading) {
        System.out.println("==============");
        System.out.println(heading);
        System.out.println("==============");
    }
}
