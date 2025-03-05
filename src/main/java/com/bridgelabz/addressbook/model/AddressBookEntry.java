package com.bridgelabz.addressbook.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotation to generate getters, setters, and constructors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookEntry {
    // Unique ID for each entry
    private int id;

    // Name of the person
    private String name;

    // Contact number
    private String phone;

    // Email address
    private String email;
}