package com.example.nedcinema.Impl;

import com.example.nedcinema.entity.Food;
import com.example.nedcinema.repository.FoodRepository;
import com.example.nedcinema.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(int id) {
        Optional<Food> food = foodRepository.findById(id);
        return food.orElse(null);
    }

    @Override
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(int id, Food food) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            Food existingFood = optionalFood.get();
            existingFood.setName(food.getName());
            existingFood.setDescription(food.getDescription());
            existingFood.setPrice(food.getPrice());
            existingFood.setPhoto(food.getPhoto());
            return foodRepository.save(existingFood);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteFood(int id) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            foodRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
