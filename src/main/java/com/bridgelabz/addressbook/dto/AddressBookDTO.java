package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotation to auto-generate getters, setters, and constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    // Unique ID for the address book entry
    private int id;

    // Name field validation: Required and must follow a pattern
    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and contain at least 3 characters")
    private String name;

    // Phone number of the person
    private String phone;

    // Email address of the person
    private String email;
}