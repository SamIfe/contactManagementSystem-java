package com.contactManagerApp.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Addresses")
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private AddressType type;
    private boolean isPrimary;
    private LocalDateTime createdAt;
}
