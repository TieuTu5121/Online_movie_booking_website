package com.example.nedcinema.entity;

public class Role {

    private User user;
    private String  role;

    public Role(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "user=" + user +
                ", role='" + role + '\'' +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
