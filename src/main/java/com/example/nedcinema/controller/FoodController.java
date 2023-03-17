package com.example.nedcinema.controller;

import com.example.nedcinema.entity.Food;
import com.example.nedcinema.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable int id) {
        Food food = foodService.getFoodById(id);
        if (food == null) {
            System.out.println("Wrong id :" + id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(food);
    }

    @GetMapping("/")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping("/")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable int id) {
        boolean deleted = foodService.deleteFood(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with id " + id + " not found");
        }
        return ResponseEntity.ok().body("Deleted food with id: " + id);
    }
}