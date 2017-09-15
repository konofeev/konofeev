package ru.konofeev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;

/**
 * Основной класс 
 */
public class DataBaseService
{
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_NAME = "konofeev.db";
    private static final String DB_PATH = "src/main/db/";
    private static final String DB_PROTOCOL = "jdbc:sqlite:";

    /**
     * Получить подключение
     */
    public Statement getStatement() throws Exception
    {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(DB_PROTOCOL + DB_PATH + DB_NAME);
        return connection.createStatement();
    }

}
