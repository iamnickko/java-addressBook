package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("An exception is thrown if the name property is empty")
    void testExceptionIsThrownWhenNameIsEmpty() {
        // Arrange
        String testName = "";
        String testEmail = "dasdas";
        String testPhoneNumber = "dasdas";
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }

    @Test
    @DisplayName("An exception is thrown if the email property is empty")
    void testAnExceptionIsThrownWhenEmailIsEmpty() {
        // Arrange
        String testName = "iowajf";
        String testEmail = "";
        String testPhoneNumber = "01234567890";
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }

    @Test
    @DisplayName("An exception is thrown if the phoneNumber property is empty")
    void testAnExceptionIsThrownWhenPhoneNumberIsEmpty() {
        // Arrange
        String testName = "iowajf";
        String testEmail = "dadasd";
        String testPhoneNumber = "";
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }

    @Test
    @DisplayName("An exception is thrown if the name property is null")
    void testExceptionIsThrownWhenNameIsNull() {
        // Arrange
        String testName = null;
        String testEmail = "dasdas";
        String testPhoneNumber = "dasdas";
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }

    @Test
    @DisplayName("An exception is thrown if the email property is null")
    void testAnExceptionIsThrownWhenEmailIsNull() {
        // Arrange
        String testName = "iowajf";
        String testEmail = null;
        String testPhoneNumber = "01234567890";
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }

    @Test
    @DisplayName("An exception is thrown if the phoneNumber property is null")
    void testAnExceptionIsThrownWhenPhoneNumberIsNull() {
        // Arrange
        String testName = "iowajf";
        String testEmail = "dadasd";
        String testPhoneNumber = null;
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(testName, testEmail, testPhoneNumber));
    }


}