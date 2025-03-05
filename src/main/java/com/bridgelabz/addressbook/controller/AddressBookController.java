package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.model.AddressBookEntry;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

// REST Controller for Address Book
@RestController
@RequestMapping("/api")
public class AddressBookController {

    // Inject AddressBookService
    @Autowired
    private AddressBookService addressBookService;

    // GET request to fetch all entries
    @GetMapping
    public ResponseEntity<List<AddressBookEntry>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // GET request to fetch an entry by user-given ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEntryById(@PathVariable int id) {
        try {
            AddressBookEntry entry = addressBookService.getEntryById(id);
            return ResponseEntity.ok(entry);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body("Error: Entry with ID " + id + " not found.");
        }
    }

    // POST request to add a new entry with a user-given ID
    @PostMapping
    public ResponseEntity<String> addEntry(@RequestParam int id, @RequestBody AddressBookEntry entry) {
        try {
            addressBookService.addEntry(id, entry);
            return ResponseEntity.ok("Entry added successfully with ID: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // PUT request to update an entry by user-given ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestBody AddressBookEntry entry) {
        try {
            addressBookService.updateEntry(id, entry);
            return ResponseEntity.ok("Entry updated successfully for ID: " + id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // DELETE request to remove an entry by user-given ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        try {
            addressBookService.deleteEntry(id);
            return ResponseEntity.ok("Entry deleted successfully for ID: " + id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}