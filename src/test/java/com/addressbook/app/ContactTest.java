package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {
    @Test
    @DisplayName("Constructor sets values when valid.")
    public void testConstructorSetsValuesWhenValid() {
        // Arrange
        String testName = "Nick Ko";
        String testEmail = "myemail@gmail.com";
        String testPhoneNumber = "07401854698";
        // Act
        Contact testContact = new Contact(testName, testEmail, testPhoneNumber);
        // Assert
        assertAll("Constructor sets values when valid",
                () -> assertEquals(testName, testContact.getName()),
                () -> assertEquals(testEmail, testContact.getEmail()),
                () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()));
    }
}