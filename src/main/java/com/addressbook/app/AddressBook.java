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
        Validate.validateContact(contact);
//        if (contact == null) throw new IllegalArgumentException("Contact cannot be null.");
        if (this.contacts.contains(contact))
            throw new IllegalArgumentException("Can't add an already existing contact.");
        this.contacts.add(contact);
    }

    public void removeContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
            }
        }
    }

    public void viewContacts() {
        if (getContacts().isEmpty()) {
            System.out.println("There are no contacts to view.");
        } else {
            for (Contact contact : getContacts()) {
                System.out.println(contact);
            }
        }
    }

    public void editContact(String name, String newName, String newEmail, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setName(newName);
                contact.setEmail(newEmail);
                contact.setPhoneNumber(newPhoneNumber);
            }
        }           // need to figure out how to throw exception properly.
    }
}
