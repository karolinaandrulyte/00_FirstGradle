package org.example;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Starting the application...");
        try {
            SpringApplication.run(Application.class, args);
            logger.info("Application started successfully.");
        } catch (Exception e) {
            logger.error("Application failed to start: " + e.getMessage(), e);
        }
    }
}