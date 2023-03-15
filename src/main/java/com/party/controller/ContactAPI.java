package com.party.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.party.dto.ContactDTO;
import com.party.exception.PartyException;
import com.party.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin("*")
@Validated
public class ContactAPI {

    @Autowired
    private ContactService contactService;
    
    public static final Log LOGGER = LogFactory.getLog(ContactAPI.class);

    @GetMapping("/ViewAllContact")
    public ResponseEntity<List<ContactDTO>> getContacts() {
    	try {    		
    		List<ContactDTO> contacts = contactService.getContacts();
    		return ResponseEntity.ok().body(contacts);
    	}
    	catch(Exception e) {
    		LOGGER.info(e.getMessage());
    		return null;
    	}
    }

    @PostMapping("/AddContact")
    public ResponseEntity<String> addContact(@RequestBody ContactDTO contactDTO) {
    	try {    		
    		String message = contactService.addContact(contactDTO);
    		return ResponseEntity.status(HttpStatus.CREATED).body(message);
    	}
    	catch(Exception e) {
    		LOGGER.info(e.getMessage());
    		return null;
    	}
    }

    @PutMapping("/UpdateContact")
    public ResponseEntity<String> updateContact(@RequestBody ContactDTO contactDTO){
    	try {    		
    		String message = contactService.updateContact(contactDTO);
    		return ResponseEntity.ok().body(message);
    	}
    	catch(Exception e) {
    		LOGGER.info(e.getMessage());
    		return null;
    	}
    }

    @DeleteMapping("/DeleteContact")
    public ResponseEntity<String> deleteContact(@PathVariable int contactId) {
    	try {    		
    		contactService.deleteContact(contactId);
    		return ResponseEntity.ok().body("Contact deleted successfully");
    	}
    	catch(Exception e) {
    		LOGGER.info(e.getMessage());
    		return null;
    	}
    }
}
