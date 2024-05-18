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

    public void addContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("Contact cannot be null.");
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }
}
