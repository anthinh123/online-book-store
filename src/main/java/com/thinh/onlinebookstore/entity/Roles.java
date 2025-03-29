package com.thinh.onlinebookstore.entity;

public enum Roles {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    public final String value;

    private Roles(String value) {
        this.value = value;
    }

}
