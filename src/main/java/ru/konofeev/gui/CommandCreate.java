package ru.konofeev.gui;

import javax.swing.JTextArea;
import ru.konofeev.db.NoteService; 

/**
 * Создать заметку
 */
public class CommandCreate implements CommandBase
{
    private static final String CREATE = "CREATE";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (commandText.toUpperCase().startsWith(CREATE))
        {
            try
            {
                createNote(commandText, mainWindow.getMainArea());
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * Создать заметку
     *
     * @param commandText Текст командной строки
     * @param mainArea Главная текстовая область
     */
    private void createNote(String commandText, JTextArea mainArea) throws Exception
    {
        String note = commandText.substring(CREATE.length() + 1);
        (new NoteService()).createNote(note);
        mainArea.append(note);
    }
}
