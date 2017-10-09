package ru.konofeev.gui;

import java.util.*;

/**
 * Менеджер команд
 */
public class CommandManager
{
    MainWindow mainWindow;

    /**
     * Список команд
     */
    private List<CommandBase> commands;

    {
        commands = new ArrayList<>();
    }

    /**
     * Конструктор
     *
     * @param mainWindow Главное окно
     */
    public CommandManager(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
        commands.add(new CommandExit());
        commands.add(new CommandClear());
        commands.add(new CommandGet());
        commands.add(new CommandCreate());
        commands.add(new CommandFind());
        commands.add(new CommandDelete());
    }

    /**
     * Добавить команду
     *
     * @param command Команда
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
            command.run(commandText, mainWindow);
        }
    }
}
