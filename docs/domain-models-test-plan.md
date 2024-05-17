# Domain Models, Class Diagrams and Test Plan

```mermaid
classDiagram
    class AddressBook {
        -contacts ArrayList<Contact>
        +AddressBook()
        +getContacts() ArrayList<Contact>
        +addContact(contact Contact) void
        +removeContact(contact Contact) void
        -checkDuplicateEmail() boolean
        -checkDuplicatePhoneNumber() boolean
    }
    class Contact {
        -name String
        -email String
        -phoneNumber String
        +Contact(name String, email String, phoneNumber String)
        +getName() String
        +setName() void
        +getEmail() String
        +setEmail() void
        +getPhoneNumber() String
        +setPhoneNumber() void
        -validateName() void
        -validateEmail() void
        -validatePhoneNumber() void
    }
```