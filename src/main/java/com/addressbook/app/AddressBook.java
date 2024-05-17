package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Object Contact) {
        this.contacts.add((com.addressbook.app.Contact) Contact);
    }
}
