package com.example.nedcinema.repository;

import com.example.nedcinema.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}

