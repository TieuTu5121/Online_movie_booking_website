package com.example.nedcinema.Impl;

import com.example.nedcinema.entity.User;
import com.example.nedcinema.repository.UserRepository;
import com.example.nedcinema.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Check if the email already exists in the database

        // Create the user
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String userUID, User user) {
        Optional<User> optionalUser = userRepository.findById(userUID);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setEmail(user.getEmail());

            existingUser.setPassword(user.getPassword());
            existingUser.setDisplayName(user.getDisplayName());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + userUID);
        }
    }

    @Override
    public void deleteUser(String userUID) {
        userRepository.deleteById(userUID);
    }

    @Override
    public User getUser(String userUID) {
        Optional<User> optionalUser = userRepository.findById(userUID);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found with id: " + userUID);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
