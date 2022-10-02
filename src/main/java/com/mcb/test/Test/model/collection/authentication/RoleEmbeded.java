package com.mcb.test.Test.model.collection.authentication;

import com.mcb.test.Test.model.enumeration.authentication.RoleEnum;
import lombok.Data;

@Data
public class RoleEmbeded {
    private String id;
    private RoleEnum name;

    public RoleEmbeded(RoleEnum name) {
        this.name = name;
    }
}
