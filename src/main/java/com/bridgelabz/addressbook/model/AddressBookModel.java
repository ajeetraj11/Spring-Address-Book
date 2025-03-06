package com.bridgelabz.addressbook.model;

import lombok.*;

// Lombok annotation to generate getters, setters, and constructors
@ToString
@Getter
@Setter
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