package ru.konofeev.gui;

import java.util.*;

/**
 * Менеджер команд
 */
public class CommandManager
{
    /**
     * Список команд
     */
    private List<CommandBase> commands;

    {
        commands = new ArrayList<>();
    }

    /**
     * Конструктор
     */
    public CommandManager()
    {
        commands.add(new CommandExit());
    }

    /**
     * Добавить команду
     */
    public void additionalCommand(CommandBase command)
    {
        commands.add(command);
    }

    /**
     * Выполнить 
     * По сути действие делегируется каждой команде
     *
     * @param commandText Текст команды
     */
    public void run(String commandText)
    {
        for (CommandBase command: commands)
        {
            command.run(commandText);
        }
    }
}
