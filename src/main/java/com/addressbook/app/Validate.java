package com.addressbook.app;

public abstract class Validate {

    public static boolean validateName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        };
        return true;
    }
}
