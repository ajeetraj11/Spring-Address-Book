package com.bridgelabz.addressbook.exception;

// Custom Exception Class for Address Book Errors
public class AddressBookException extends RuntimeException {
    public AddressBookException(String message) {
        super(message);
    }
}