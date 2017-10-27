package ru.konofeev.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import ru.konofeev.gui.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

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
        MainWindow.start(arguments);
    }                                 
}
