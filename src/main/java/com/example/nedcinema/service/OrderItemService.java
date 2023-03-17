package com.example.nedcinema.service;

import com.example.nedcinema.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;



public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItemById(int id);
    OrderItem createOrderItem(OrderItem orderItem);
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int id);
}

