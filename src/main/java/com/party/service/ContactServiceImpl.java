package com.party.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.dto.ContactDTO;
import com.party.entity.Contact;
import com.party.exception.PartyException;
import com.party.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addContact(ContactDTO contactDTO) throws PartyException {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contactRepository.save(contact);
        return "Contact added successfully";
    }

    @Override
    public String updateContact(ContactDTO contactDTO) throws PartyException {
        Contact existingContact = contactRepository.findById(contactDTO.getContactId())
                .orElseThrow(() -> new PartyException("Contact not found"));
        modelMapper.map(contactDTO, existingContact);
        contactRepository.save(existingContact);
        return "Contact updated successfully";
    }

    @Override
    public void deleteContact(int contactId) throws PartyException {
        if (!contactRepository.existsById(contactId)) {
            throw new PartyException("Contact not found");
        }
        contactRepository.deleteById(contactId);
    }

    @Override
    public List<ContactDTO> getContacts() throws PartyException {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }
}
