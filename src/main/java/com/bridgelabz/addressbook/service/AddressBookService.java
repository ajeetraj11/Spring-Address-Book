package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.*;

// Service class for Address Book operations
@Service
public class AddressBookService {
    // Using a List to store Address Book entries in memory
    private final List<AddressBookModel> addressBook = new ArrayList<>();

    // Method to fetch all Address Book entries
    public List<AddressBookModel> getAllEntries() {
        return new ArrayList<>(addressBook);
    }

    // Method to fetch a single Model by ID
    public AddressBookModel getModelById(int id) {
        return addressBook.stream()
                .filter(Model -> Model.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Error: Model with ID " + id + " not found."));
    }

    // Method to add a new Model using DTO
    public AddressBookModel addModel(AddressBookDTO dto) {
        // Convert DTO to Model and add it to the list
        AddressBookModel Model = new AddressBookModel(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail());
        addressBook.add(Model);
        return Model;
    }

    // Method to update an existing Model using ID
    public AddressBookModel updateModel(int id, AddressBookDTO dto) {
        // Fetch the existing Model
        AddressBookModel Model = getModelById(id);

        // Update fields with new values
        Model.setName(dto.getName());
        Model.setPhone(dto.getPhone());
        Model.setEmail(dto.getEmail());

        return Model;
    }

    // Method to delete an Model by ID
    public void deleteModel(int id) {
        // Fetch Model, if exists
        AddressBookModel Model = getModelById(id);

        // Remove Model from list
        addressBook.remove(Model);
    }
}