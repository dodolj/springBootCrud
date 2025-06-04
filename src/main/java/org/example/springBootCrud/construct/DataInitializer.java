package org.example.springBootCrud.construct;

import jakarta.annotation.PostConstruct;
import org.example.springBootCrud.model.User;
import org.example.springBootCrud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Logger;

@Component
public class DataInitializer {

    private static final Logger logger = Logger.getLogger(DataInitializer.class.getName());

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        try {
            userService.saveUser(new User(UUID.randomUUID(), "admin", "admin123"));
            userService.saveUser(new User(UUID.randomUUID(), "test", "test"));

            logger.info("Test users initialized successfully");
        } catch (Exception e) {
            logger.severe("Error during test data initialization: " + e.getMessage());
        }
    }
}