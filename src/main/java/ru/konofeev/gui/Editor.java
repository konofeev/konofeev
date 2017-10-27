package ru.konofeev.gui;

import javafx.scene.web.HTMLEditor;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Главное окно приложения
 */
public class Editor extends HTMLEditor
{
	private String content;
    /**
     * Конструктор
     */
    public Editor()
    {
        setHtmlText("Html text");
		keyPressed();
    }

	private void keyPressed()
	{
		// Управление
		setOnKeyPressed
		(
			new EventHandler<KeyEvent>()
			{
				@Override
				public void handle(KeyEvent keyEvent)
				{
					//if (keyEvent.getCode().equals(KeyCode.ENTER))
					System.out.println("setOnKeyPressed");
					content = getHtmlText();
				}
			}
		);

		setOnKeyReleased
		(
			new EventHandler<KeyEvent>()
			{
				@Override
				public void handle(KeyEvent keyEvent)
				{
					//if (keyEvent.getCode().equals(KeyCode.ENTER))
					System.out.println("setOnKeyReleased");
					setHtmlText(content);
				}
			}
		);

	}
}
