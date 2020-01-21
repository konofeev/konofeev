package ru.konofeev.core;

import ru.konofeev.gui.CommandLine;
import ru.konofeev.gui.Editor;
import ru.konofeev.gui.IEditor;
import ru.konofeev.db.NoteService;

import java.sql.SQLException;

/**
 * Глобализм
 */
public enum Global
{
    INSTANCE;

    private CommandLine commandLine;
    private IEditor editor;
    private CommandManager commandManager;
    private NoteService noteService;

    /**
     * Получить коммандную строку
     */
    public CommandLine getCommandLine()
    {
        if (commandLine == null)
        {
            commandLine = new CommandLine();
        }

        return commandLine;
    }

    /**
     * Получить редактируему область
     */
    public IEditor getEditor()
    {
        if (editor == null)
        {
            editor = new Editor();
        }

        return editor;
    }

    /**
     * Получить менеджер команд
     */
    public CommandManager getCommandManager()
    {
        if (commandManager == null)
        {
            commandManager = new CommandManager();
        }

        return commandManager;
    }

    /**
     * Получить сервис заметок
     */
    public NoteService getNoteService() throws SQLException, ClassNotFoundException
    {
        if (noteService == null)
        {
            noteService = new NoteService();
        }

        return noteService;
    }
}
