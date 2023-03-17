package com.example.nedcinema.repository;

import com.example.nedcinema.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
