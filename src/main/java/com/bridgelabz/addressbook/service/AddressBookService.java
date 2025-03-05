package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.AddressBookEntry;
import org.springframework.stereotype.Service;
import java.util.*;

// Service class for managing Address Book operations
@Service
public class AddressBookService {
    // Using a HashMap to store entries with a user-given ID instead of list indexing
    private final Map<Integer, AddressBookEntry> addressBook = new HashMap<>();

    // Fetch all entries
    public List<AddressBookEntry> getAllEntries() {
        return new ArrayList<>(addressBook.values()); // Convert map values to a list
    }

    // Fetch an entry by user-given ID
    public AddressBookEntry getEntryById(int id) {
        return addressBook.get(id); // Get entry by user ID
    }

    // Add a new entry with a user-provided ID
    public void addEntry(int id, AddressBookEntry entry) {
        if (addressBook.containsKey(id)) {
            throw new IllegalArgumentException("Error: ID already exists. Choose a unique ID.");
        }
        addressBook.put(id, entry); // Store using user-given ID
    }

    // Update an existing entry using user-given ID
    public void updateEntry(int id, AddressBookEntry entry) {
        if (!addressBook.containsKey(id)) {
            throw new NoSuchElementException("Error: Entry with this ID does not exist.");
        }
        addressBook.put(id, entry); // Update existing entry
    }

    // Delete an entry using user-given ID
    public void deleteEntry(int id) {
        if (!addressBook.containsKey(id)) {
            throw new NoSuchElementException("Error: Entry with this ID does not exist.");
        }
        addressBook.remove(id); // Remove by user-given ID
    }
}