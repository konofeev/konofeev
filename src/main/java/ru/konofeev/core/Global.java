package ru.konofeev.core;

import ru.konofeev.gui.CommandLine;
import ru.konofeev.gui.Editor;
import ru.konofeev.core.CommandManager;
import ru.konofeev.db.NoteService;

/**
 * Глобализм
 */
public enum Global
{
    INSTANCE;

    private CommandLine commandLine;
    private Editor editor;
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
    public Editor getEditor()
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
    public NoteService getNoteService() throws Exception
    {
        if (noteService == null)
        {
            noteService = new NoteService();
        }

        return noteService;
    }
}
