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
public class Main extends Application
{
    /**
     * Точка входа
     *
     * @param arguemnts Аргументы командной строки
     */
    public static void main(String[] arguments) throws Exception
    {
        launch(arguments);
    }                                 

    @Override
    public void start(Stage stage) 
	{
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(400);
        stage.setHeight(300);   
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        Scene scene = new Scene(htmlEditor);       
        stage.setScene(scene);
        stage.show();
    }
}
