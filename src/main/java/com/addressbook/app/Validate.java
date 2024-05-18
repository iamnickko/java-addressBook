package com.addressbook.app;

public abstract class Validate {

    public static final String nameRegex = "^[a-zA-Z]{2,} [a-zA-Z]+$";

    public static final String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; // from baeldung.com/java-email-validation-regex

    public static final String phoneNumberRegex = "^07[0-9]{9}$";      // mobile format - no one uses a landline anymore

    public static boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        return name.matches(nameRegex);
    }

    public static boolean validateEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        return email.matches(emailRegex);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null.");
        }
        return phoneNumber.matches(phoneNumberRegex);
    }

    public static boolean validateContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("Can't add null to address book.");
        return true;
    }
}
