package ru.konofeev.core;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.command.*;

/**
 * Менеджер команд
 */
public class CommandManager
{
    private List<Command> commandList;

    /**
     * Добавить команду
     *
     * @param command Команда
     */
    public void additionalCommand(Command command)
    {
        commandList.add(command);
    }

    /**
     * Получить список команд
     *
     * @return Список команд
     */
    public List<Command> getCommandList()
    {
        return commandList;
    }

    /**
     * Конструктор
     */
    public CommandManager()
    {
        commandList = new ArrayList<Command>();
        commandList.add(new CommandExit());
        commandList.add(new CommandClear());
        commandList.add(new CommandGet());
        commandList.add(new CommandHelp());
    }

    /**
     * Выполнить
     */
    public void run()
    {
        for (Command command: commandList)
        {
            if (command.check())
            {
                command.run();
            }
        }
    }
}
