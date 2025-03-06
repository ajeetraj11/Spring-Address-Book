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
    @NotEmpty(message = "Full Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Full Name must start with a capital letter and contain at least 3 characters")
    private String fullName;

    // Phone number validation: Required and must match a 10-digit pattern
    @NotEmpty(message = "Phone Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    // Address field validation: Required
    @NotEmpty(message = "Address is required")
    private String address;

    // City field validation: Required
    @NotEmpty(message = "City is required")
    private String city;

    // State field validation: Required
    @NotEmpty(message = "State is required")
    private String state;

    // Zip Code validation: Required and must be 6 digits
    @NotEmpty(message = "Zip Code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Zip Code must be 6 digits")
    private String zipCode;
}