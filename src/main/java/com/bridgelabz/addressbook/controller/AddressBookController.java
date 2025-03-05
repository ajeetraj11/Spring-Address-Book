package com.bridgelabz.addressbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AddressBookController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book App.";
    }
}