package com.example.nedcinema.controller;

import com.example.nedcinema.entity.*;
import com.example.nedcinema.service.OrderItemService;
import com.example.nedcinema.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/{orderId}/order-item")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable int orderId) {
        return (List<OrderItem>) orderService.getOrderById(orderId).getOrderItem();
    }


    @GetMapping("/{orderId}/showtime")
    public Showtime getShowtimeByOrderId(@PathVariable int orderId) {
        return orderService.getOrderById(orderId).getShowtime();
    }

    @GetMapping("/{orderId}/cinema")
    public Cinemas getCinemaByOrderId(@PathVariable int orderId) {
        return orderService.getOrderById(orderId).getCinema();
    }

    @GetMapping("/{orderId}/movie")
    public Movies getMovieByOrderId(@PathVariable int orderId) {
        return orderService.getOrderById(orderId).getMovie();
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order has been cancelled successfully.");
    }

    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable int orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/order-items")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.createOrderItem(orderItem);
        return ResponseEntity.ok(orderItem);
    }

    @PutMapping("/order-items")
    public ResponseEntity<String> updateOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItem(orderItem);
        return ResponseEntity.ok("Order item has been updated successfully.");
    }

    @DeleteMapping("/order-items/{orderItemId}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable int orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
        return ResponseEntity.ok("Order item with id " + orderItemId + " has been deleted successfully.");
    }

}
