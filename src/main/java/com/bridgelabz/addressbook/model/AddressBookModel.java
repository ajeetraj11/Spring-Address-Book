package com.bridgelabz.addressbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Lombok annotation to generate getters, setters, and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookModel {
    // Unique ID for the address book entry
    private int id;

    // Name of the person
    private String name;

    // Phone number of the person
    private String phone;

    // Email address of the person
    private String email;
}