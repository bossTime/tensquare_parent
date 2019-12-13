package com.tentsquare.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        run(UserApplication.class);
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }
}
