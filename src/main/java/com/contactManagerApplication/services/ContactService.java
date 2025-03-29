package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(Contact contact);
    Contact updateContact(String id, Contact updatedContact);
    void deleteContact(String id);
    List<Contact> searchContacts(String query);
    Optional<Contact> getContactById(String id);
    Optional<Contact> shareContact(String contactId, String targetUserId);
    List<Contact> getAllContacts();
    Contact addContactToGroup(String contactId, String groupId);

}
