package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;


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


//    @Nested
//    class viewContactsTests {
//        /* I need to return something to be able to run a test (I believe), first test was fine but second meant I
//        couldn't simply loop through and system.out each contact. I think I need to create a new String to concat all
//        contact results to and then return that? */
//        @Test
//        @DisplayName("Test viewContacts prints empty message if there are no contacts to view")
//        void testViewContactsPrintsEmptyMessageIfThereAreNoContactsToView() {
//            // Arrange
//            AddressBook testAddressBook = new AddressBook();
//            String expected = "There are no contacts to view.";
//            // Act
//            // Assert
//            assertEquals(expected, testAddressBook.viewContacts());
//        }
//
//        @Test
//        @DisplayName("Test viewContacts returns valid contact details")
//        void testViewContactsReturnsValidContactDetails() {
//            String validName = "Sausage Pancake";
//            String validEmail = "itdoesntsound@thewurst.com";
//            String validPhone = "07863726374";
//
//            // Arrange
//            AddressBook testAddressBook = new AddressBook();
//            Contact mockContact = mock(Contact.class);
//            when(mockContact.getName()).thenReturn(validName);
//            when(mockContact.getEmail()).thenReturn(validEmail);
//            when(mockContact.getPhoneNumber()).thenReturn(validPhone);
//            testAddressBook.addContact(mockContact);
//            String expected = String.format("Name: %s, Email: %s, PhoneNumber: %s}", validName, validEmail, validPhone);
//            // Act
//            // Assert
//            assertEquals(expected, testAddressBook.viewContacts());
//        }
//    }

    @Nested
    class testEditContacts {

        String name = "Gnarly Corkscrew";
        String email = "spinny@twisty.com";
        String phoneNumber = "07999999999";
        String newName = "Prison Donkey";
        String newEmail = "itsreallya@zebra.com";
        String newPhoneNumber = "07654362516";
        String invalidName = "Leeds Bradford";

        @Test
        @DisplayName("Test editContact changes email to new value")
        void testEditContactChangesEmailToNewValue() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = new Contact(name, email, phoneNumber);    // I know tightly coupled. Struggling with Mockito!
//            Contact mockContact = mock(Contact.class);
//            when(mockContact.getName()).thenReturn(name);
//            when(mockContact.getEmail()).thenReturn(email);
//            when(mockContact.getPhoneNumber()).thenReturn(phoneNumber);
            testAddressBook.addContact(testContact);
            // Act
            testAddressBook.editContact(name, newName, newEmail, newPhoneNumber);
            // Assert
            assertEquals(testContact.getEmail(), newEmail);
        }

        @Test
        @DisplayName("Test editContact changes name to new value")
        void testEditContactChangesNameToNewValue() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = new Contact(name, email, phoneNumber);
            testAddressBook.addContact(testContact);
            // Act
            testAddressBook.editContact(name, newName, newEmail, newPhoneNumber);
            // Assert
            assertEquals(testContact.getName(), newName);
        }

        @Test
        @DisplayName("Test editContact changes phoneNumber to new value")
        void testEditContactChangesPhoneNumberToNewValue() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = new Contact(name, email, phoneNumber);
            testAddressBook.addContact(testContact);
            // Act
            testAddressBook.editContact(name, newName, newEmail, newPhoneNumber);
            // Assert
            assertEquals(testContact.getPhoneNumber(), newPhoneNumber);
        }

        @Test
        @DisplayName("Test editContact throws exception if contact not found")
        void testEditContactThrowsExceptionIfContactNotFound() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact testContact = new Contact(name, email, phoneNumber);
            testAddressBook.addContact(testContact);
            // Act
            // Assert
            assertThrows(RuntimeException.class, () -> testAddressBook.editContact(invalidName, newName, newEmail, newPhoneNumber));
        }
    }
}
