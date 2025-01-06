package org.example.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;

@Service
public class DatabaseService {

    private static final Logger logger = LogManager.getLogger(DatabaseService.class);

    @Autowired
    private DatabaseConfig databaseConfig;

    public boolean verifyDatabaseConnection() {
        logger.info("Verifying database connection...");
        try (Connection connection = databaseConfig.getConnection()) {
            boolean isConnected = connection != null && !connection.isClosed();
            logger.info("Database connection verification result: {}", isConnected);
            return isConnected;
        } catch (Exception e) {
            logger.error("Failed to verify database connection: {}", e.getMessage(), e);
            return false;
        }
    }
}
