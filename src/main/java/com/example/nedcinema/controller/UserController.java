package com.example.nedcinema.controller;

import com.example.nedcinema.entity.User;
import com.example.nedcinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userUID}")
    public User getUser(@PathVariable String userUID) {
        return userService.getUser(userUID);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userUID}")
    public User updateUser(@PathVariable String userUID, @RequestBody User user) {
        return userService.updateUser(userUID, user);
    }

    @DeleteMapping("/{userUID}")
    public void deleteUser(@PathVariable String userUID) {
        userService.deleteUser(userUID);
    }
}
