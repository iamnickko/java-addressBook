package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        @DisplayName("Test validateName throws error if whiteSpace")
        void testValidateNameThrowsErrorIfWhiteSpace() {
            // Arrange
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class,
                    () -> Validate.validateName(whiteSpace));
        }


//    @Nested
//    class testEmailStrings {
//        String validEmail = "nick@email.com";
//        String isNull = null;
//        String emailRegex = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g";
//
//    @Test
//        @DisplayName("")
//    }
    }
}