package ru.konofeev.gui;

import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Главное окно приложения
 */
public class MainWindow extends Application
{
    private static final String TITLE = "Заметки";
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    @Override
    public void start(Stage stage)
    {
        stage.setTitle(TITLE);
        stage.setMaximized(true);

        Label helloWorldLabel = new Label("Hello world!");

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(helloWorldLabel);

        Scene scene = new Scene(borderPane);
        scene.addEventFilter(KeyEvent.KEY_TYPED, this::processingKeyboard);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Запуск
     *
     * @param arguments Аргументы командной строки
     */
    public static void start(String[] arguments)
    {
        launch(arguments);
    }

    private void processingKeyboard(Event event)
    {
        if (((KeyEvent)event).getCharacter().equals(":"))
        {
            LOGGER.info(String.format("Goto command line: %s type: %s", ((KeyEvent) event).getCharacter(), event.getTarget().getClass().getName()));
            
            if (event.getTarget().getClass().getName().equals(WebView.class.getName()))
            {
                event.consume();
            }
        }
    }
}
