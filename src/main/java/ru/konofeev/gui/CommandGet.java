package ru.konofeev.gui;

import java.util.List;
import javax.swing.JTextArea;
import ru.konofeev.db.NoteService; 
import ru.konofeev.entity.Note;

/**
 * Получить заметки
 */
public class CommandGet implements CommandBase
{
    private static final String GET = "get";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (GET.equalsIgnoreCase(commandText))
        {
            mainWindow.getMainArea().setText("");

            try
            {
                printNotes(mainWindow.getMainArea());
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * Напечатать заметки
     *
     * @param mainArea Главная текстовая область
     */
    private void printNotes(JTextArea mainArea) throws Exception
    {
        mainArea.append("Заметки");
        mainArea.append(System.lineSeparator());
        mainArea.append(System.lineSeparator());
        List<Note> noteList = (new NoteService()).getNotes();

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
