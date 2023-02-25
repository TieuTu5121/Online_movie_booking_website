package com.example.nedcinema.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private String userID;
    private String  password;
    private String displayName;
    private String  mail;
    private Timestamp  created;

    public User(String userID, String password, String displayName, String mail, Timestamp created) {
        this.userID = userID;
        this.password = password;
        this.displayName = displayName;
        this.mail = mail;
        this.created = created;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(password, user.password) && Objects.equals(displayName, user.displayName) && Objects.equals(mail, user.mail) && Objects.equals(created, user.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                ", mail='" + mail + '\'' +
                ", created=" + created +
                '}';
    }
}
