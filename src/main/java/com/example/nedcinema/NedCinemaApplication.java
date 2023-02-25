package com.example.nedcinema;

import com.example.nedcinema.entity.Food;
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
    @GetMapping("/")
    public String hello(){
        return "hello";
    }
}
