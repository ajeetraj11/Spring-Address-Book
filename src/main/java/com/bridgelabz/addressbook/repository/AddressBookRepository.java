package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for AddressBook
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {
}