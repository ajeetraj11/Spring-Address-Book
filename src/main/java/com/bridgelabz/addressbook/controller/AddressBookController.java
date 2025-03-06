package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
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

    // GET request to fetch an Model by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getModelById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getModelById(id));
    }

    // POST request to add a new Model (Validates Name Field)
    @PostMapping
    public ResponseEntity<AddressBookModel> addModel(@Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addModel(dto));
    }

    // PUT request to update an existing Model (Validates Name Field)
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateModel(@PathVariable int id, @Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateModel(id, dto));
    }

    // DELETE request to remove an Model by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable int id) {
        addressBookService.deleteModel(id);
        return ResponseEntity.ok("Model deleted successfully for ID: " + id);
    }
}