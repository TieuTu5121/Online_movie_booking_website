package com.example.nedcinema.Impl;

import com.example.nedcinema.Exception.NotFoundException;
import com.example.nedcinema.Exception.OrderCancellationException;
import com.example.nedcinema.entity.Orders;
import com.example.nedcinema.repository.OrderItemRepository;
import com.example.nedcinema.repository.OrdersRepository;
import com.example.nedcinema.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getOrderById(int id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id " + id));
    }

    @Override
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public void updateOrder(Orders order) {
        ordersRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public void cancelOrder(int orderId) {
        Optional<Orders> exittingOder = ordersRepository.findById(orderId);
       
        if (exittingOder .isPresent()) {
            throw new NotFoundException("Order not found with id: " + orderId);
        }
        Orders order = exittingOder.get();
        if (order.getClass().equals("Completed") || order.getClass().equals("Cancelled")) {
            throw new OrderCancellationException("Order with id " + orderId + " cannot be cancelled as it is already completed or cancelled.");
        }
        order.setStatus("Cancelled");
        ordersRepository.save(order);
        if (order.getOrderItem() != null) {
            orderItemRepository.delete(order.getOrderItem());
        }
    }

}
