package com.example.nedcinema.service;

import com.example.nedcinema.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getAllOrders();
    Orders getOrderById(int id);
    Orders createOrder(Orders order);
    void updateOrder(Orders order);
    void deleteOrder(int id);

    void cancelOrder(int orderId);
}
