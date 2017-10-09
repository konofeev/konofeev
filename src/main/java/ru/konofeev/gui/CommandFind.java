package ru.konofeev.gui;

import java.util.List;
import javax.swing.JTextArea;
import ru.konofeev.db.NoteService; 
import ru.konofeev.entity.Note;

/**
 * Найти заметки
 */
public class CommandFind implements CommandBase
{
    private static final String FIND = "FIND";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (commandText.toUpperCase().startsWith(FIND))
        {
            try
            {
                findNote(commandText, mainWindow.getMainArea());
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * Найти заметку
     *
     * @param commandText Текст командной строки
     * @param mainArea Главная текстовая область
     */
    private void findNote(String commandText, JTextArea mainArea) throws Exception
    {
        String findText = commandText.substring(FIND.length() + 1);
        List<Note> noteList = (new NoteService()).find(findText);
        mainArea.append("Найдены заметки");
        mainArea.append(System.lineSeparator());
        mainArea.append(System.lineSeparator());
        for (Note note: noteList)
        {
            mainArea.append("[");
            mainArea.append(note.getIdentifier().toString());
            mainArea.append("] ");
            mainArea.append(note.getNote());
            mainArea.append(System.lineSeparator());
        }
    }
}
