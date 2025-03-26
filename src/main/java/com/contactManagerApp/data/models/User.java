package com.contactManagerApp.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime lastLogin;
}
