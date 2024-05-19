package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("Size of arrayList decreases by one when Contact is removed")
    void testArrayListSizeDecreasesBy1WhenContactIsRemoved() {
        // Arrange
        AddressBook testAddressBook = new AddressBook();
        Contact mockContact1 = mock(Contact.class);
        Contact mockContact2 = mock(Contact.class);
        testAddressBook.addContact(mockContact1);
        testAddressBook.addContact(mockContact2);
        int expected = testAddressBook.getContacts().size() - 1;
        // Act
        testAddressBook.removeContact(mockContact1);
        // Assert
        assertEquals(expected, testAddressBook.getContacts().size());
    }

    @Test
    @DisplayName("Test addContact adds given object to the contactsList")
    void testAddContactAddsGivenObjectToTheContactsList() {
        // Arrange
        AddressBook testAddressBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
        // Act
        testAddressBook.addContact(mockContact);
        // Assert
        assertEquals(mockContact, testAddressBook.getContacts().get(0));
    }

    @Test
    @DisplayName("Test addContact throws exception when contact is null")
    void testAddContactThrowsExceptionWhenContactIsNull() {
        // Arrange
        AddressBook testAddressBook = new AddressBook();
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(null));
    }

    @Test
    @DisplayName("Test addContact throws exception when contact is already in addressBook")
    void testAddContactThrowsExceptionWhenContactIsAlreadyInAddressBook() {
        // Arrange
        String validName = "Chicken Cereal";
        AddressBook testAddressBook = new AddressBook();
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn(validName);
        testAddressBook.addContact(mockContact);
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact));
    }

    @Test
    @DisplayName("Test viewContacts prints empty message if there are no contacts to view")
    void testViewContactsPrintsEmptyMessageIfThereAreNoContactsToView() {
        // Arrange
        AddressBook testAddressBook = new AddressBook();
        String expected = "There are no contacts to view.";
        // Act
        // Assert
        assertEquals(expected, testAddressBook.viewContacts());
    }
}
