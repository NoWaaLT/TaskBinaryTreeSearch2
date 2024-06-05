package com.orioninc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.orioninc.logger.LogUtil.*;

public class DatabaseMigrationUtil extends DatabaseConnectionUtil {

  public DatabaseMigrationUtil() {}

  public void backupDatabaseIntoSqlScript(String sqlFilePath) {
    try {
      Connection connection = getDatabaseConnection();
      PreparedStatement preparedStatement =
          connection.prepareStatement(String.format("SCRIPT TO '%s'", sqlFilePath));
      preparedStatement.execute();
      logInfo("SQL script file created.");
    } catch (SQLException e) {
      logWarning("Exception: " + e);
    }
  }

  public void exportChangeLog(String sqlFilePath) {
    try {
      Connection connection = getDatabaseConnection();
      PreparedStatement preparedStatement =
          connection.prepareStatement(
                  String.format("SCRIPT TO '%s' TABLE DATABASECHANGELOG", sqlFilePath));
      preparedStatement.execute();
    } catch (SQLException e) {
      logWarning("Exception: " + e);
    }
  }
}
