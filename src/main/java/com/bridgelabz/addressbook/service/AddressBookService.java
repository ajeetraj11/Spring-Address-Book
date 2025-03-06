package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

// Lombok annotation to enable logging
@Slf4j
@Service
public class AddressBookService {
    // Using a List to store Address Book entries in memory
    private final List<AddressBookModel> addressBook = new ArrayList<>();

    // Method to fetch all Address Book entries
    public List<AddressBookModel> getAllEntries() {
        log.info("Fetching all address book entries.");
        return new ArrayList<>(addressBook);
    }

    // Method to fetch a single Model by ID
    public AddressBookModel getModelById(int id) {
        log.info("Fetching Model with ID: {}", id);
        return addressBook.stream()
                .filter(Model -> Model.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Model with ID {} not found.", id);
                    return new NoSuchElementException("Error: Model with ID " + id + " not found.");
                });
    }

    // Method to add a new Model using DTO
    public AddressBookModel addModel(AddressBookDTO dto) {
        log.info("Adding new Model: {}", dto);
        AddressBookModel Model = new AddressBookModel(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail());
        addressBook.add(Model);
        log.info("Model added successfully with ID: {}", dto.getId());
        return Model;
    }

    // Method to update an existing Model using ID
    public AddressBookModel updateModel(int id, AddressBookDTO dto) {
        AddressBookModel Model = getModelById(id);
        Model.setName(dto.getName());
        Model.setPhone(dto.getPhone());
        Model.setEmail(dto.getEmail());
        log.info("Updating Model with ID: {}", id);
        log.info("Updated Model: {}", dto);
        return Model;
    }

    // Method to delete an Model by ID
    public void deleteModel(int id) {
        log.info("Deleting Model with ID: {}", id);
        AddressBookModel Model = getModelById(id);
        addressBook.remove(Model);
        log.info("Model deleted successfully for ID: {}", id);
    }
}