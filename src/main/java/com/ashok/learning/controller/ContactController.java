package com.ashok.learning.controller;

import com.ashok.learning.model.Contact;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path="/contact")
@RestController
public class ContactController {

    public Map<String, Contact> contactMap = new HashMap<>();

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contactMap.values());
    }

    @ApiOperation(value = "Get contacts by Id",
            notes="provide an id and look up specific contact",
            response = Contact.class
    )
    @GetMapping("/{id}")
    public Contact getAllContacts(@PathVariable String id){
        return contactMap.get(id);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contactMap.put(contact.getId(), contact);
        return contact;
    }
}
