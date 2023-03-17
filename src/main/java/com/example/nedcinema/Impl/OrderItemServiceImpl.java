package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.entity.OrderItem;
import com.example.nedcinema.repository.OrderItemRepository;
import com.example.nedcinema.service.OrderItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderItem not found with id " + id));
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
}
