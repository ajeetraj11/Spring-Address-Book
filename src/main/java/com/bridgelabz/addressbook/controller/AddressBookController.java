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
    @GetMapping("/getall")
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // GET request to fetch an Model by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookModel> getModelById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getModelById(id));
    }

    // POST request to add a new Model
    @PostMapping("/create")
    public ResponseEntity<AddressBookModel> addModel(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addModel(dto));
    }

    // PUT request to update an existing Model
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookModel> updateModel(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateModel(id, dto));
    }

    // DELETE request to remove an Model by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable int id) {
        addressBookService.deleteModel(id);
        return ResponseEntity.ok("Model deleted successfully for ID: " + id);
    }
}