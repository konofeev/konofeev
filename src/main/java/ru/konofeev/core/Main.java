package ru.konofeev.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import ru.konofeev.gui.MainWindow;

/**
 * Основной класс 
 */
public class Main
{
    /**
     * Точка входа
     *
     * @param arguemnts Аргументы командной строки
     */
    public static void main(String[] arguments) throws Exception
    {
        new MainWindow();
    }                                 
}
