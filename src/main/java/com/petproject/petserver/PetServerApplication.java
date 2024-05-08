package com.petproject.petserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class PetServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetServerApplication.class, args);
    }

}
