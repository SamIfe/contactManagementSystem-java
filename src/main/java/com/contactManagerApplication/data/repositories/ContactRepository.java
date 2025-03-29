package com.contactManagerApplication.data.repositories;

import com.contactManagerApplication.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("{'emails.address': ?0}")
    Optional<Contact> findByEmailAddress(String emailAddress);

    @Query("{'emails': {$elemMatch: {'type': ?0, 'address': ?1}}}")
    Optional<Contact> findByEmailTypeAndAddress(String emailType, String emailAddress);

}
