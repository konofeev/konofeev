package ru.konofeev.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;

/**
 * Главное окно приложения
 */
public class Editor extends HTMLEditor implements IEditor
{
    /**
     * Конструктор
     */
    public Editor()
    {
        // temp content
        setHtmlText("Html text");
    }

    @Override
    public void setHtmlText(String htmlText)
    {
        super.setHtmlText(htmlText);
    }
}
