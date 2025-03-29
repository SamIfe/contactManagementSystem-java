package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.Contact;
import com.contactManagerApplication.data.models.Group;
import com.contactManagerApplication.data.repositories.ContactRepository;
import com.contactManagerApplication.data.repositories.GroupRepository;
import com.contactManagerApplication.data.repositories.UserRepository;
import com.contactManagerApplication.exceptions.contactExceptions.ContactNotFoundException;
import com.contactManagerApplication.exceptions.groupExeceptions.GroupNotFoundException;
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

    @Autowired
    private GroupRepository groupRepository;

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

            existingContact.getPhoneNumbers().clear();
            existingContact.getPhoneNumbers().addAll(updatedContact.getPhoneNumbers());

            existingContact.getEmails().clear();
            existingContact.getEmails().addAll(updatedContact.getEmails());

            existingContact.getAddresses().clear();
            existingContact.getAddresses().addAll(existingContact.getAddresses());

            return contactRepository.save(existingContact);
        })
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

    @Override
    public void deleteContact(String id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ContactNotFoundException("Contact not found"));

        for (Group group : contact.getGroups()){
            group.getContacts().remove(contact);
            groupRepository.save(group);
        }
        contactRepository.delete(contact);

    }

    @Override
    public List<Contact> searchContacts(String query) {
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

    @Override
    public Contact addContactToGroup(String contactId, String groupId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(()-> new ContactNotFoundException("Contact not found"));

        Group group = groupRepository.findById(groupId)
                .orElseThrow(()-> new GroupNotFoundException("Group not found"));

        contact.getGroups().add(group);
        group.getContacts().add(contact);

        groupRepository.save(group);
        return contactRepository.save(contact);
    }
}