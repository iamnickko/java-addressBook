package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AddressBookTest {

    @Test
    @DisplayName("Size of arrayList increases by one when Contact is added")
    void testArrayListSizeIncreasesBy1WhenContactIsAdded() {
        // Arrange
        AddressBook testAddressBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
        int expected = testAddressBook.getContacts().size() + 1;
        // Act
        testAddressBook.addContact(mockContact);
        // Assert
        assertEquals(expected, testAddressBook.getContacts().size());
    }
}
