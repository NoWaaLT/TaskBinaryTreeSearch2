package com.orioninc.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.orioninc.logger.LogUtil.logInfo;
import static com.orioninc.logger.LogUtil.logWarning;

public class LiquibaseMigrateUtil {

    public static void updateDatabase(String url, String username, String password) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(DatabaseConnectionUtil.getDatabaseConnection()));
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Liquibase liquibase = new Liquibase("changelog/changelog.xml", new ClassLoaderResourceAccessor(classLoader), database);
            liquibase.update();
            logInfo("Migration complete");
        } catch (SQLException | LiquibaseException e) {
            logWarning("Exception: " + e);
        }
    }
}