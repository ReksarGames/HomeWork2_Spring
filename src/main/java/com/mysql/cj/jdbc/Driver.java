package com.mysql.cj.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Driver implements java.sql.Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to register CustomDriver", e);
        }
    }
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        // Извлекаем параметры подключения из Properties
        String jdbcUrl = info.getProperty("url");
        String username = info.getProperty("username");
        String password = info.getProperty("password");

        // Установка соединения с MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url != null && url.startsWith("jdbc:mysql://") ;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        DriverPropertyInfo[] result = new DriverPropertyInfo[3];

        // свойства для URL
        DriverPropertyInfo urlProperty = new DriverPropertyInfo("url", url);
        urlProperty.required = true;
        result[0] = urlProperty;

        // свойства для имени пользователя
        DriverPropertyInfo userProperty = new DriverPropertyInfo("user", info.getProperty("user"));
        userProperty.required = true;
        result[1] = userProperty;

        // свойства для пароля
        DriverPropertyInfo passwordProperty = new DriverPropertyInfo("password", info.getProperty("password"));
        passwordProperty.required = true;
        result[2] = passwordProperty;

        return result;
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
