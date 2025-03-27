package com.contactManagerApp.services;

import com.contactManagerApp.data.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(Contact contact);
    Contact updateContact(String id, Contact updatedContact);
    boolean deleteContact(String id);
    List<Contact> searchContact(String query);
    Optional<Contact> getContactById(String id);
    Optional<Contact> shareContact(String contactId, String targetUserId);
    List<Contact> getAllContacts();

}
