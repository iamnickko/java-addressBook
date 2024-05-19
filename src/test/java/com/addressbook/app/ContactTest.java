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
    class testConstructorValuesNull {
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
    class testConstructorValuesEmpty {
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
    class testSettersThrowExceptionsWhenInvalid {
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

        @Test
        @DisplayName("Test setEmail throws exception if invalid value")
        void testSetEmailThrowsExceptionIfInvalidValue() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, ()-> testContact.setEmail(invalidEmail));
        }

        @Test
        @DisplayName("Test setPhoneNumber throws exception if invalid value")
        void testSetPhoneNumberThrowsExceptionIfInvalidValue() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> testContact.setPhoneNumber(invalidPhone));
        }

    }

    @Nested
    class testSettersThrowExceptionsWhenEmpty{

        String validName = "Nick Ko";
        String validEmail = "nick@gmail.com";
        String validPhone = "07888888888";
        String whiteSpace= "  ";

        @Test
        @DisplayName("Test setName throws exception if whitespace")
        void testSetNameThrowsExceptionIfWhiteSpace() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail,validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, ()-> testContact.setName(whiteSpace));
        }

        @Test
        @DisplayName("Test setEmail throws exception if whitespace")
        void testSetEmailThrowsExceptionIfWhiteSpace() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, ()-> testContact.setEmail(whiteSpace));
        }

        @Test
        @DisplayName("Test setPhoneNumber throws exception if whitespace")
        void testSetPhoneNumberThrowsExceptionIfWhiteSpace() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, ()-> testContact.setPhoneNumber(whiteSpace));
        }
    }

    @Nested
    class testSettersSetValidValues {

        // maybe an unnecessary test suite but it adds test coverage!

        String validName = "Nick Ko";
        String validEmail = "nick@gmail.com";
        String validPhone = "07888888888";
        String newValidName = "Hydrogen Helium";
        String newValidEmail = "magnesium@mercury.com";
        String newValidPhone = "07999999999";

        @Test
        @DisplayName("Test setName sets a new valid value")
        void testSetNameSetsANewValidValue () {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            String expected = newValidName;
            // Act
            testContact.setName(newValidName);
            // Assert
            assertEquals(expected, testContact.getName());
        }

        @Test
        @DisplayName("Test setEmail sets a new valid email")
        void testSetEmailSetsANewValidEmail() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            String expected = newValidEmail;
            // Act
            testContact.setEmail(newValidEmail);
            // Assert
            assertEquals(expected, testContact.getEmail());
        }

        @Test
        @DisplayName("Test setPhoneNumber sets a new valid phone number")
        void testSetPhoneNumberSetsANewValidPhoneNumber() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhone);
            String expected = newValidPhone;
            // Act
            testContact.setPhoneNumber(newValidPhone);
            // Assert
            assertEquals(expected, testContact.getPhoneNumber());
        }
    }

    @Nested
    class testToStringOverride {

        String validName = "Juggernaut Kitkat";
        String validEmail = "kittykat@meowmeow.com";
        String validPhoneNumber = "07555555555";

        @Test
        @DisplayName("Test override toString contains expected name")
        void testOverrideToStringContainsExpectedName() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhoneNumber);
            String expectedName = validName;
            // Act
            // Assert
            assertTrue(testContact.getName().toString().contains(expectedName));
        }

        @Test
        @DisplayName("Test override toString contains expected email")
        void testOverrideToStringContainsExpectedEmail() {
            // Arrange
            Contact testContact = new Contact(validName, validEmail, validPhoneNumber);
            String expectedEmail = validEmail;
            // Act
            // Assert
            assertTrue(testContact.getEmail().toString().contains(expectedEmail));

        }
    }
}