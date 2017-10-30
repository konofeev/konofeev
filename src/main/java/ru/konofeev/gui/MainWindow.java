package ru.konofeev.gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
        editor = Global.INSTANCE.getEditor();
        commandLine = Global.INSTANCE.getCommandLine();
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
        scene.addEventFilter
        (
            KeyEvent.KEY_TYPED,
            event -> processingKeyboard(event)
        );
        stage.setScene(scene);
        stage.show();
        editor.requestFocus();
    }

    private void processingKeyboard(Event event)
    {
        if (((KeyEvent)event).getCharacter().equals(":"))
        {
            System.out.println("Переход в командный режим: " + ((KeyEvent)event).getCharacter() + " type: " + event.getTarget().getClass().getName());
            
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
