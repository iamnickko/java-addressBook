package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Contact constructor tests")
public class ContactTest {

    @Nested
    class validConstructorArguments {
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

    @Nested
    class testValuesNull {
        String nullTestName = null;
        String validTestName = "Nick Ko";
        String nullTestEmail = null;
        String validTestEmail = "nick@gmail.com";
        String nullTestPhoneNumber = null;
        String validTestPhoneNumber = "07888888888";

        @Test
        @DisplayName("An exception is thrown if the name property is null")
        void testExceptionIsThrownWhenNameIsNull() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(nullTestName, validTestEmail, validTestPhoneNumber));
        }

        @Test
        @DisplayName("An exception is thrown if the email property is null")
        void testAnExceptionIsThrownWhenEmailIsNull() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(validTestName, nullTestEmail, validTestPhoneNumber));
        }

        @Test
        @DisplayName("An exception is thrown if the phoneNumber property is null")
        void testAnExceptionIsThrownWhenPhoneNumberIsNull() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(validTestName, validTestEmail, nullTestPhoneNumber));
        }

    }

    @Nested
    class testValuesEmpty {
        String emptyTestName = "  ";
        String validTestName = "Nick Ko";
        String emptyTestEmail = "  ";
        String validTestEmail = "nick@gmail.com";
        String emptyTestPhoneNumber = "  ";
        String validTestPhoneNumber = "07888888888";

        @Test
        @DisplayName("An exception is thrown if the name property is empty")
        void testExceptionIsThrownWhenNameIsEmpty() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(emptyTestName, validTestEmail, validTestPhoneNumber));
        }

        @Test
        @DisplayName("An exception is thrown if the email property is empty")
        void testAnExceptionIsThrownWhenEmailIsEmpty() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(validTestName, emptyTestEmail, validTestPhoneNumber));
        }

        @Test
        @DisplayName("An exception is thrown if the phoneNumber property is empty")
        void testAnExceptionIsThrownWhenPhoneNumberIsEmpty() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> new Contact(validTestName, validTestEmail, emptyTestPhoneNumber));
        }

    }

    @Nested
    class testSettersThrowExceptions {
        String validName = "Nick Ko";
        String validEmail = "nick@gmail.com";
        String validPhone = "07888888888";
        String invalidName = "Henry33";
        String invalidEmail = "henrynodomain.com";
        String invalidPhone = "henrysPhone";


        @Test
        @DisplayName("Test setName throws exception if invalid value")
        void testSetNameThrowsExceptionIfInvalidValue() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testContact.setName(invalidName));
        }

    }

}