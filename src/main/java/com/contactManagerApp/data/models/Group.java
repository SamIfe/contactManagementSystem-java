package com.contactManagerApp.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Groups")
public class Group {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Set<Contact> contacts = new HashSet<>();


}
