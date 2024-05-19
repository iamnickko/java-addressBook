package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputScannerTest {

    @Test
    @DisplayName("Test searchList matches matching contact")
    void testSearchListMatchesMatchingContact() {
        // Arrange
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn("English Breakfast");
        ArrayList<Contact> testContacts = new ArrayList<>();
        testContacts.add(mockContact);
        // Act
        ArrayList<Contact> actual = InputScanner.searchList(testContacts, "eng");
        // Assert
        assertTrue(actual.contains(mockContact));
    }

}
