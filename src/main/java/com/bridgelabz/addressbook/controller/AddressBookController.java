package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for Address Book API
@RestController
@RequestMapping("/api/addressbook")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Fetch all entries
    @GetMapping
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // Fetch entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getModelById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getModelById(id));
    }

    // Add a new entry (with validation)
    @PostMapping
    public ResponseEntity<AddressBookModel> addModel(@Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addModel(dto));
    }

    // Update an existing entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateModel(@PathVariable int id, @Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateModel(id, dto));
    }

    // Delete an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable int id) {
        addressBookService.deleteModel(id);
        return ResponseEntity.ok("Entry deleted successfully for ID: " + id);
    }
}