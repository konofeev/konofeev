package ru.konofeev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;

/**
 * Базовый класс работы с базой данных
 * Используется легковестная БД sqlite 3
 */
public class DataBaseService
{
    /**
     * Драйвер базы данных
     */
    private static final String DRIVER = "org.sqlite.JDBC";

    /**
     * Имя файла базы данных
     */
    private static final String DB_NAME = "konofeev.db";

    /**
     * Путь имени файла базы данных
     */
    private static final String DB_PATH = "src/main/db/";

    /**
     * Протокол подключения к базе данных
     */
    private static final String DB_PROTOCOL = "jdbc:sqlite:";

    /**
     * Получить подключение БД
     */
    public Statement getStatement() throws Exception
    {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(DB_PROTOCOL + DB_PATH + DB_NAME);
        return connection.createStatement();
    }

}
