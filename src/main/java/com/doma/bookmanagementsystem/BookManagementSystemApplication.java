package com.doma.bookmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookManagementSystemApplication.class, args);
    }

}
