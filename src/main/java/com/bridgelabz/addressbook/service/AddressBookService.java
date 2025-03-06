package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import org.springframework.stereotype.Service;
import java.util.*;

// Service class for Address Book operations
@Service
public class AddressBookService {
    // In-memory list to store Address Book entries
    private final List<AddressBookModel> addressBook = new ArrayList<>();

    // Method to fetch all Address Book entries
    public List<AddressBookModel> getAllEntries() {
        return new ArrayList<>(addressBook);
    }

    // Method to fetch a single entry by ID
    public AddressBookModel getEntryById(int id) {
        return addressBook.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Error: Entry with ID " + id + " not found."));
    }

    // Method to add a new entry using DTO
    public AddressBookModel addEntry(AddressBookDTO dto) {
        // Convert DTO to Model and add it to the list
        AddressBookModel entry = new AddressBookModel(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail());
        addressBook.add(entry);
        return entry;
    }

    // Method to update an existing entry using ID
    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        // Fetch the existing entry
        AddressBookModel entry = getEntryById(id);

        // Update fields with new values
        entry.setName(dto.getName());
        entry.setPhone(dto.getPhone());
        entry.setEmail(dto.getEmail());

        return entry;
    }

    // Method to delete an entry by ID
    public void deleteEntry(int id) {
        // Fetch entry, if exists
        AddressBookModel entry = getEntryById(id);

        // Remove entry from list
        addressBook.remove(entry);
    }
}