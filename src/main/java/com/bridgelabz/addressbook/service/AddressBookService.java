package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for business logic
@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    // Retrieve all address book entries
    public List<AddressBookModel> getAllEntries() {
        return addressBookRepository.findAll();
    }

    // Retrieve a specific entry by ID
    public AddressBookModel getModelById(int id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Address Book Entry not found for ID: " + id));
    }

    // Add a new address book entry
    public AddressBookModel addModel(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(dto);
        return addressBookRepository.save(model);
    }

    // Update an existing entry by ID
    public AddressBookModel updateModel(int id, AddressBookDTO dto) {
        AddressBookModel model = getModelById(id);
        model.update(dto);
        return addressBookRepository.save(model);
    }

    // Delete an entry by ID
    public void deleteModel(int id) {
        AddressBookModel model = getModelById(id);
        addressBookRepository.delete(model);
    }
}