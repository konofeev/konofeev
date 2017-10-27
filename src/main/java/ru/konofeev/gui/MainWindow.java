package ru.konofeev.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;

/**
 * Главное окно приложения
 */
public class MainWindow extends Application
{
    private static final String TITLE = "Заметки";
    private final HTMLEditor editor;
    private final TextField commandLine;

    /**
     * Запуск
     *
     * @param arguments Аргументы командной строки
     */
    public static void start(String[] arguments)
    {
        launch(arguments);
    }

    /**
     * Конструктор
     */
    public MainWindow()
    {
        editor = new Editor();
        commandLine = new CommandLine();
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle(TITLE);
        stage.setMaximized(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(editor);
        borderPane.setBottom(commandLine);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
