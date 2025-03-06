package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for handling Address Book API requests
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Inject AddressBookService to handle business logic
    @Autowired
    private AddressBookService addressBookService;

    // GET request to fetch all Address Book entries
    @GetMapping
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // GET request to fetch an entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    // POST request to add a new entry
    @PostMapping
    public ResponseEntity<AddressBookModel> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addEntry(dto));
    }

    // PUT request to update an existing entry
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateEntry(id, dto));
    }

    // DELETE request to remove an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        addressBookService.deleteEntry(id);
        return ResponseEntity.ok("Entry deleted successfully for ID: " + id);
    }
}