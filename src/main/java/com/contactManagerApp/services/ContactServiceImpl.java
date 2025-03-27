package com.contactManagerApp.services;

import com.contactManagerApp.data.models.Contact;
import com.contactManagerApp.data.repositories.ContactRepository;
import com.contactManagerApp.data.repositories.GroupRepository;
import com.contactManagerApp.data.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Contact createContact(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(String id, Contact updatedContact) {
        return contactRepository.findById(id).map(existingContact ->{
            existingContact.setFirstName(updatedContact.getFirstName());
            existingContact.setLastName(updatedContact.getLastName());
            existingContact.setDisplayName(updatedContact.getDisplayName());
            existingContact.setProfilePhotoUrl(updatedContact.getProfilePhotoUrl());
            existingContact.setUpdatedAt(LocalDateTime.now());

        }
    }

    @Override
    public boolean deleteContact(String id) {
        if(contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Contact> searchContact(String query) {
        return contactRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(query, query);
    }

    @Override
    public Optional<Contact> getContactById(String id) {
        return contactRepository.findById(id);
    }

    @Override
    public Optional<Contact> shareContact(String contactId, String targetUserId) {
        Optional<Contact> contactOption = contactRepository.findById(targetUserId);
        if(contactOption.isPresent() && userRepository
                .findById(targetUserId).isPresent()){
        Contact contact = contactOption.get();
            return Optional.of(contactRepository.save(contact));
        }
        return Optional.empty();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

}