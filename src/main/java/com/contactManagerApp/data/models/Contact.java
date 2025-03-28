package com.contactManagerApp.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contacts")
public class Contact {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String displayName;
    private String profilePhotoUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private Set<Group> groups = new HashSet<>();
    private List<String> sharedWithUserIds = new ArrayList<>();
}
