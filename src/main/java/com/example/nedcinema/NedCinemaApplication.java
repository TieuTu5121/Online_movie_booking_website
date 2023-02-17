package com.example.nedcinema;

import com.example.nedcinema.models.Food;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NedCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NedCinemaApplication.class, args);
    }

    private Food food = new Food("Bo bia","cha ngon",2000,"");
    @GetMapping("/")
    public String hello(){
        return food.toString();}

}
