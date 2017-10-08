package ru.konofeev.gui;

/**
 * Команда выхода
 */
public class CommandExit implements CommandBase
{
    @Override
    public void run(String commandText)
    {
        if (Command.EXIT.name().equalsIgnoreCase(commandText))
        {
            System.exit(0);
        }
    }
}
