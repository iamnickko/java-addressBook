package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private final ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Object Contact) {
        this.contacts.add((com.addressbook.app.Contact) Contact);
    }

    public void removeContact(Object Contact) {
        this.contacts.remove((com.addressbook.app.Contact) Contact);
    }
}
