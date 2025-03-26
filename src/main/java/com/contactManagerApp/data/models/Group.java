package com.contactManagerApp.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Document(collection = "Groups")
public class Group {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;

}
