package ru.konofeev.gui;

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
}
