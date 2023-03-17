package com.example.nedcinema.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;
    @Column(name = "quantity_food", nullable = false)
    private int quantity_food;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_number_id")
    private SeatNumber seatNumber;

    @Column(name = "quantity_seat", nullable = false)
    private int quantity_seat;

    @Column(name = "price", nullable = false)
    private int price;

    // constructors, getters, and setters

    public OrderItem(Orders order, Food food, int quantity_food, SeatNumber seatNumber, int quantity_seat, int price) {
        this.order = order;
        this.food = food;
        this.quantity_food = quantity_food;
        this.seatNumber = seatNumber;
        this.quantity_seat = quantity_seat;
        this.price = price;
    }

    public OrderItem() {

    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity_food() {
        return quantity_food;
    }

    public void setQuantity_food(int quantity_food) {
        this.quantity_food = quantity_food;
    }

    public SeatNumber getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(SeatNumber seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getQuantity_seat() {
        return quantity_seat;
    }

    public void setQuantity_seat(int quantity_seat) {
        this.quantity_seat = quantity_seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

