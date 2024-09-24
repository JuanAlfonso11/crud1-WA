package com.example.crud_sensillo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.crud_sensillo.Estudiante")
public class CrudSensilloApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSensilloApplication.class, args);
    }
}