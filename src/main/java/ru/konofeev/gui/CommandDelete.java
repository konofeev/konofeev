package ru.konofeev.gui;

import javax.swing.JTextArea;
import ru.konofeev.db.NoteService; 

/**
 * Создать заметку
 */
public class CommandDelete implements CommandBase
{
    private static final String DELETE = "DELETE";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (commandText.toUpperCase().startsWith(DELETE.toUpperCase()))
        {
            try
            {
                deleteNotes(mainWindow.getMainArea());
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * Удалить заметки
     *
     * @param mainArea Главная текстовая область
     */
    private void deleteNotes(JTextArea mainArea) throws Exception
    {
        (new NoteService()).delete();
        mainArea.setText("");
    }
}
