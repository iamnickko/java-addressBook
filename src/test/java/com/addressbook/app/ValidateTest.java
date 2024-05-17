package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Validate class tests")
public class ValidateTest {

    @Nested
    class testStrings {
        String validName = "Nick";
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

}
}