package com.contactManagerApplication.controllers;


import com.contactManagerApplication.data.models.Contact;
import com.contactManagerApplication.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/version1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.createContact(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable String id,
            @RequestBody Contact contact
        ) {
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContacts(@RequestParam String query) {
        return ResponseEntity.ok(contactService.searchContacts(query));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }
    @PostMapping("/{contactId}/group/{groupId}")
    public ResponseEntity<Contact> addContactToGroup(
                @PathVariable String contactId,
                @PathVariable String groupId
        ) {
        return ResponseEntity.ok(contactService.addContactToGroup(contactId, groupId));
    }

}
