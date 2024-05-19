package com.addressbook.app;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
    AddressBook addressBook = new AddressBook();
    Contact nick = new Contact("Nick Ko", "nick@gmail.com", "07888888888");
    addressBook.addContact(nick);
    Contact anotherContact = new Contact("Missle Potato", "potato@missile.com", "07887642613");
    addressBook.addContact(anotherContact);
        System.out.println(addressBook.getContacts());
        System.out.println(nick.toString());
        System.out.println(nick.getName().toString());
    }

}
