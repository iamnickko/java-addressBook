package com.addressbook.app;

public class App {
    public static void main(String[] args) {
        Contact contact = new Contact("", "", "");
        System.out.println("Contact name: " + contact.getName());
        System.out.println("Contact email: " + contact.getEmail());
        System.out.println("Contact phoneNumber: " + contact.getPhoneNumber());
    }
}
