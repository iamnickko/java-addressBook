package com.addressbook.app;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String name, String email, String phoneNumber) {
        if (!Validate.validateName(name)) throw new IllegalArgumentException("Name must include first and last name.");

        if (!Validate.validateEmail(email)) throw new IllegalArgumentException("Email must match a valid format.");

        if (!Validate.validatePhoneNumber(phoneNumber))
            throw new IllegalArgumentException("Phone number must match a valid format.");

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validate.validateName(name)) throw new IllegalArgumentException("Name must include first and last name.");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Validate.validateEmail(email)) throw new IllegalArgumentException("Email must match a valid format.");
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!Validate.validatePhoneNumber(phoneNumber))
            throw new IllegalArgumentException("Phone number must match a valid format");
        this.phoneNumber = phoneNumber;
    }

    // Override toString method for system printing
    @Override
    public String toString() {
        return String.format("Contact: {Name: %s, Email: %s, PhoneNumber: %s ", this.getName(), this.getEmail(), this.getPhoneNumber());
    }
}
