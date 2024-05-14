package com.addressbook.app;

public class App {
    public static void main(String[] args) {
        Contact contact = new Contact("Nick Ko", "nicholas@gmail.com", "07401942331");
        System.out.println("Contact name: " + contact.getName());
        System.out.println("Contact email: " + contact.getEmail());
        System.out.println("Contact phoneNumber: " + contact.getPhoneNumber());
        contact.setName("TIMMMAYYY");
        contact.setEmail("Timmyboobap@gmail.com");
        contact.setPhoneNumber("0754896522");
        System.out.println("Contact name: " + contact.getName());
        System.out.println("Contact email: " + contact.getEmail());
        System.out.println("Contact phoneNumber: " + contact.getPhoneNumber());
    }
}
