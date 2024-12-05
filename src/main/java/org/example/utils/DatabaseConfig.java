package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class DatabaseConfig {
    public static Connection getConnection() throws Exception {
        Map<String, Object> config = YamlConfigLoader.loadConfig();
        Map<String, String> databaseConfig = (Map<String, String>) config.get("database");

        String url = databaseConfig.get("url");
        String username = databaseConfig.get("username");
        String password = databaseConfig.get("password");
        String driver = databaseConfig.get("driver");

        Class.forName(driver);

        return DriverManager.getConnection(url, username, password);
    }

}
