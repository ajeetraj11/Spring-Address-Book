package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotation to generate getters, setters, constructors
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_book")
public class AddressBookModel {

    // Primary Key for AddressBook Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Full Name of the contact
    private String fullName;

    // Phone Number of the contact
    private String phoneNumber;

    // Address of the contact
    private String address;

    // City of the contact
    private String city;

    // State of the contact
    private String state;

    // Zip Code of the contact
    private String zipCode;

    // Constructor to create model from DTO
    public AddressBookModel(AddressBookDTO dto) {
        this.fullName = dto.getFullName();
        this.phoneNumber = dto.getPhoneNumber();
        this.address = dto.getAddress();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.zipCode = dto.getZipCode();
    }

    // Method to update model from DTO
    public void update(AddressBookDTO dto) {
        this.fullName = dto.getFullName();
        this.phoneNumber = dto.getPhoneNumber();
        this.address = dto.getAddress();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.zipCode = dto.getZipCode();
    }
}