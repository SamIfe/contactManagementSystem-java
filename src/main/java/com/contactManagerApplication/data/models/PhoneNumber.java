package com.contactManagerApplication.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Phone_number")
public class PhoneNumber {
    @Id
    private String Id;
    private String number;
    private PhoneType type;
    private boolean isPrimary;
    private LocalDateTime createdAt;
}
