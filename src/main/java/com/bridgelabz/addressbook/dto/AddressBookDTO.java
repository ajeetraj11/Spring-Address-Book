package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotation to generate getters, setters, and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    // Unique ID for the address book entry
    private int id;

    // Name of the person
    private String name;

    // Phone number of the person
    private String phone;

    // Email address of the person
    private String email;
}