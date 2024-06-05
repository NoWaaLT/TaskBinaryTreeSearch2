package com.orioninc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    public static final String DB_URL = "jdbc:h2:file:~/IdeaProjects/TaskBinaryTreeSearch/src/main/resources/db/db2";
    public static final String USER_DB = "sa";
    public static final String USER_PASS = "";

    public static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_DB, USER_PASS);
    }
}
