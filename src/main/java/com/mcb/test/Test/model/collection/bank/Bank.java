package com.mcb.test.Test.model.collection.bank;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Bank {
    @Id
    private String id;
    private String name;
}
