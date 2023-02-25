package com.example.nedcinema.service;

import com.example.nedcinema.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFoods();
    Food getFoodById(int id);
    Food createFood(Food food);
    Food updateFood(int id, Food food);
    boolean deleteFood(int id);
}
