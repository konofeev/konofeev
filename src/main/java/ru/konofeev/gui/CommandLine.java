package ru.konofeev.gui;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ru.konofeev.core.Global;

/**
 * Главное окно приложения
 */
public class CommandLine extends TextField
{
    /**
     * Конструктор
     */
    public CommandLine()
    {
        setOnKeyPressed(this::processingKeyboard);
    }

    private void processingKeyboard(KeyEvent event)
    {
        if (event.getCode() == KeyCode.ENTER)
        {
            Global.INSTANCE.getCommandManager().run();
        }
    }
}
