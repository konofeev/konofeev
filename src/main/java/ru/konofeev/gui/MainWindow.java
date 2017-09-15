package ru.konofeev.gui;

import ru.konofeev.db.NoteService;
import ru.konofeev.entity.Note;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StringContent;
import javax.swing.text.StyleContext;
import java.util.List;

/**
 * Основное окно
 */
public class MainWindow
{
    private NoteService noteService = null;

    public MainWindow() throws Exception
    {
        noteService = new NoteService();
        initializeTempNotes();
        createMainWindow();
    }

    private void createMainWindow() throws Exception
    {
		JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.append("Заметки");
        textArea.append(System.lineSeparator());
        textArea.append(System.lineSeparator());
        List<Note> noteList = noteService.getNotes();
        for (Note note: noteList)
        {
            textArea.append("[");
            textArea.append(note.getIdentifier().toString());
            textArea.append("] ");
            textArea.append(note.getNote());
            textArea.append(System.lineSeparator());
        }
		JScrollPane editorScrollPane = new JScrollPane(textArea);
		frame.add(editorScrollPane, BorderLayout.CENTER);
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
}
