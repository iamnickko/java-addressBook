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
        if (this.contacts.contains(contact)) throw new IllegalArgumentException("Can't add an already existing contact.");
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }

    public String viewContacts() {
        if (getContacts().isEmpty()) {
            return "There are no contacts to view.";
        }
        return "there will be something to show here.";
    }
}
