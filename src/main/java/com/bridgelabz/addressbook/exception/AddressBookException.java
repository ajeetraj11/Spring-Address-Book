package com.bridgelabz.addressbook.exception;

// Custom Exception for Address Book Entry Not Found
public class AddressBookException extends RuntimeException {
    // Constructor to accept a custom error message
    public AddressBookException(String message) {
        super(message);
    }
}