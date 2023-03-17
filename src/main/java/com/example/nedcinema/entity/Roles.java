package com.example.nedcinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

    @Entity
    @Table(name = "roles")
    @AllArgsConstructor
    public class Roles {

        public static final int USER_ROLE_ID = 1;
        public static final int ADMIN_ROLE_ID = 2;

        @Id
        @Column(name="id",nullable = false)
        private int id;

        @Column(name = "role",nullable = false)
        private String role;

    public Roles() {}
    public Roles(int id) {
        this.id = id;
        this.role = (id == USER_ROLE_ID) ? "USER" : "ADMIN";
    }

    // Getters and setters
    public String getRoleName() {
        return role;
    }

    public void setRoleName(String roleName) {

        this.role = roleName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
