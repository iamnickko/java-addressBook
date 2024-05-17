package com.addressbook.app;

public abstract class Validate {

    public static final String nameRegex = "^[a-zA-Z]{2,} [a-zA-Z]+$";

    public static boolean validateName(String name) {
        if (!name.matches(nameRegex)){
            throw new IllegalArgumentException("Please enter a valid name.");
        }
        return true;
    }
}
