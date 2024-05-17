package com.addressbook.app;

public abstract class Validate {

    public static final String nameRegex = "^[a-zA-Z]{2,} [a-zA-Z]+$";

    public static boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        return name.matches(nameRegex);
    }
}
