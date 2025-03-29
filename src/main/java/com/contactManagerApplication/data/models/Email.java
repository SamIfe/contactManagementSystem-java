package com.contactManagerApplication.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Emails")
public class Email {
    @Id
    private String id;
    private String address;
    private EmailType type;
    private boolean isPrimary;
    private LocalDateTime createdAt;
}
