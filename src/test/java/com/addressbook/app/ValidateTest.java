package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validate class tests")
public class ValidateTest {

    @Nested
    class testNameStrings {
        String validName = "Nick Ko";
        String invalidName = "123";
        String whiteSpace = "  ";

        @Test
        @DisplayName("Test validateName returns true if valid")
        void testValidateNameReturnsTrue() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validate.validateName(validName));
        }

        @Test
        @DisplayName("Test validateName false if whiteSpace")
        void testValidateNameFalseIfWhiteSpace() {
            // Arrange
            // Act
            // Assert
            assertFalse(Validate.validateName(whiteSpace));
//            assertThrows(IllegalArgumentException.class,
//                    () -> Validate.validateName(whiteSpace));
        }

        @Test
        @DisplayName("Test validateName false if invalid")
        void testValidateNameFalseIfInvalid() {
            // Arrange
            // Act
            // Assert
            assertFalse(Validate.validateName(invalidName));
//            assertThrows(IllegalArgumentException.class,
//                    ()-> Validate.validateName(invalidName));
        }


        @Nested
        class testEmailStrings {
            String validEmail = "nick@email.com";
            String invalidEmail = "nickemail";
            String whiteSpace = "  ";

            @Test
            @DisplayName("Test validateEmail true if valid")
            void testValidateEmailTrueIfValid() {
                // Arrange
                // Act
                // Assert
                assertTrue(Validate.validateEmail(validEmail));
            }

            @Test
            @DisplayName("Test validateEmailFalseIfInvalid")
            void testValidateEmailFalseIfInvalid() {
                // Arrange
                // Act
                // Assert
                assertFalse(Validate.validateEmail(invalidEmail));
            }

        }


    }
}