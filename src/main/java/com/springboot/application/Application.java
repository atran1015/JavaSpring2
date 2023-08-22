package com.springboot.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks the main class of a Sring Boot application
@SpringBootApplication
public class Application {
    // Program is being ran in this main function
    public static void main(String[] args) {
      // Runs the application    
      SpringApplication.run(Application.class, args);
    }
}