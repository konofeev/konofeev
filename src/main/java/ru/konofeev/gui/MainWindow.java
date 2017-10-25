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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import ru.konofeev.db.NoteService; 
import ru.konofeev.entity.Note;

/**
 * Главное окно приложения
 */
public class MainWindow
{                                          

    private NoteService noteService;
    private JTextArea mainArea;
    private JTextField commandLine;
    private CommandManager commandManager;
    
    /**
     * Конструктор
     */
    public MainWindow() throws Exception
    {
        noteService = new NoteService();
        createMainWindow();
    }
    
    /**
     * Получить текстовую область
     */
    public JTextArea getMainArea()
    {
        return mainArea;
    }
    
    /**
     * Создать главное окно
     */
    private void createMainWindow() throws Exception
    {
        commandManager = new CommandManager(this);
    	JFrame frame = new JFrame();
        mainArea = createMainArea();
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
                    commandManager.run(commandLine.getText());
                }
            }
        );
        return commandLine;
    }
    
    /**
     * Создать основную тектовую область
     */
    private JTextArea createMainArea() throws Exception
    {
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    
        return textArea;
    }
}
