package com.mcb.test.Test.model.collection.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String loginId;
}
