package ru.konofeev.gui;

import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import ru.konofeev.core.Global;

/**
 * Главное окно приложения
 */
public class MainWindow extends Application
{
    private static final String TITLE = "Заметки";
    private final HTMLEditor editor;
    private final TextField commandLine;
    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    /**
     * Конструктор
     */
    public MainWindow()
    {
        editor = (HTMLEditor)Global.INSTANCE.getEditor();
        commandLine = Global.INSTANCE.getCommandLine();
    }

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
        editor.requestFocus();
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
                commandLine.requestFocus();
                event.consume();
            }
            if (event.getTarget().getClass().getName().equals(commandLine.getClass().getName()))
            {
                editor.requestFocus();
                event.consume();
            }
        }
    }
}
