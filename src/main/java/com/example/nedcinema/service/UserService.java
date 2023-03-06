package com.example.nedcinema.service;

import com.example.nedcinema.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(String userUID, User user);
    void deleteUser(String userUID);
    User getUser(String userUID);
    List<User> getAllUsers();
}
