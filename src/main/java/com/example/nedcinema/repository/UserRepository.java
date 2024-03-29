package com.example.nedcinema.repository;

import com.example.nedcinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean findByEmail(String email);
}
