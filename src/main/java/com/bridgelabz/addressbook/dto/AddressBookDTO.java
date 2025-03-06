package com.bridgelabz.addressbook.dto;

import lombok.*;

// Lombok annotation to auto-generate getters, setters, and constructors
@Getter
@Setter
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