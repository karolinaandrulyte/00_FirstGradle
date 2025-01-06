package org.example.utils;

import java.sql.Connection;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private static final Logger logger = LogManager.getLogger(DatabaseConfig.class);

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws Exception {
        try {
            logger.info("Getting database connection...");
            return dataSource.getConnection();
        } catch (Exception e) {
            logger.error("Failed to get database connection: {}", e.getMessage(), e);
            throw e;
        }
    }
}
