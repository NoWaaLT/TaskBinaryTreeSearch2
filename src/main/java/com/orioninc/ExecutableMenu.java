package com.orioninc;

import com.orioninc.abstractfactory.AbstractFactory;
import com.orioninc.abstractfactory.FactoryProducer;
import com.orioninc.abstractfactory.Search;
import com.orioninc.db.DatabaseConnectionUtil;
import com.orioninc.db.DatabaseMigrationUtil;

import com.orioninc.db.LiquibaseMigrateUtil;

import static com.orioninc.logger.LogUtil.*;

import java.util.Scanner;

public class ExecutableMenu {

    enum Choice {
        EXTRACT,
        EXPORT,
        CHANGELOG,
        UPDATE
    }

    public static void main(String[] args) {

        AbstractFactory searchFactory = FactoryProducer.getFactory();
        System.out.println(
                """
                        EXTRACT - Extract from File/Web page\s
                        EXPORT - Export a database
                        CHANGELOG - Export Changelog history file
                        UPDATE - Liquibase update""");

        try {

            Scanner sc = new Scanner(System.in);
            Choice choice = Choice.valueOf(sc.nextLine().toUpperCase());

            switch (choice) {
                case EXTRACT -> {
                    System.out.println("Input a file name or URL: ");
                    String input = sc.nextLine();
                    Search searchFromText = searchFactory.getSearch(input);
                    searchFromText.search();
                }
                case EXPORT -> {
                    DatabaseMigrationUtil databaseMigration = new DatabaseMigrationUtil();
                    databaseMigration.backupDatabaseIntoSqlScript(
                            "C:\\Users\\vjelis\\IdeaProjects\\TaskBinaryTreeSearch\\db_script.sql");
                    logInfo("Export completed");
                }
                case CHANGELOG -> {
                    DatabaseMigrationUtil databaseMigration = new DatabaseMigrationUtil();
                    databaseMigration.exportChangeLog(
                            "C:\\Users\\vjelis\\IdeaProjects\\TaskBinaryTreeSearch\\src\\main\\resources\\changelog\\history\\dbchangeloghistory.sql");
                    logInfo("Export completed");
                }
                case UPDATE -> {
                    LiquibaseMigrateUtil.updateDatabase(DatabaseConnectionUtil.DB_URL,
                            DatabaseConnectionUtil.USER_DB,
                            DatabaseConnectionUtil.USER_PASS);
                }

                default -> System.exit(0);
            }
            sc.close();
        } catch (IllegalArgumentException e) {
            logError("Exception:", e);
        }
    }
}
