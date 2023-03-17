package com.example.nedcinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.annotations.CreationTimestamp;



import java.sql.Timestamp;
import java.util.UUID;


@Entity
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String userUID;

    @Column(name = "Password",nullable = false)
    private String password;

    @Column(name = "DisplayName",nullable = false)
    private String displayName;

    @Column(name = "Email",unique = true,nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name="roleId", referencedColumnName = "id", nullable = false)
    private Roles roles;


    @CreationTimestamp
    @Column(name = "Created",nullable = false)
    private Timestamp created;


    // Constructor
    public User(){
        this.userUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }

    public User(String displayName, String password, String email, Roles roles) {
        this.userUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        this.displayName = displayName;
        this.password = DigestUtils.md5Hex(password);
        this.email = email;
        this.roles = roles;
    }

    // Getter and Setter methods...

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
