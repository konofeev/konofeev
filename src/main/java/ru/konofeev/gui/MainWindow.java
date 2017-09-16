package ru.konofeev.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StringContent;                                        
import javax.swing.text.StyleContext;
import ru.konofeev.db.NoteService; import ru.konofeev.entity.Note;

/**
 * Главное окно приложения
 */
public class MainWindow
{
    private NoteService noteService = null;
    private JTextArea mainArea = null;
    private JTextField commandLine = null;

    /**
     * Конструктор
     */
    public MainWindow() throws Exception
    {
        noteService = new NoteService();
        initializeTempNotes();
        createMainWindow();
    }

    /**
     * Создать главное окно
     */
    private void createMainWindow() throws Exception
    {
		JFrame frame = new JFrame();
        mainArea = getMainArea();
        commandLine = getCommandLine();
		JScrollPane editorScrollPane = new JScrollPane(mainArea);
		frame.add(editorScrollPane, BorderLayout.CENTER);
        frame.add(commandLine, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
		frame.setVisible(true);
    }

    /**
     * Инициализация временных заметок
     * Метод временный
     */
    private void initializeTempNotes() throws Exception
    {
        //noteService.createNote("Одна из тестовых заметок");
        //noteService.createNote("Ещё одна из тестовых заметок");
        //noteService.createNote("Совсем другая заметка");
    }

    /**
     * Получить командную строку
     */
    private JTextField getCommandLine() throws Exception
    {
        JTextField commandLine = new JTextField("Command line");
        commandLine.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    if (Command.CLEAR.name().equalsIgnoreCase(commandLine.getText()))
                    {
                        mainArea.setText("");
                    }
                    if (Command.EXIT.name().equalsIgnoreCase(commandLine.getText()))
                    {
                        System.exit(0);
                    }
                    if (Command.GET.name().equalsIgnoreCase(commandLine.getText()))
                    {
                        try
                        {
                            printNotes(mainArea);
                        }
                        catch (Exception exception)
                        {
                            System.out.println(exception.getMessage());
                        }
                    }
                    if (commandLine.getText().toUpperCase().startsWith(Command.CREATE.name().toUpperCase()))
                    {
                        try
                        {
                            createNote(commandLine.getText());
                        }
                        catch (Exception exception)
                        {
                            System.out.println(exception.getMessage());
                        }
                    }
                    if (commandLine.getText().toUpperCase().startsWith(Command.FIND.name().toUpperCase()))
                    {
                        try
                        {
                            findNote(commandLine.getText());
                        }
                        catch (Exception exception)
                        {
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            }
        );
        return commandLine;
    }

    /**
     * Получить основную тектовую область
     */
    private JTextArea getMainArea() throws Exception
    {
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        printNotes(textArea);
        return textArea;
    }

    /**
     * Напечатать заметки
     */
    private void printNotes(JTextArea mainArea) throws Exception
    {
        mainArea.append("Заметки");
        mainArea.append(System.lineSeparator());
        mainArea.append(System.lineSeparator());
        List<Note> noteList = noteService.getNotes();
        for (Note note: noteList)
        {
            mainArea.append("[");
            mainArea.append(note.getIdentifier().toString());
            mainArea.append("] ");
            mainArea.append(note.getNote());
            mainArea.append(System.lineSeparator());
        }
    }

    /**
     * Создать заметку
     *
     * @param commandText Текст командной строки
     */
    private void createNote(String commandText) throws Exception
    {
        String note = commandText.substring(Command.CREATE.name().length() + 1);
        noteService.createNote(note);
        mainArea.append(note);
    }

    /**
     * Найти заметку
     *
     * @param commandText Текст командной строки
     */
    private void findNote(String commandText) throws Exception
    {
        String findText = commandText.substring(Command.FIND.name().length() + 1);
        List<Note> noteList = noteService.find(findText);
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
