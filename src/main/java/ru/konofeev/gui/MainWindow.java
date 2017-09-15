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
import ru.konofeev.db.NoteService;
import ru.konofeev.entity.Note;

/**
 * Основное окно
 */
public class MainWindow
{
    private NoteService noteService = null;
    private JTextArea mainArea = null;
    private JTextField commandLine = null;

    public MainWindow() throws Exception
    {
        noteService = new NoteService();
        initializeTempNotes();
        createMainWindow();
    }

    private void createMainWindow() throws Exception
    {
		JFrame frame = new JFrame();
        mainArea = getMainArea();
        commandLine = getCommandLine();
		JScrollPane editorScrollPane = new JScrollPane(mainArea);
		frame.add(editorScrollPane, BorderLayout.CENTER);
        frame.add(commandLine, BorderLayout.SOUTH);
		frame.setSize(900, 500);
		frame.setLocation(150, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }

    private void initializeTempNotes() throws Exception
    {
        noteService.createNote("Одна из тестовых заметок");
        noteService.createNote("Ещё одна из тестовых заметок");
        noteService.createNote("Совсем другая заметка");
    }

    private JTextField getCommandLine() throws Exception
    {
        JTextField commandLine = new JTextField("Command line");
        commandLine.addActionListener
        (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    if (commandLine.getText().equalsIgnoreCase("clear"))
                    {
                        mainArea.setText("");
                    }
                    if (commandLine.getText().equalsIgnoreCase("exit"))
                    {
                        System.exit(0);
                    }
                    if (commandLine.getText().equalsIgnoreCase("get"))
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
                }
            }
        );
        return commandLine;
    }

    private JTextArea getMainArea() throws Exception
    {
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        printNotes(textArea);
        return textArea;
    }

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
}
