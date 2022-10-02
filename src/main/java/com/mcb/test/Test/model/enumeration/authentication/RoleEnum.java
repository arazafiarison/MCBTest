package com.mcb.test.Test.model.enumeration.authentication;

public enum RoleEnum {
    ADMIN("ADMIN"),
    USER("CLIENT"),
    SUPER_ADMIN("SUPER_ADMIN");

    private String name = "";

    RoleEnum(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
