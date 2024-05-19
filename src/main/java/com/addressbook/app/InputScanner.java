package com.addressbook.app;

import java.util.ArrayList;

public class InputScanner {

    public static ArrayList<Contact> searchList(ArrayList<Contact> Contacts, String searchQuery) {
    String lowerCaseSearchQuery = searchQuery.toLowerCase();
    ArrayList<Contact> resultsList = new ArrayList<>();

    for (Contact contact : Contacts) {
        if (contact.getName().toLowerCase().contains(lowerCaseSearchQuery)) {
            resultsList.add(contact);
        }
    }
    return resultsList;
    }
}
