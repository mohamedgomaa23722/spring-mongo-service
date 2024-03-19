package com.mg.mongo.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
public class UserEntity {

    @Id
    private String id;

    private String first_name;

    private String last_name;

    private int age;
}
