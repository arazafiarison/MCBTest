package com.mcb.test.Test.model.collection.location;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Region {
    @Id
    private String id;
    private String region;
}
