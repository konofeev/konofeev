package ru.konofeev.gui;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
		super("Command Line");
		keyPressed();
    }

	private void keyPressed()
	{
		setOnKeyPressed
		(
			new EventHandler<KeyEvent>()
			{
				@Override
				public void handle(KeyEvent keyEvent)
				{
					if (keyEvent.getCode().equals(KeyCode.ENTER))
					{
						System.out.println("enter");
					}
					System.out.println("key event");
					setPressed(false);
				}
			}
		);
	}
}
