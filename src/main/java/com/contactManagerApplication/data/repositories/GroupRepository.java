package com.contactManagerApplication.data.repositories;

import com.contactManagerApplication.data.models.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupRepository extends MongoRepository<Group, String>{
    Optional<Group> findByName(String name);
}
