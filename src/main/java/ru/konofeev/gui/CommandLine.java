package ru.konofeev.gui;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ru.konofeev.core.Global;
import ru.konofeev.core.CommandManager;

/**
 * Главное окно приложения
 */
public class CommandLine extends TextField
{
    private String commandText;

    /**
     * Конструктор
     */
    public CommandLine()
    {
        setOnKeyPressed(event -> processingKeyboard(event));
    }

    private void processingKeyboard(KeyEvent event)
    {
        if (event.getCode() == KeyCode.ENTER)
        {
            Global.INSTANCE.getCommandManager().run();
        }
    }
}
